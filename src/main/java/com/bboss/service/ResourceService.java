package com.bboss.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bboss.VO.AuthDataVO;
import com.bboss.VO.AuthVO;
import com.bboss.VO.ResourceDataVO;
import com.bboss.dao.mysql.ResourceDao;
import com.bboss.model.Auth;
import com.bboss.model.PageBean;
import com.bboss.model.Resource;
import com.bboss.model.SysMenu;


@Service
public class ResourceService {
	
	@Autowired
	private ResourceDao resourceDao;

	
	//----------------以下权限管理-------------------
	
	public List<Resource> getResListByRoleId(String roleId, String resourceName, PageBean pageBean) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resourceName", resourceName);
		map.put("roleId", roleId);
		map.put("pageBean", pageBean);
		map.put("rows",pageBean.getRows());
		map.put("start",pageBean.getStart());
		List<Resource> dateList = resourceDao.getResListByRoleId(map);
		return dateList;
	}

	public int resourceCount(String roleId, String resourceName) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resourceName", resourceName);
		map.put("roleId", roleId);
		int count = resourceDao.resourceCount(map);
		return count;
	}

	/*public List<AuthDataVO> getListByParentId() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	public List<ResourceDataVO> getTreeGridResourceByParentId(String parentId, String roleId){
		//String sql="select * from t_auth where parentId=? ";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parentId", parentId);
		map.put("roleId", roleId);
		List<Resource> resources = resourceDao.getTreeGridResourceByParentId(map);
		List<ResourceDataVO> resList = new ArrayList<ResourceDataVO>();
		for (Resource resource : resources) {
			ResourceDataVO res1 = new ResourceDataVO();
			res1.setId(resource.getResourceId());
			res1.setText(resource.getResourceName());
			res1.setState(resource.getState());
			res1.setResourceCode(resource.getResourceCode());
			res1.setResourceAddr(resource.getResourceAddr());
			res1.setResourceDescription(resource.getResourceDescription());
			//auth1.setAuthDescription();
			resList.add(res1);
		}
		
		return resList;
	}
	
	public List<ResourceDataVO> getListByParentId(String parentId, String roleId){
		List<ResourceDataVO> resources =this.getTreeGridResourceByParentId(parentId,roleId);
		for (ResourceDataVO resource : resources) {
			if("open".equals(resource.getState())){
				continue;
			}else{
				resource.setChildren(getListByParentId(String.valueOf(resource.getId()), roleId));
			}
		}
		return resources;
	}
	
	
	
	public boolean isMenuLeaf(String resourceId){
		//String sql="select * from t_auth where parentId=?";
		int count = resourceDao.isMenuLeaf(resourceId);
		if(count == 0){
			return true;
		}
		return false;
		
	}

	public int menuSysUpdate(Resource resource) {
		int count = resourceDao.menuSysUpdate(resource);
		return count;
	}
	/**
	 * 更新菜单的状态
	 * @param state
	 * @param resourceId
	 * @return
	 */
	public int updateStateByMenuId(String state, String resourceId){
		//String sql="update t_auth set state=? where authId=?";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", state);
		map.put("resourceId", resourceId);
		int num = resourceDao.updateStateByMenuId(map);
		return num;
	}
	/**
	 * 更新资源的状态
	 * @param state
	 * @param resourceId
	 * @return
	 */
	public int updateResourceStateByResId(String state, String resId){
		//String sql="update t_auth set state=? where authId=?";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", state);
		map.put("resId", resId);
		int num = resourceDao.updateResourceStateByResId(map);
		return num;
	}
	/**
	 * 更新资源菜单的状态
	 * @param state
	 * @param resourceId
	 * @return
	 */
	public int updateResMenuStateByMenuId(String state, String menuId){
		//String sql="update t_auth set state=? where authId=?";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", state);
		map.put("menuId", menuId);
		int num = resourceDao.updateResMenuStateByMenuId(map);
		return num;
	}

	public int menuSysAdd(Resource resource, String roleId) {
	
		int add = resourceDao.menuSysAdd(resource);
		//int resourceId = resource.getResourceId();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleId", roleId);
		map.put("resId", resource.getResId());
		int count = resourceDao.addRoleRes(map);
		return add;
	}

	public int resourceAdd(Resource resource,int parentId) {
		//#{resourceName},'MENU_RIGHT',#{resourceAddr},#{resourceCode},#{parentId}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resourceName", resource.getResourceName());
		map.put("resourceAddr", resource.getResourceAddr());
		map.put("resourceCode", resource.getResourceCode());
		map.put("parentId", parentId);
		return resourceDao.resourceAdd(resource);
	}
	
	/**
	 * 资源菜单的添加
	 * @param resource
	 * @param parentId
	 * @return
	 */
	public int addResMenu(Resource resource,int parentId) {
		//#{resourceName},'MENU_RIGHT',#{resourceAddr},#{resourceCode},#{parentId}
		/*Map<String,Object> map = new HashMap<String,Object>();
		map.put("resourceName", resource.getResourceName());
		map.put("resourceAddr", resource.getResourceAddr());
		map.put("resourceCode", resource.getResourceCode());
		map.put("resourceDescription", resource.getResourceDescription());
		map.put("parentId", parentId);*/
		return resourceDao.addResMenu(resource);
	}

	public int resourceUpdate(Resource resource) {
		return  resourceDao.resourceUpdate(resource);
		
	}

	public Resource querySysMenuByMenuId(String resourceId) {
		return resourceDao.querySysMenuByMenuId(resourceId);
		
	}
	

	public int getResourceCountByParentId(String parentId) {
		return resourceDao.getResourceCountByParentId(parentId);
	}
	
	public int getResMenuCountByParentId(String parentId) {
		return resourceDao.getMenuCountByParentId(parentId);
	}
	
	public int getMenuCountByParentId(String parentId) {
		return resourceDao.getMenuCountByParentId(parentId);
	}

	public int resourceDelete(String resId) {
		return resourceDao.resourceDelete(resId);
	}
	
	public int resMenuDelete(String menuId) {
		return resourceDao.resMenuDelete(menuId);
	}
	
	
	public int menuDelete(String resourceId) {
		return resourceDao.menuDelete(resourceId);
	}

	
	//----------------以下鉴权-------------------
	
	
	public List<Resource> findResourcesByRoleId(List<Integer> roleIds) {
		//Map<String,Object> parameterMap = new HashMap<String,Object>();
		//parameterMap.put("roleIds", roleIds);
		return resourceDao.findResourcesByRoleId(roleIds);
	}

	public List<SysMenu> findMenuByResIds(List<Integer> resIds) {
		return resourceDao.findMenuByResIds(resIds);
	}

	public List<ResourceDataVO> getComboList(String roleId) {
		//该角色已有的
		List<Resource> resCheckList =  resourceDao.getCheckComboList(roleId);
		List<Resource> resList =  resourceDao.getResourceList();
		List<ResourceDataVO> dataList = new ArrayList<ResourceDataVO>();
		for (Resource resource : resList) {
			ResourceDataVO data = new ResourceDataVO();
			data.setId(resource.getResourceId());
			data.setText(resource.getResourceName());
			for (Resource res : resCheckList) {
				if(res.getResourceId() == resource.getResourceId()){
					data.setChecked(true);
				}
			}
			//"state":"open",
			data.setState("open");
			data.setIconCls("icon-blank");
			dataList.add(data);
		}
		return dataList;
	}

	/*public List<AuthVO> getCheckedResourcesByParentId(int parentId, List<Integer> resourceIdList) {
			List<AuthVO> resources = this.getCheckedResByParentId(parentId,resourceIdList);
			//List<AuthVO> authList = new ArrayList<AuthVO>();
			for (AuthVO res : resources) {
				
				auth1.setId(auth.getAuthId());
				auth1.setText(auth.getAuthName());
				auth1.setIconCls(auth.getIconCls());
				if("open".equals(res.getState())){
					continue;
				}else{
					List<AuthVO> authList1 = getCheckedResourcesByParentId(res.getId(),resourceIdList);
					res.setChildren(authList1);
				}
			
			}
			return resources;
	}
	
	public List<AuthVO> getCheckedResByParentId(int parentId,List<Integer> resourceIdList){
		
		List<Resource> resList = resourceDao.getCheckedResByParentId(parentId);
		List<AuthVO> authList = new ArrayList<AuthVO>();
		//String sql="select * from t_auth where parentId=? ";
		for (Resource resource : resList) {
			AuthVO resource1 = new AuthVO();
			resource1.setId(resource.getResId());
			resource1.setText(resource.getResourceName());
			resource1.setState(resource.getState());
			//auth1.setIconCls(re.getIconCls());
			if(ObjectUtil.existStrArr(auth.getAuthId()+"", authIds.split(","))){
				
				auth1.setChecked(true);
			}
			for (Integer resourceId : resourceIdList) {
				if(resource.getResId() == resourceId){
					resource1.setChecked(true);
				}
			}
			auth1.setAuthPath(auth.getAuthPath());
			authList.add(auth1);
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("authPath",auth.getAuthPath());
			resource1.setAttributes(map1);
			authList.add(resource1);
		}
		
		return authList;
	}*/
	
	/**
	 * 授权弹出框显示所有的菜单资源，已将选中当前角色所拥有的资源菜单
	 * @param parentId
	 * @param resourceIdList
	 * @return
	 */
	public List<AuthVO> getCheckedResourcesMenuByParentId(int parentId, List<Integer> resourceIdList) {
		List<AuthVO> resources = this.getCheckedResMenuByParentId(parentId, resourceIdList);
		// List<AuthVO> authList = new ArrayList<AuthVO>();
		for (AuthVO res : resources) {

			/*
			 * auth1.setId(auth.getAuthId()); auth1.setText(auth.getAuthName());
			 * auth1.setIconCls(auth.getIconCls());
			 */
			if ("open".equals(res.getState())) {
				continue;
			} else {
				List<AuthVO> authList1 = getCheckedResourcesMenuByParentId(res.getId(), resourceIdList);
				res.setChildren(authList1);
			}

		}
		return resources;
	}

	public List<AuthVO> getCheckedResMenuByParentId(int parentId, List<Integer> resourceIdList) {

		List<Resource> resList = resourceDao.getCheckedResMenuByParentId(parentId);
		List<AuthVO> authList = new ArrayList<AuthVO>();
		// String sql="select * from t_auth where parentId=? ";
		for (Resource resource : resList) {
			AuthVO resource1 = new AuthVO();
			resource1.setId(resource.getResourceId());
			resource1.setText(resource.getResourceName());
			resource1.setState(resource.getState());
			// auth1.setIconCls(re.getIconCls());
			/*
			 * if(ObjectUtil.existStrArr(auth.getAuthId()+"",
			 * authIds.split(","))){
			 * 
			 * auth1.setChecked(true); }
			 */
			for (Integer resourceId : resourceIdList) {
				if (resource.getResourceId() == resourceId) {
					resource1.setChecked(true);
				}
			}
			/*
			 * auth1.setAuthPath(auth.getAuthPath()); authList.add(auth1);
			 */
			/*
			 * Map<String,Object> map1 = new HashMap<String,Object>();
			 * map1.put("authPath",auth.getAuthPath());
			 * resource1.setAttributes(map1);
			 */
			authList.add(resource1);
		}

		return authList;
	}

	public List<ResourceDataVO> getResListByParentId(Integer parentId) {
		List<ResourceDataVO> resList =this.getTreeGridResByParentId(parentId);
		for (ResourceDataVO res : resList) {
			if("open".equals(res.getState())){
				continue;
			}else{
				res.setChildren(getResListByParentId(res.getId()));
			}
		}
		return resList;
	}
	
	public List<ResourceDataVO> getTreeGridResByParentId(Integer parentId){
		//String sql="select * from t_auth where parentId=? ";
		List<Resource> resourceList = resourceDao.getCheckedResByParentId(parentId);
		List<ResourceDataVO> resList = new ArrayList<ResourceDataVO>();
		for (Resource resource : resourceList) {
			ResourceDataVO res1 = new ResourceDataVO();
			res1.setId(resource.getResId());
			res1.setText(resource.getResourceName());
			res1.setState(resource.getState());
			res1.setResourceCode(resource.getResourceCode());
			res1.setResourceAddr(resource.getResourceAddr());
			res1.setResourceDescription(resource.getResourceDescription());
			resList.add(res1);
		}
		
		return resList;
	}
	
	
	public List<ResourceDataVO> getResMenuListByParentId(Integer parentId) {
		List<ResourceDataVO> resList =this.getTreeMenuGridResByParentId(parentId);
		for (ResourceDataVO res : resList) {
			if("open".equals(res.getState())){
				continue;
			}else{
				res.setChildren(getResMenuListByParentId(res.getId()));
			}
		}
		return resList;
	}
	
	public List<ResourceDataVO> getTreeMenuGridResByParentId(Integer parentId){
		//String sql="select * from t_auth where parentId=? ";
		List<Resource> resourceList = resourceDao.getCheckedResMenuByParentId(parentId);
		List<ResourceDataVO> resList = new ArrayList<ResourceDataVO>();
		for (Resource resource : resourceList) {
			ResourceDataVO res1 = new ResourceDataVO();
			res1.setId(resource.getResourceId());
			res1.setText(resource.getResourceName());
			res1.setState(resource.getState());
			res1.setResourceCode(resource.getResourceCode());
			res1.setResourceAddr(resource.getResourceAddr());
			res1.setResourceDescription("");
			resList.add(res1);
		}
		
		return resList;
	}

	public int delResRoleByRoleId(String roleId) {
		return resourceDao.delResRoleByRoleId(roleId);
		
	}

	public int addResRole(Integer resId, Integer roleId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resId", resId);
		map.put("roleId", roleId);
		return resourceDao.addResRole(map);
		
	}

	
	
	/**
	 * 判断当前资源是否为父节点
	 * @param parentId
	 * @return
	 */
	public boolean isResourceLeaf(String resId) {
		//String sql="select * from t_auth where parentId=?";
		int count = resourceDao.isResourceLeaf(resId);
		if(count == 0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 判断当前资源菜单是否为父节点
	 * @param parentId
	 * @return
	 */
	public boolean isResMenuLeaf(String resourceId) {
		//String sql="select * from t_auth where parentId=?";
		int count = resourceDao.isResMenuLeaf(resourceId);
		if(count == 0){
			return true;
		}
		return false;
	}
	
	public Resource getParentResourceByResId(int resId) {
		// TODO Auto-generated method stub
		return resourceDao.getParentResourceByResId(resId);
	}

	public int queryResRelease(Integer resId) {
		return resourceDao.queryResRelease(resId);
	}

	public Resource getResourceByResId(Integer resId) {
		return resourceDao.getResourceByResId(resId);
	}

	public Resource getResourceByParentId(Integer parentId) {
		return resourceDao.getResourceByParentId(parentId);
	}

	public int addMenu(Resource reource, String roleId) {
		return resourceDao.addMenu(reource);
		
	}

	public List<Integer> getResMenuByRoleId(int roleId) {
		return resourceDao.getResMenuByRoleId(roleId);
	}
	
	//根据所给的menuIds 获取菜单信息
	public List<Resource> getMenuResByMenuId(String[] menuIds) {
		return resourceDao.getMenuResByMenuId(menuIds);
	}

	public int updateResMenu(Resource resource) {
		return resourceDao.updateResMenu(resource);
	}
	
	//添加资源
	public int addResource(Resource resource) {
		return resourceDao.addRource(resource);
		
	}
	

}
