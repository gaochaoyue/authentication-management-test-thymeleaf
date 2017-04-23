package com.bboss.dao.mysql;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.bboss.model.Auth;

@Mapper
public interface AuthDao {

	List<Auth> getAuthByParentId(Map<String, Object> map);
	// String sql="select * from t_auth where parentId=? and authId in
	// ("+authIds+")";

	// Auth hasChildren(int parentId,String authIds);
	// String sql="select * from t_auth where parentId=? and authId in
	// ("+authIds+")";

	List<Auth> getCheckedAuthByParentId(int parentId);
	// String sql="select * from t_auth where parentId=? ";

	List<Auth> getTreeGridAuthByParentId(int parentId);
	// String sql="select * from t_auth where parentId=? ";

	int authAdd(Auth auth);
	// String sql="insert into t_auth values(null,?,?,?,?,'open',?)";

	int authUpdate(Auth auth);
	// String sql="update t_auth set
	// authName=?,authPath=?,authDescription=?,iconCls=? where authId=?";

	List<Auth> isLeaf(String authId);
	// String sql="select * from t_auth where parentId=?";

	int updateStateByAuthId(Map<String, Object> map);
	// String sql="update t_auth set state=? where authId=?";

	int authDelete(String authId);
	// String sql="delete from t_auth where authId=?";

	int getAuthCountByParentId(int parentId);
	// String sql="select count(*) as total from t_auth where parentId=?";

	int addRoleAuth(Integer athId, Integer rolId);

	int addRoleAuth(Map<String, Object> map);

	int deleteRoleAuthByAuthId(Integer authId);

}
