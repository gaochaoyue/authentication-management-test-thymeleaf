package com.bboss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bboss.VO.AuthDataVO;
import com.bboss.VO.AuthVO;
import com.bboss.model.Auth;
import com.bboss.model.Manager;
import com.bboss.service.AuthService;
import com.bboss.service.RoleService;
import com.bboss.util.ECPConstants;
import com.bboss.util.JsonUtil;
import com.bboss.util.ObjectUtil;


/**
 * 系统权限展示及其授权
 * @author admin
 *
 */
@Controller
@RequestMapping("/auth")
public class SysAuthAction{

	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthService authService;
	
	@ResponseBody
	@RequestMapping("/menu")
	public String menu(HttpServletRequest request, HttpServletResponse response){
		String parentIdParam=request.getParameter("parentId");
		int parentId = Integer.valueOf(parentIdParam);
		HttpSession session=request.getSession();
		Manager currentManager=(Manager)session.getAttribute("currentManager");
		List<Integer> authIds=roleService.getAuthIdByRoleId(currentManager.getRoleId());
		List<AuthVO> auths = authService.getAuthsByParentId(parentId,authIds);
		String json =  JsonUtil.object2Json(auths);
		return json;
		
	}
	@ResponseBody
	@RequestMapping("/authMenu")
	public String authMenu(HttpServletRequest request, HttpServletResponse response){
		String parentIdParam=request.getParameter("parentId");
		int parentId = Integer.valueOf(parentIdParam);
		String roleId=request.getParameter("roleId");
		List<Integer> authIdList=roleService.getAuthIdByRoleId(Integer.parseInt(roleId));
		List<AuthVO> auths=authService.getCheckedAuthsByParentId(parentId,authIdList);
		return JsonUtil.object2Json(auths);
		
	}
	@ResponseBody
	@RequestMapping("/authTreeGridMenu")
	public String authTreeGridMenu(HttpServletRequest request, HttpServletResponse response){
		String parentIdParam=request.getParameter("parentId");
		int parentId = Integer.valueOf(parentIdParam);
		List<AuthDataVO> auths = authService.getListByParentId(parentId);
		return JsonUtil.object2Json(auths);
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public String authSave(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String authId=request.getParameter("authId");
		String roleId=request.getParameter("roleId");
		String authName=request.getParameter("authName");
		String authPath=request.getParameter("authPath");
		String parentId =request.getParameter("parentId");
		String authDescription=request.getParameter("authDescription");
		String iconCls=request.getParameter("iconCls");
		Auth auth=new Auth(authName, authPath, authDescription, iconCls);
		boolean isLeaf = false;
		if(ObjectUtil.isNotEmpty(authId)){
			auth.setAuthId(Integer.parseInt(authId));
		}else{
			auth.setParentId(Integer.parseInt(parentId));
		}
		int saveNums=0;
		if(ObjectUtil.isNotEmpty(authId)){
			saveNums=authService.authUpdate(auth);
		}else{
			isLeaf=authService.isLeaf(parentId);
			if(isLeaf){
				authService.updateStateByAuthId("closed", parentId);
				saveNums=authService.authAdd(auth);
			}else{
				saveNums=authService.authAdd(auth);
			}
			if(!isLeaf){
				//给超级管理员增加权限
				//Integer athId = Integer.parseInt(authId);
				Integer rolId = Integer.parseInt(roleId);
				
				if(ECPConstants.UserType.SUPERADMIN.equals(roleService.getRoleNameById(rolId))){
					authService.addRoleAuth(auth.getAuthId(),rolId);
				}
				
			}
		}
		if(saveNums>0){
			jsonMap.put("success", true);
		}else{
			jsonMap.put("success", true);
			jsonMap.put("errorMsg", "保存失败");
		}
		return JsonUtil.object2Json(jsonMap);
		
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String authDelete(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String authId=request.getParameter("authId");
		String parentIdParam=request.getParameter("parentId");
		int parentId = Integer.valueOf(parentIdParam);
		int sonNum=-1;	
		if(!authService.isLeaf(authId)){
			jsonMap.put("errorMsg", "该菜单节点有子节点，不能删除！");
		}else{
			int delNums=0;
			sonNum=authService.getAuthCountByParentId(parentId);
			if(sonNum==1){
				authService.updateStateByAuthId("open", parentIdParam);
				delNums=authService.authDelete(authId);
			}else{
				delNums=authService.authDelete(authId);
			}
			if(delNums>0){
				//资源删除成功
				authService.deleteRoleAuthByAuthId(Integer.valueOf(authId));
				jsonMap.put("success", true);
			}else{
				jsonMap.put("errorMsg", "删除失败");
			}
		}
		return JsonUtil.object2Json(jsonMap);
	
	}	
	
	
}
