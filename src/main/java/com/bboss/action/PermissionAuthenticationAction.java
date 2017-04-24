package com.bboss.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bboss.service.MessageService;
import com.bboss.model.ClientInfo;
import com.bboss.model.Resource;
import com.bboss.model.Role;
import com.bboss.model.SysMenu;
import com.bboss.model.UserInfo;
import com.bboss.model.message.MessageQuery;
import com.bboss.model.message.SysMessage;
import com.bboss.model.subscription.Subscription;
import com.bboss.service.ClientInfoService;
import com.bboss.service.ResourceService;
import com.bboss.service.RoleService;
import com.bboss.service.SubscriptionService;
import com.bboss.service.UserService;
import com.bboss.util.AESUtil;
import com.bboss.util.DateUtil;
import com.bboss.util.ECPConstants;
import com.bboss.util.JsonUtil;
import com.bboss.util.ObjectUtil;
import com.bboss.util.TokenUtil;


@RestController
@RequestMapping("/functionRight")
public class PermissionAuthenticationAction {
	
	private static transient Logger logger = LoggerFactory.getLogger(PermissionAuthenticationAction.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ClientInfoService clientInfoService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping(value="/menu",produces = "text/html;charset=UTF-8")
	public String  menu(HttpServletRequest request,HttpSession session){
		/**
		 * 用户校验
		 * 	 校验成功   
		 * 		查询用户权限(功能权限，用户权限)			
		 * 			不存在用户权限，根据ID注册角色与用户的对应关系
		 * 			存在用户权限  进入系统
		 * 	 校验失败   进入错误页
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		//获取参数
		String authNumber = request.getParameter("authNumber");
		String timestamp = request.getParameter("timestamp");
		String token = request.getParameter("token");
		String clientId = request.getParameter("clientId");
		
		//String sessionId=session.getId();
		
		logger.info("enter system index(authNumber="+authNumber+",timestamp="+timestamp+",token="+token+",clientId="+clientId+" )");
		
		
		
		//判断参数是否非空
		if(ObjectUtil.isEmpty(authNumber)||ObjectUtil.isEmpty(timestamp)||ObjectUtil.isEmpty(token)||ObjectUtil.isEmpty(clientId)){
			logger.info("message", "参数为空");
			map.put("message", "参数为空");
			map.put("code",ECPConstants.InterfaceCode.PARAMTER_NULL);
			return JsonUtil.object2Json(map);
		}
		
		/*
		 * 判断时间是否在5分钟内
		 */

		
		if(!DateUtil.judgmentDate(new Date(), timestamp)){
			map.put("message", "链接失效，请重新进入系统");
			map.put("code",ECPConstants.InterfaceCode.REQUEST_VERRIFY_ERROR);
			logger.info("fail to enter the system(时间戳未在5分钟内) , authNumber is "+authNumber +" and clientId is "+clientId+" timestamp ="+timestamp);
			return JsonUtil.object2Json(map);
		}
		
		/*
		 * 校验authId是否合法
		 */
		Pattern pattern = Pattern.compile(ECPConstants.SysPattern.AUTHID_PATTERN);
		Matcher matcher = pattern.matcher(authNumber);
		if(!matcher.matches()){
			//model.addAttribute("message", "authNumber验证失败");
			map.put("message", "authNumber验证失败");
			map.put("code",ECPConstants.InterfaceCode.REQUEST_VERRIFY_ERROR);
			logger.info("fail to enter the system (authId不合法), authNumber is "+authNumber +" and clientId is "+clientId);
			return JsonUtil.object2Json(map);
		}
		
		/*
		 * 校验token
		 */
		//根据clientId查询clientCode
		ClientInfo clientInfo = clientInfoService.getInfoByClientId(clientId);
		if(ObjectUtil.isEmpty(clientInfo)){
			map.put("message", "数据获取失败");
			map.put("code",ECPConstants.InterfaceCode.REQUEST_OBTAIN_ERROR);
			logger.info("fail to get the clientCode(未获取到数据) , authNumber is "+authNumber +" and clientId is "+clientId);
			return JsonUtil.object2Json(map);
		}
	
		/*
		 * 对clientCode使用AES解密
		 */
		 
		String clientCode = AESUtil.decryptAppoint(clientInfo.getClientCode(), ECPConstants.AesKey.CLIENT_CODE);
		
		//根据查询到的clientCode和timestamp生成token
		StringBuffer bf = new StringBuffer();
		bf.append(authNumber);
		bf.append(clientCode);
		bf.append(timestamp);
		
		String createToken = TokenUtil.generateToken(bf.toString());
		//用户传递token与生成token对比
		if(!createToken.equals(token)){
			map.put("message", "token验证失败");
			map.put("code",ECPConstants.InterfaceCode.REQUEST_VERRIFY_ERROR);
			//model.addAttribute("message", "token验证失败");
			
			logger.info("fail to get the clientCode (token验证失败), authNumber is "+authNumber +" and clientId is "+clientId);
			return JsonUtil.object2Json(map);
		}	
		
		logger.info("AuthenticationOk!! authNumber is "+authNumber +" and clientId is "+clientId);
		
		/*
		 *  校验通过  查询用户信息
		 * 
		 * 	用户权限成功 保存用户session 跳转主页
		 */
		/*String url = ECPConstants.InteferUrl.BASE_URL.concat("/user/userInfo") ; 
		String param = "authNumber="+authNumber;
		String result = HttpRequest.sendPost(url, param);
		
		if(ObjectUtil.isEmpty(result)){
			model.addAttribute("message", "数据获取失败");
			return "error";
		}*/
		
		UserInfo userInfo = userService.findUserInfo(authNumber);
		if(ObjectUtil.isEmpty(userInfo)){
			map.put("code", ECPConstants.InterfaceCode.REQUEST_INCORRECT);
			map.put("message", "用户不存在");
			return JsonUtil.object2Json(map);
		}
		
		/*
		 * 查询用户角色 
		 * 用户无角色时，根据ecid开头编码自动绑定角色
		 * 
		 * 绑定成功后返回用户权限
		 */
		List<Role> roleList= roleService.findUserRoleByUserId(userInfo.getUserId());
		List<Integer> roleIds = new ArrayList<Integer>();
		for(Role role :roleList){
			roleIds.add(role.getRoleId());
		}
		
		
		
		List<Resource> resourceList = resourceService.findResourcesByRoleId(roleIds);
		List<Integer> resIds = new ArrayList<Integer>();
		for(Resource res : resourceList){
			if((ECPConstants.ResType.MENU_RES).equals(res.getResType())){
				resIds.add(res.getResId());
			}
		}
		
		List<SysMenu> menuList = resourceService.findMenuByResIds(resIds);
		
		/*
		 * 如果是EC用户查询 订购
		 */
		//String userTag  = userInfo.getAuthType();
		String custId = userInfo.getAuthId();
		List<Subscription> subList = new ArrayList<Subscription>();
		for(Role role :roleList){
			if((ECPConstants.UserTag.EC).equals(role.getRoleType())){
				 // 查询订购数据
				//---------------subList = subscriptionService.findCustSubscriptions(custId);
			}
			break;
		}
		
		
		/*
		 * 查询用户未读消息
		 */
		MessageQuery query =new MessageQuery();
	    
	    query.setUserId(userInfo.getUserId());
	    query.setReadStatus(0);
	    List<SysMessage> messageList = messageService.selectMsgByCondition(query);
	    int count = 0;
	    if(ObjectUtil.isNotEmpty(messageList)){
	    	count = messageList.size();
	    }
	    
	    /*
	     * 组装json返回数据
	     */
	    
	    Map<String,Object> jsonMap = new HashMap<String,Object>();
	    jsonMap.put("userInfo", userInfo);
	    jsonMap.put("userMenu", menuList);
	    if(ObjectUtil.isNotEmpty(subList)){
	    	jsonMap.put("subList", subList);
	    }
	    map.put("messageCount", count);
		
		map.put("code", ECPConstants.InterfaceCode.SUCCESS);
		map.put("message", "请求成功");
		map.put("data", jsonMap);
		return JsonUtil.object2Json(map);
		
		
		
	}
	
	

}
