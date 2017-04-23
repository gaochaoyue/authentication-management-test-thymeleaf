package com.bboss.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bboss.model.PageBean;
import com.bboss.model.Resource;
import com.bboss.model.Role;
import com.bboss.service.ManagerService;
import com.bboss.service.ResourceService;
import com.bboss.service.RoleService;
import com.bboss.util.JsonUtil;
import com.bboss.util.ObjectUtil;

/**
 * 用户角色的处理
 * @author admin
 *
 */
@Controller
@RequestMapping("/role")
public class RoleAction{
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 下拉选项
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/comBoList")
	public String comBoList(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		//jsonMap.put("roleId", "");
		//jsonMap.put("roleName", "请选择...");
		String pageType = request.getParameter("pageType");
		List<Role> dataList= new ArrayList<Role>();
		Role role = new Role();
		role.setRoleId(0);
		role.setRoleName("请选择...");
		List<Role> roleList = roleService.roleList(null, new Role(),pageType);
		dataList.add(role);
		dataList.addAll(roleList);
		//jsonMap.put("roleList", dataList2);
		return JsonUtil.object2Json(dataList);
		
	}
	
	/**
	 * 当前下拉框只有跨省数据服务系统的角色
	 * @param request
	 * @param response
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/searchRoleList")
	public String searchRoleList(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		//jsonMap.put("roleId", "");
		//jsonMap.put("roleName", "请选择...");
		List<Role> dataList= new ArrayList<Role>();
		Role role = new Role();
		role.setRoleId(0);
		role.setRoleName("请选择...");
		List<Role> roleList = roleService.roleList(null, new Role());
		dataList.add(role);
		dataList.addAll(roleList);
		//jsonMap.put("roleList", dataList2);
		return JsonUtil.object2Json(dataList);
		
	}
	*/
	
	@ResponseBody
	@RequestMapping("/list")
	public String roleList(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
	    String page = request.getParameter("page");
	    String rows = request.getParameter("rows");
	    Role role = new Role();
	    String s_roleName = request.getParameter("s_roleName");
	    String pageType = request.getParameter("pageType");
	    if (ObjectUtil.isNotEmpty(s_roleName)) {
	      role.setRoleName(s_roleName);
	    }
	    PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
	    int total = roleService.roleCount(role,pageType);
	    jsonMap.put("rows", roleService.roleList(pageBean,role,pageType));
	    jsonMap.put("total", Integer.valueOf(total));
	    return JsonUtil.object2Json(jsonMap);
	    
		
	}
	
	
	@ResponseBody
	@RequestMapping("/delete")
	public String roleDelete(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String delIds = request.getParameter("delIds");
		
	      String[] roleIds = delIds.split(",");
	      for (int i = 0; i < roleIds.length; i++) {
	    	  int roleId= Integer.valueOf(roleIds[i]);
	        boolean f = managerService.existManagerWithRoleId(roleId);
	        if (f) {
	          jsonMap.put("errorIndex", i);
	          jsonMap.put("errorMsg", "角色下面有用户，不能删除！");
	          return JsonUtil.object2Json(jsonMap);
	        }
	      }
	      int delNums = roleService.roleDelete(delIds);
	      if (delNums > 0) {
	    	  jsonMap.put("success", Boolean.valueOf(true));
	    	  jsonMap.put("delNums", Integer.valueOf(delNums));
	      } else {
	    	  jsonMap.put("errorMsg", "删除失败");
	      }
	      return JsonUtil.object2Json(jsonMap);
		     
	}
	
	
	@ResponseBody
	@RequestMapping("/save")
	public String roleSave(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String roleName = request.getParameter("roleName");
	    String roleDescription = request.getParameter("roleDescription");
	    String roleId = request.getParameter("roleId");
	    String roleType = request.getParameter("roleType");
	    Role role = new Role();
	    role.setRoleType(roleType);
	    role.setRoleDescription(roleDescription);
	    role.setRoleName(roleName);
	    if (ObjectUtil.isNotEmpty(roleId)) {
	      role.setRoleId(Integer.parseInt(roleId));
	    }
	      int saveNums = 0;
	      if (ObjectUtil.isNotEmpty(roleId))
	        saveNums = roleService.roleUpdate(role);
	      else {
	        saveNums = roleService.roleAdd(role);
	      }
	      if (saveNums > 0) {
	    	  jsonMap.put("success", Boolean.valueOf(true));
	      } else {
	    	  jsonMap.put("success", Boolean.valueOf(true));
	    	  jsonMap.put("errorMsg", "保存失败");
	      }
	      return JsonUtil.object2Json(jsonMap);
	}
	
	@ResponseBody
	@RequestMapping("/auth")
	public String roleAuth(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String roleId = request.getParameter("roleId");
	    String authIdsParam = request.getParameter("authIds");
	    //Role role = new Role(Integer.parseInt(roleId), authIds);
	    //删除所有的已有的权限
	    roleService.delRoleAuth(roleId);
	    int addNums = 0;
	    //添加新的权限
	    String[] authIds = authIdsParam.split(",");
	    for (String authId : authIds) {
	    	addNums += roleService.addRoleAuth(Integer.valueOf(roleId),Integer.valueOf(authId));
		}
	      
	      if (addNums > 0)
	    	  jsonMap.put("success", Boolean.valueOf(true));
	      else {
	    	  jsonMap.put("errorMsg", "授权失败");
	      }
	      return JsonUtil.object2Json(jsonMap);
	    
	}
	
	/**
	 * 给客户授权(分配资源权限)
	 * @param request
	 * @param response
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping("/saveResource")
	public String saveResource(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String roleId = request.getParameter("roleId");
		String resourceIdsParams = request.getParameter("resourceIds");
		
		int  num = 0;
		
		//查询该角色目前拥有的资源
		List<Integer> roleIds = new ArrayList<Integer>();
		roleIds.add(Integer.valueOf(roleId));
		List<Resource> resources = resourceService.findResourcesByRoleId(roleIds);
		//List<Integer> roleIds = new ArrayList<Integer>();
		List<Integer> resIds = new ArrayList<Integer>();
		//存放授权后和未授权之前资源重叠的资源
		List<Integer> resIds1 = new ArrayList<Integer>();
		for (Resource resource : resources) {
			//将以有的资源存放到resIds中
			resIds.add(resource.getResId());
		}
		
		//清除角色已有的资源，然后在根据获取的resourceIds给角色授予资源
		//根据roleId删除角色对应的资源关系
		
		resourceService.delResRoleByRoleId(roleId);
		String[] resIdArray = resourceIdsParams.split(",");
		for (String resId : resIdArray) {
			num = resourceService.addResRole(resId,roleId);
		}
		//授权得到的
		for (String resIdPar : resIdArray) {
			for (Integer resId : resIds) {
				if(Integer.valueOf(resIdPar) == resId){
					resIds1.add(resId);
				}
			}
		}
		resIds.removeAll(resIds1);
		//resIds就是新加的资源
		//添加菜单为角色
		for (Integer resId : resIds) {
			Resource reource = resourceService.getResourceByResId(resId);
			Resource parentRes = resourceService.getResourceByParentId(reource.getParentId());
			//查看父级资源菜单的状态
			//resourceService.addMenu(reource);
			
			
		}
		
		//已有权限资源过滤
		List<Integer> roleIds = new ArrayList<Integer>();
		roleIds.add(Integer.valueOf(roleId));
		
		//授权的资源
		String[] authResources =  resourceIdParams.split(",");
		List<String> authResList = new ArrayList<String>();
		for (String resid: authResources) {
			authResList.add(resid);
		}
		//增加权限
		for (Iterator iter = authResList.iterator(); iter.hasNext();) {
			String idParam = (String) iter.next();
			for (Resource res : resources) {
				if(Integer.valueOf(idParam) == res.getResId()){
					iter.remove();
					break;
				}
			}
		}
		//int num = roleService.roleResourcesUpdate(roleId, authResList);
		if (num > 0)
			jsonMap.put("success", Boolean.valueOf(true));
		else {
			jsonMap.put("errorMsg", "授权失败");
		}
		return JsonUtil.object2Json(jsonMap);

	}*/
	
	
	/**
	 * 给客户授权(分配资源菜单,添加映射关系,addTo t_role_res)
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveResource")
	public String saveResource(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String roleId = request.getParameter("roleId");
		String menuIdsParam = request.getParameter("menuIds");
		/*
		//查询角色所拥有的资源目录对应的菜单
		List<Integer> menuIdList=resourceService.getResMenuByRoleId(Integer.parseInt(roleId));
		*/
		//
		
		//根据roleId删除角色对应的资源关系
		resourceService.delResRoleByRoleId(roleId);
		
		int  num = 0;
		//依据菜单id获取菜单信息
		String[] menuIds = menuIdsParam.split(",");
		List<Resource> resList = resourceService.getMenuResByMenuId(menuIds);
		List<Integer> resIdList = new ArrayList<Integer>(); 
		for (Resource res : resList) {
			resIdList.add(res.getResId());
		}
		for (Integer resId : resIdList) {
			num += resourceService.addResRole(resId,Integer.valueOf(roleId));
		}
		
		
		/*//查询该角色目前拥有的资源
		List<Integer> roleIds = new ArrayList<Integer>();
		roleIds.add(Integer.valueOf(roleId));
		List<Resource> resources = resourceService.findResourcesByRoleId(roleIds);
		//List<Integer> roleIds = new ArrayList<Integer>();
		List<Integer> resIds = new ArrayList<Integer>();
		//存放授权后和未授权之前资源重叠的资源
		List<Integer> resIds1 = new ArrayList<Integer>();
		for (Resource resource : resources) {
			//将以有的资源存放到resIds中
			resIds.add(resource.getResId());
		}
		
		//清除角色已有的资源，然后在根据获取的resourceIds给角色授予资源
		//根据roleId删除角色对应的资源关系
		
		resourceService.delResRoleByRoleId(roleId);
		String[] resIdArray = resourceIdsParams.split(",");
		for (String resId : resIdArray) {
			num = resourceService.addResRole(resId,roleId);
		}
		//授权得到的
		for (String resIdPar : resIdArray) {
			for (Integer resId : resIds) {
				if(Integer.valueOf(resIdPar) == resId){
					resIds1.add(resId);
				}
			}
		}
		resIds.removeAll(resIds1);
		//resIds就是新加的资源
		//添加菜单为角色
		for (Integer resId : resIds) {
			Resource reource = resourceService.getResourceByResId(resId);
			Resource parentRes = resourceService.getResourceByParentId(reource.getParentId());
			//查看父级资源菜单的状态
			//resourceService.addMenu(reource);
			
			
		}*/
		
		//已有权限资源过滤
		/*List<Integer> roleIds = new ArrayList<Integer>();
		roleIds.add(Integer.valueOf(roleId));
		
		//授权的资源
		String[] authResources =  resourceIdParams.split(",");
		List<String> authResList = new ArrayList<String>();
		for (String resid: authResources) {
			authResList.add(resid);
		}
		//增加权限
		for (Iterator iter = authResList.iterator(); iter.hasNext();) {
			String idParam = (String) iter.next();
			for (Resource res : resources) {
				if(Integer.valueOf(idParam) == res.getResId()){
					iter.remove();
					break;
				}
			}
		}*/
		//int num = roleService.roleResourcesUpdate(roleId, authResList);
		if (num > 0)
			jsonMap.put("success", Boolean.valueOf(true));
		else {
			jsonMap.put("errorMsg", "授权失败");
		}
		return JsonUtil.object2Json(jsonMap);

	}
	
	

	
}
