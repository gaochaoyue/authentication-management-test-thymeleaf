package com.bboss.dao.mysql;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.bboss.model.Role;

@Mapper
public interface RoleDao {

	// ------------权限管理----------------------

	String getRoleNameById(int roleId);
	// String sql="select roleName from t_role where roleId=?";

	List<Integer> getAuthIdByRoleId(int roleId);
	// String sql="select authIds from t_role where roleId=?";

	List<Role> roleList(Map<String, Object> map);

	int roleCount(Map<String, Object> map);

	int roleDelete(Map<String, Object> map);
	// String sql="delete from t_role where roleId in ("+delIds+")";

	int roleAdd(Role role);
	// String sql="insert into t_role values(null,?,'',?)";

	int roleUpdate(Role role);
	// String sql="update t_role set roleName=?,roleDescription=? where
	// roleId=?";

	int roleAuthIdsUpdate(Role role);
	
	
	int addRoleAuth(Map<String, Object> map);
	// String sql="update t_role set authIds=? where roleId=?";

	// ----------------登录验证---------------------

	List<Role> findUserRoleByUserId(Long userId);

	void addRoleUser(Map<String, Object> map);
	
	int delRoleAuth(String roleId);
	
	/**
	 * 给角色授权
	 * @param map
	 * @return
	 */
	int roleResourcesUpdate(Map<String, Object> map);

	List<Integer> getResourceByRoleId(Integer roleId);

	int delRoleUserByUserId(String userId);

	

}
