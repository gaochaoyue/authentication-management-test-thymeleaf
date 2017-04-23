package com.bboss.dao.mysql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bboss.model.UserInfo;


@Mapper
public interface UserMysqlDao {
	
	UserInfo findUserInfo(Map<String,Object> map);

	int insertUserInfo(UserInfo newUser);

	List<UserInfo> userList(Map<String, Object> map);

	int userCount(Map<String, Object> map);

	int updateUserInfo(UserInfo userInfo);

	int findUserByAuthName(String authName);

	int addUser(UserInfo userInfo);

	int findUserByUserId(String userId);

	int deleteUser(String[] userIds);
	
	int deleteUserRole(String[] userIds);
}
