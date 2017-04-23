package com.bboss.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bboss.dao.mysql.RoleDao;
import com.bboss.model.PageBean;
import com.bboss.model.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	
	//-------------管理权限--------------------
	public String getRoleNameById(int roleId){
		//String sql="select roleName from t_role where roleId=?";
		return roleDao.getRoleNameById(roleId);
	}
	
	public List<Integer> getAuthIdByRoleId(int roleId){
		//String sql="select authIds from t_role where roleId=?";
		return roleDao.getAuthIdByRoleId(roleId);
	}
	
	public List<Role> roleList(PageBean pageBean,Role role,String pageType){
		//StringBuffer sb=new StringBuffer("select * from t_role");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName", role.getRoleName());
		map.put("pageBean", pageBean);
		map.put("pageType", pageType);
		if(pageBean != null){
			map.put("pageRows", pageBean.getRows());
			map.put("pageStart", pageBean.getStart());
		}
		return roleDao.roleList(map);
		
	}
	
	public int roleCount(Role role,String pageType){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName", role.getRoleName());
		map.put("pageType", pageType);
		return roleDao.roleCount(map);
		/*StringBuffer sb=new StringBuffer("select count(*) as total from t_role ");
		if(StringUtil.isNotEmpty(role.getRoleName())){
			sb.append(" and roleName like '%"+role.getRoleName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}*/
	}
	
	public int roleDelete(String delIds){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleIds", delIds.split(","));
		//String roleIds[]=delIds.split(",");
		return roleDao.roleDelete(map);
		//String sql="delete from t_role where roleId in ("+delIds+")";
	}
	
	public int roleAdd(Role role){
		//String sql="insert into t_role values(null,?,'',?)";
		return  roleDao.roleAdd(role);
	}
	
	public int roleUpdate(Role role){
		//String sql="update t_role set roleName=?,roleDescription=? where roleId=?";
		return  roleDao.roleUpdate(role);
	}
	/*
	public int roleAuthIdsUpdate(Role role){
		//String sql="update t_role set authIds=? where roleId=?";
		return  roleDao.roleAuthIdsUpdate(role);
	}
	*/
	
	public int addRoleAuth(Integer roleId,Integer authId){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleId", roleId);
		map.put("authId", authId);
		return  roleDao.addRoleAuth(map);
	}
	
	
	
	//------------------鉴权-----------------------
	public List<Role> findUserRoleByUserId(Long userId) {
		return roleDao.findUserRoleByUserId(userId);
	}

	public int roleResourcesUpdate(String roleId, List<String> resourceIds) {
		//String[] resourceIds = resourceIdParams.split(",");
		int count = 0;
		for (String resourceId : resourceIds) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resourceId", resourceId);
			map.put("roleId", roleId);
			int num = roleDao.roleResourcesUpdate(map);
			
			count += num;	
		}
		return count;
		 
	}

	public List<Integer> getResourceByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleDao.getResourceByRoleId(roleId);
	}
	
	

	/**
	 * 根据roleId 与 userId 添加对应的角色与用户映射关系
	 * @param roleId
	 * @param userId
	 */
	public void addRoleUser(Integer roleId, Long userId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleId", roleId);
		map.put("userId", userId);
		roleDao.addRoleUser(map);
		
	}
	
	/**
	 * 删除当前用户的角色对应关系
	 * @param userId
	 */
	public int delRoleUserByUserId(String userId) {
	  return  roleDao.delRoleUserByUserId(userId);
		
	}
	
	/**
	 * 删除角色对应的权限
	 * @param roleId
	 */
	public int delRoleAuth(String roleId) {
		 return  roleDao.delRoleAuth(roleId);
	}
}
