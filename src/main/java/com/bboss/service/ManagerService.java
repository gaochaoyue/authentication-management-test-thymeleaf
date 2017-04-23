package com.bboss.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bboss.dao.mysql.ManagerDao;
import com.bboss.model.Manager;
import com.bboss.model.PageBean;




@Service
public class ManagerService {
	
	@Autowired
	private ManagerDao managerDao;

	public Manager login(Manager managerParam){
		//manager resultmanager=null;
		//String sql="select * from t_manager where managerName=? and password=?";
		Manager manager = managerDao.login(managerParam);
		
		return manager;
	}
	
	public int modifyPassword(Manager manager){
		//String sql="update t_manager set password=? where managerId=?";
		return managerDao.modifyPassword(manager);
	}
	
	public List<Manager> managerList(PageBean pageBean,Manager manager){
		/*StringBuffer sb=new StringBuffer("select * from t_manager u ,t_role r where u.roleId=r.roleId and u.managerType!=1 ");
		if(StringUtil.isNotEmpty(manager.getmanagerName())){
			sb.append(" and u.managerName like '%"+manager.getmanagerName()+"%'");
		}
		if(manager.getRoleId()!=-1){
			sb.append(" and u.roleId="+manager.getRoleId());
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}*/
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("managerName", manager.getManagerName());
		map.put("roleId", manager.getRoleId());
		map.put("pageBean", pageBean);
		map.put("rows",pageBean.getRows());
		map.put("start",pageBean.getStart());
		return managerDao.managerList(map);
		
	}
	
	
	public int managerCount(Manager manager){
		/*StringBuffer sb=new StringBuffer("select count(*) as total from t_manager u ,t_role r where u.roleId=r.roleId and u.managerType!=1 ");
		if(StringUtil.isNotEmpty(manager.getmanagerName())){
			sb.append(" and u.managerName like '%"+manager.getmanagerName()+"%'");
		}
		if(manager.getRoleId()!=-1){
			sb.append(" and u.roleId="+manager.getRoleId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}*/
		return managerDao.managerCount(manager);
	}
	
	public int managerAdd(Manager manager){
		//String sql="insert into t_manager values(null,?,?,2,?,?)";
		/*PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, manager.getmanagerName());
		pstmt.setString(2, manager.getPassword());
		pstmt.setInt(3, manager.getRoleId());
		pstmt.setString(4, manager.getmanagerDescription());*/
		return managerDao.managerAdd(manager);
	}
	
	public int managerUpdate(Manager manager){
		//String sql="update t_manager set managerName=?,password=?,roleId=?,managerDescription=? where managerId=?";
		return managerDao.managerUpdate(manager);
	}
	
	
	public boolean existManagerWithManagerName(String managerName){
		//String sql="select * from t_manager where managerName=?";
		Manager manager = managerDao.existManagerWithManagerName(managerName);
		if(manager == null){
			return false;
		}
		return true;
	}
	
	public int managerDelete(String delIds){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("managerIds", delIds.split(","));
		//String sql="delete from t_manager where managerId in ("+delIds+")";
		return managerDao.managerDelete(map);
	}
	
	public boolean existManagerWithRoleId(int roleId){
		//String sql="select * from t_manager where roleId=?";
		Manager manager = managerDao.existManagerWithRoleId(roleId);
		if(manager == null){
			return false;
		}
		return true;
	}
}
