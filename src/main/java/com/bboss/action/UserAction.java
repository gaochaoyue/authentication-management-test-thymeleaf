package com.bboss.action;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bboss.model.PageBean;
import com.bboss.model.Role;
import com.bboss.model.UserInfo;
import com.bboss.service.RoleService;
import com.bboss.service.UserService;
import com.bboss.util.DateUtil;
import com.bboss.util.JsonUtil;
import com.bboss.util.ObjectUtil;


/**
 * 权限管理系统登录用户的管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/user")
public class UserAction{

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response){
		//request.setCharacterEncoding("utf-8");
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		UserInfo userInfo = new UserInfo();
		String authName=request.getParameter("authName");
		String roleId=request.getParameter("roleId");
		if(ObjectUtil.isNotEmpty(authName)){
			userInfo.setAuthName(authName);
		}
		if(ObjectUtil.isNotEmpty(roleId)){
			userInfo.setRoleIds(roleId);
		}
		/*if(ObjectUtil.isNotEmpty(roleId)){
			//userInfo.setAuthNumber(authNumber);
		}*/
		PageBean pageBean=new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		List<UserInfo> users = userService.userList(pageBean,userInfo);
		//List<UserInfo> userList = new ArrayList<UserInfo>();
		for (UserInfo user : users) {
			List<Role> roleList = roleService.findUserRoleByUserId(user.getUserId());
			String roleNames = "";
			String roleIds = "";
			int i = 0;
			for (Role role : roleList) {
				if(i<roleList.size()-1){
					roleNames += role.getRoleName()+",";
					roleIds += role.getRoleId()+",";
					i++;
				}else{
					roleNames += role.getRoleName();
					roleIds += role.getRoleId();
				}
			}
			user.setRoleIds(roleIds);
			user.setRoleNames(roleNames);
		}
		int total = userService.userCount(authName,roleId);
		jsonMap.put("rows", users);
		jsonMap.put("total", total);
		return JsonUtil.object2Json(jsonMap);
		
		
	}
	/**
	 * 修改或添加用户
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public String save(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String authName=request.getParameter("authName");
		String authNumber=request.getParameter("authNumber");
		String authId=request.getParameter("authId");
		//String userDescription=request.getParameter("userDescription");
		String userId=request.getParameter("userId");
		String roleIdsParam = request.getParameter("roleIds");
		UserInfo userInfo = new UserInfo();
		userInfo.setAuthId(authId);
		userInfo.setAuthName(authName);
		userInfo.setAuthNumber(authNumber);
		userInfo.setCreateTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		if(ObjectUtil.isNotEmpty(userId)){
			userInfo.setUserId(Long.parseLong(userId));
		}
		int saveNums=0;
		String[] roleIds = roleIdsParam.split(",");
		if(ObjectUtil.isNotEmpty(userId)){
			//用户存在，更新信息
			//List<Role> roleList = roleService.findUserRoleByUserId(Long.valueOf(userId));
			//先删除当前更新用户的所有角色
			roleService.delRoleUserByUserId(userId);
			//添加新的角色
			for (String roleId : roleIds) {
				roleService.addRoleUser(Integer.valueOf(roleId),userInfo.getUserId());
			}
			saveNums=userService.updateUserInfo(userInfo);
		}else{
			
			/*if(userService.existUserByUserId(userId)){
				saveNums=-1;
			}else{*/
				//用户不存在，新增
				//同时为新增用户添加角色信息
				saveNums=userService.insertUserInfo(userInfo);	
				for (String roleId : roleIds) {
					roleService.addRoleUser(Integer.valueOf(roleId),userInfo.getUserId());
				}
			//}
		}
		if(saveNums==-1){
			jsonMap.put("success", true);
			jsonMap.put("errorMsg", "客户信息存在");
		}else if(saveNums==0){
			jsonMap.put("success", true);
			jsonMap.put("errorMsg", "保存失败");
		}else{
			jsonMap.put("success", true);
		}
		return JsonUtil.object2Json(jsonMap);	
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String userIdsParam=request.getParameter("userIds");
		String[] userIds = userIdsParam.split(",");
 		int delNums = userService.deleteUser(userIds);
		//删除用户与角色的对应关系
		userService.deleteUserRole(userIds);
		if(delNums>0){
			jsonMap.put("success", true);
			jsonMap.put("delNums", delNums);
		}else{
			jsonMap.put("errorMsg", "删除失败");
		}
		return JsonUtil.object2Json(jsonMap);
	
		
	}		
	
	
	
	
		
	
}
