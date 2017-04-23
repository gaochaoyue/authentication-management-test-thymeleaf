package com.bboss.dao.mysql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bboss.model.Auth;
import com.bboss.model.Resource;
import com.bboss.model.SysMenu;

@Mapper
public interface ResourceDao {

	List<Resource> getResListByRoleId(Map<String, Object> map);

	int resourceCount(Map<String, Object> map);

	List<Resource> getTreeGridResourceByParentId(Map<String, Object> map);

	int isMenuLeaf(String resourceId);

	int menuSysUpdate(Resource resource);

	int updateStateByMenuId(Map<String, Object> map);
	
	int updateResourceStateByResId(Map<String, Object> map);
	
	int updateResMenuStateByMenuId(Map<String, Object> map);

	int addRoleRes(Map<String, Object> map);

	int menuSysAdd(Resource resource);

	int resourceAdd(Resource resource);
	
	int addResMenu(Resource resource);

	int resourceUpdate(Resource resource);

	Resource querySysMenuByMenuId(String resourceId);

	int getResourceCountByParentId(String parentId);
	
	int getMenuCountByParentId(String parentId);

	int resourceDelete(String resId);
	
	int menuDelete(String resourceId);
	
	int delResRoleByRoleId(String roleId);
	
	int addResRole(Map<String, Object> map);
	
	int addRource(Resource resource);

	// ------------------以下权限管理---------------------

	List<Resource> findResourcesByRoleId(List<Integer> roleIds);

	// 查询角色对应的菜单资源
	List<SysMenu> findMenuByResIds(List<Integer> resIds);

	List<Resource> getCheckComboList(String roleId);

	List<Resource> getResourceList();

	List<Resource> getCheckedResByParentId(Integer parentId);
	
	List<Resource> getCheckedResMenuByParentId(Integer parentId);

	int isResourceLeaf(String resId);
	
	int isResMenuLeaf(String resourceId);

	Resource getParentResourceByResId(int resId);

	int queryResRelease(Integer resId);

	Resource getResourceByResId(Integer resId);

	Resource getResourceByParentId(Integer parentId);

	int addMenu(Resource reource);
	
	List<Integer> getResMenuByRoleId(int roleId);

	List<Resource> getMenuResByMenuId(String[] menuIds);

	int updateResMenu(Resource resource);

	int resMenuDelete(String menuId);

	




	

	
	
	
	//查询ec系统下所有的资源
	//List<Resource> getTreeGridAuthByParentId(Integer parentId);

}
