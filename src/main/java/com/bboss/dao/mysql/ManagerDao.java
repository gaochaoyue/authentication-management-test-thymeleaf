package com.bboss.dao.mysql;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.bboss.model.Manager;

@Mapper
public interface ManagerDao {

	Manager login(Manager manager);
	// String sql="select * from t_Manager where ManagerName=? and password=?";

	int modifyPassword(Manager manager);
	// String sql="update t_Manager set password=? where ManagerId=?";

	List<Manager> managerList(Map<String, Object> map);

	int managerCount(Manager manager);

	int managerAdd(Manager manager);
	// String sql="insert into t_Manager values(null,?,?,2,?,?)";

	int managerUpdate(Manager manager);
	// String sql="update t_Manager set
	// ManagerName=?,password=?,roleId=?,ManagerDescription=? where
	// ManagerId=?";

	Manager existManagerWithManagerName(String managerName);
	// String sql="select * from t_Manager where ManagerName=?";

	int managerDelete(Map<String, Object> map);
	// String sql="delete from t_Manager where ManagerId in ("+delIds+")";

	Manager existManagerWithRoleId(int roleId);
	// String sql="select * from t_Manager where roleId=?";

}
