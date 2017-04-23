package com.bboss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bboss.VO.AuthDataVO;
import com.bboss.VO.AuthVO;
import com.bboss.VO.ResourceDataVO;
import com.bboss.model.Resource;
import com.bboss.service.ResourceService;
import com.bboss.service.RoleService;
import com.bboss.util.JsonUtil;
import com.bboss.util.ObjectUtil;







/**
 * 对角色资源的处理，添加或删除角所拥有的资源
 * @author admin
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceAction{

	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	//--------------系统资源维护-----------------
	/**
	 * 各角色的菜单资源网络树
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/resourceTreeGridMenu")
	public String authTreeGridMenu(HttpServletRequest request, HttpServletResponse response){
		String parentId=request.getParameter("parentId");
		String roleId=request.getParameter("roleId");
		//int parentId = Integer.valueOf(parentIdParam);
		List<ResourceDataVO> auths = resourceService.getListByParentId(parentId,roleId);
		return JsonUtil.object2Json(auths);
	}
	
	
	/**
	 * 修改角色菜单(对于各个角色的菜单目录只能修改，不能添加)  
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveMenuByRoleId",produces = "application/json; charset=UTF-8")
	public String resourceSave(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String resourceId=request.getParameter("resourceId");//菜单id
		String resourceName=request.getParameter("text");
		String resourceCode=request.getParameter("resourceCode");
		String resourceAddr=request.getParameter("resourceAddr");
		String parentId =request.getParameter("parentId");
		String roleId =request.getParameter("roleId");
		String resourceDescription=request.getParameter("resourceDescription");
		//String iconCls=request.getParameter("iconCls");
		Resource resource=new Resource();
		
		resource.setResourceName(resourceName);
		resource.setResourceCode(resourceCode);
		resource.setResourceAddr(resourceAddr);
		
		if(ObjectUtil.isNotEmpty(resourceDescription)){
			resource.setResourceDescription(resourceDescription);
		}else{
			resource.setResourceDescription("");
		}
		boolean isMenuLeaf = false;
		boolean isLeaf = false;
		if(ObjectUtil.isNotEmpty(resourceId)){
			resource.setResourceId(Integer.valueOf(resourceId));
		}else{
			resource.setParentId(Integer.valueOf(parentId));
		}
		int saveNums=0;
		if(ObjectUtil.isNotEmpty(resourceId)){
		//根据菜单id查询对应的资源
		//Resource resource1 = resourceService.querySysMenuByMenuId(resourceId);
		//resource.setResId(resource1.getResId());
		//resourceService.resourceUpdate(resource);
		//菜单的更新
		saveNums=resourceService.menuSysUpdate(resource);
		}else{
			isMenuLeaf=resourceService.isMenuLeaf(parentId);
			//Resource resource1 = resourceService.querySysMenuByMenuId(parentId);
			if(isMenuLeaf){
			
				//resourceService.updateResourceStateByResId("closed", String.valueOf(resource1.getResId()));
				resourceService.updateStateByMenuId("closed", parentId);
				//resourceService.resourceAdd(resource,resource1.getResId());
				saveNums=resourceService.menuSysAdd(resource,roleId);
			}else{
				//resourceService.resourceAdd(resource,resource1.getResId());
				saveNums=resourceService.menuSysAdd(resource,roleId);
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
	/**
	 * 删除资源
	 * @param request
	 * @param response
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/deleteResource")
	public String deleteResource(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String resId=request.getParameter("resId");
		String parentId=request.getParameter("parentId");
		//int parentId = Integer.valueOf(parentIdParam);
		int sonNum=-1;	
		if(!resourceService.isResourceLeaf(resId)){
			jsonMap.put("errorMsg", "该资源节点有子节点，不能删除！");
		}else{
			int delNums=0;
			sonNum=resourceService.getResourceCountByParentId(parentId);
			if(sonNum==1){
				//是子节点，而且只有一个
				resourceService.updateResourceStateByResId("open", parentId);
				delNums=resourceService.resourceDelete(resId);
			}else{
				//是字节点，而且有多个
				delNums=resourceService.resourceDelete(resId);
			}
			if(delNums>0){
				jsonMap.put("success", true);
			}else{
				jsonMap.put("errorMsg", "删除失败");
			}
		}
		return JsonUtil.object2Json(jsonMap);
	
	}*/
	
	/**
	 * 删除资源
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteResMenu")
	public String deleteResource(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String menuId=request.getParameter("menuId");
		String parentId=request.getParameter("parentId");
		//int parentId = Integer.valueOf(parentIdParam);
		int sonNum=-1;	
		if(!resourceService.isResMenuLeaf(menuId)){
			jsonMap.put("errorMsg", "该资源节点有子节点，不能删除！");
		}else{
			int delNums=0;
			sonNum=resourceService.getResMenuCountByParentId(parentId);
			if(sonNum==1){
				//是子节点，而且只有一个
				resourceService.updateResMenuStateByMenuId("open", parentId);
				delNums=resourceService.resMenuDelete(menuId);
			}else{
				//是字节点，而且有多个
				delNums=resourceService.resMenuDelete(menuId);
			}
			if(delNums>0){
				jsonMap.put("success", true);
			}else{
				jsonMap.put("errorMsg", "删除失败");
			}
		}
		return JsonUtil.object2Json(jsonMap);
	
	}
	
	
	/**
	 * 删除资源前查询资源有没有被释放
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryResRelease")
	public String queryResRelease(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String menuId=request.getParameter("menuId");
		//String parentId=request.getParameter("parentId");
		//int parentId = Integer.valueOf(parentIdParam);
		int num = 0;	
		//查询当前资源有没有被释放
		String[] menuIds = new String[]{menuId};
		List<Resource> resource = resourceService.getMenuResByMenuId(menuIds);
		num = resourceService.queryResRelease(resource.get(0).getResId());
		if(ObjectUtil.isEmpty(num)){
			jsonMap.put("code", 50000);
			jsonMap.put("message","数据异常");
			return JsonUtil.object2Json(jsonMap);
		}
		
		jsonMap.put("code", 10000);
		jsonMap.put("num", num);
		return JsonUtil.object2Json(jsonMap);
		
	}
	
	/*
	@ResponseBody
	@RequestMapping("/deleteMenu")
	public String deleteMenu(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String resourceId=request.getParameter("menuId");
		String parentId=request.getParameter("parentId");
		//int parentId = Integer.valueOf(parentIdParam);
		int sonNum=-1;	
		if(!resourceService.isMenuLeaf(resourceId)){
			jsonMap.put("errorMsg", "该资源节点有子节点，不能删除！");
		}else{
			int delNums=0;
			sonNum=resourceService.getMenuCountByParentId(parentId);
			if(sonNum==1){
				//是子节点，而且只有一个
				resourceService.updateStateByMenuId("open", parentId);
				delNums=resourceService.menuDelete(resourceId);
				//获取当前资源的节点
				Resource resource = resourceService.querySysMenuByMenuId(resourceId);
				//获取当前节点的父节点资源
				Resource parRes = resourceService.getParentResourceByResId(resource.getResId());
				//判断该资源的父节点的子节点的个数
				int number = resourceService.getResourceCountByParentId(String.valueOf(parRes.getResId()));
				//并且删除该资源
				resourceService.resourceDelete(String.valueOf(resource.getResId()));
				if(number == 1){
					resourceService.updateResourceStateByResId("open", String.valueOf(resource.getResId()));
				}
			}else{
				//是字节点，而且有多个
				delNums=resourceService.menuDelete(resourceId);
			}
			if(delNums>0){
				jsonMap.put("success", true);
			}else{
				jsonMap.put("errorMsg", "删除失败");
			}
		}
		return JsonUtil.object2Json(jsonMap);
	
	}
	*/
	
	
	/**
	 * 添加或修改资源菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveResMenu")
	public String saveResource(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> jsonMap = new HashMap<String, Object>(); 
		String menuId=request.getParameter("resourceId");
		String resourceName=request.getParameter("text");
		String resourceCode=request.getParameter("resourceCode");
		String resourceAddr=request.getParameter("resourceAddr");
		String parentId =request.getParameter("parentId");
		String resourceDescription=request.getParameter("resourceDescription");
		Resource resource=new Resource();
		
		resource.setResourceName(resourceName);
		resource.setResourceCode(resourceCode);
		resource.setResourceAddr(resourceAddr);
		if(ObjectUtil.isNotEmpty(resourceDescription)){
			resource.setResourceDescription(resourceDescription);
		}else{
			resource.setResourceDescription("");
		}
		
		
		boolean isResMenuLeaf = false;
		if(ObjectUtil.isNotEmpty(menuId)){
			resource.setResourceId(Integer.valueOf(menuId));
		}else{
			resource.setParentId(Integer.valueOf(parentId));
		}
		int saveNums=0;
		if(ObjectUtil.isNotEmpty(menuId)){
			//int resId = resourceService.querySysResId(resourceId);
			resource.setResourceId(Integer.valueOf(menuId));
			//resourceService.resourceUpdate(resource);
			saveNums=resourceService.updateResMenu(resource);
		}else{
			isResMenuLeaf=resourceService.isResMenuLeaf(parentId);
			if(isResMenuLeaf){
				resourceService.updateResMenuStateByMenuId("closed", parentId);
				//添加对应的资源
				resourceService.addResource(resource);
				int resId = resource.getResId();
				saveNums = resourceService.addResMenu(resource,Integer.valueOf(parentId));
				//saveNums=resourceService.resourceSysAdd(resource,roleId);
			}else{
				resourceService.addResource(resource);
				int resId = resource.getResId();
				saveNums = resourceService.addResMenu(resource,Integer.valueOf(parentId));
				//saveNums=resourceService.resourceSysAdd(resource,roleId);
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
	
	
	
	//--------------跨省数据服务资源维护-----------------
	@ResponseBody
	@RequestMapping("/comboList")
	public String comboList(HttpServletRequest request, HttpServletResponse response){
		//String parentId=request.getParameter("parentId");
		String roleId=request.getParameter("roleId");
		//int parentId = Integer.valueOf(parentIdParam);
		List<ResourceDataVO> resList = resourceService.getComboList(roleId);
		return JsonUtil.object2Json(resList);
	}
	
	/*
	@ResponseBody
	@RequestMapping("/resourceMenu")
	public String authMenu(HttpServletRequest request, HttpServletResponse response){
		String parentIdParam=request.getParameter("parentId");
		int parentId = Integer.valueOf(parentIdParam);
		String roleId=request.getParameter("roleId");
		List<Integer> resourceIdList=roleService.getResourceByRoleId(Integer.parseInt(roleId));
		List<AuthVO> auths=resourceService.getCheckedResourcesByParentId(parentId,resourceIdList);
		return JsonUtil.object2Json(auths);
		
	}*/
	/**
	 * 授权时的弹出对话框
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/resourceMenu")
	public String authMenu(HttpServletRequest request, HttpServletResponse response){
		String parentIdParam=request.getParameter("parentId");
		int parentId = Integer.valueOf(parentIdParam);
		String roleId=request.getParameter("roleId");
		//查询角色所拥有的资源目录对应的菜单
		List<Integer> resourceIdList=resourceService.getResMenuByRoleId(Integer.parseInt(roleId));
		List<AuthVO> auths=resourceService.getCheckedResourcesMenuByParentId(parentId,resourceIdList);
		return JsonUtil.object2Json(auths);
		
	}
	/**
	 * 展示所有资源的网络树
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/resourceTreeGrid")
	public String resourceTreeGridMenu(HttpServletRequest request, HttpServletResponse response){
		String parentIdParam=request.getParameter("parentId");
		Integer parentId = Integer.valueOf(parentIdParam);
		List<ResourceDataVO> auths = resourceService.getResListByParentId(parentId);
		return JsonUtil.object2Json(auths);
	}
	
	/**
	 * 展示所有资源对应的菜单网络树
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/resourceMenuTreeGrid")
	public String resourceMenuTreeGrid(HttpServletRequest request, HttpServletResponse response){
		String parentIdParam=request.getParameter("parentId");
		Integer parentId = Integer.valueOf(parentIdParam);
		List<ResourceDataVO> auths = resourceService.getResMenuListByParentId(parentId);
		return JsonUtil.object2Json(auths);
	}
	
	
	
	
}

