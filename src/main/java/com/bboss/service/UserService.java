package com.bboss.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bboss.dao.mysql.RoleDao;
import com.bboss.dao.mysql.UserMysqlDao;
import com.bboss.dao.vertica.UserVerticaDao;
import com.bboss.model.Manager;
import com.bboss.model.PageBean;
import com.bboss.model.UserInfo;
import com.bboss.util.ECPConstants;
import com.bboss.util.ObjectUtil;

@Service
public class UserService {

	
	@Autowired
	private UserMysqlDao userMysqlDao;
	
	/*@Autowired
	private UserVerticaDao userVerticaDao;*/
	
	@Autowired
	private RoleDao roleDao;
	
	
	
	/**
	 * 查找当前登陆用户的信息
	 * @param authNumber
	 * @return
	 */
	public UserInfo findUserInfo(String authNumber) {
		/*
		 * 从mysql查询是否存在  
		 * 	存在则返回数据
		 *  不存在从vertica数据库中查询用户是否存在
		 *  	存在则返回
		 *  	不存在返回user =null
		 */
		//目前是按前缀"E","M"等区分角色的，前缀为单字母的话，就确定了用户为单角色的
		/*String userType = authNumber.substring(0,1);
		String userNumber = authNumber.substring(1);*/
		String userNumber =  ObjectUtil.separateNumber(authNumber);
		String userType =  ObjectUtil.separateAlphabet(authNumber);
		List<Integer> roleIds = new ArrayList<Integer>(); 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userType", userType);
		map.put("authNumber", userNumber);
		UserInfo userInfo = userMysqlDao.findUserInfo(map);
		if(ObjectUtil.isEmpty(userInfo)){
			UserInfo newUser = new UserInfo();
			newUser.setUserType(userType);
			newUser.setAuthNumber(userNumber);
			newUser.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			//DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_VERTICA);
			//以下用户对角色为一对一
			if((ECPConstants.UserTag.EC).equals(userType)){
				//---------------userInfo = userVerticaDao.findEc(userNumber);
				if(ObjectUtil.isNotEmpty(userInfo)){
					//DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_MYSQL);  
					newUser.setAuthId(userInfo.getAuthId());
					newUser.setAuthName(userInfo.getAuthName());
					roleIds.add(ECPConstants.UserRoleType.EC);
					userMysqlDao.insertUserInfo(newUser);
					//return newUser;
				}
			}else if((ECPConstants.UserTag.KEHUJINGLI).equals(userType) || (ECPConstants.UserTag.YUNYINGJITUAN).equals(userType)) {
				int staffType = 0;
				int roleId = ECPConstants.UserRoleType.YUNYINGJITUAN;
				if(ECPConstants.UserTag.KEHUJINGLI.equals(userType)){
					staffType = 1;
				}
				Map<String,Object> map1 = new HashMap<String,Object>();
				map1.put("staffType", staffType);
				map1.put("userNumber", userNumber);
				//---------------userInfo = userVerticaDao.findManagerOrGroup(map1);
				if(ObjectUtil.isNotEmpty(userInfo)){
					//DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_MYSQL);  
					newUser.setAuthId(userInfo.getAuthId());
					newUser.setAuthName(userInfo.getAuthName());
					roleIds.add(roleId);
					userMysqlDao.insertUserInfo(newUser);
					//return newUser;
				}
			}else if((ECPConstants.UserTag.JIEKOUREN).equals(userType) || (ECPConstants.UserTag.ZIGUANZU).equals(userType)) {
				//---------------userInfo = userVerticaDao.findNewDedicatedLine(userNumber);
				int roleId = ECPConstants.UserRoleType.JIEKOUREN;
				if(ECPConstants.UserTag.ZIGUANZU.equals(userType)){
					roleId = ECPConstants.UserRoleType.ZIGUANZU;
				}
				if(ObjectUtil.isNotEmpty(userInfo)){
					//DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_MYSQL);  
					newUser.setAuthId(userInfo.getAuthId());
					newUser.setAuthName(userInfo.getAuthName());
					roleIds.add(roleId);
					userMysqlDao.insertUserInfo(newUser);
					//return newUser;
				}
			}else{
				return null;
			}
			//考虑了一个用户对应多个角色的问题
			for (Integer roleId : roleIds) {
				Map<String,Object> map2 = new HashMap<String,Object>();
				map2.put("userId", newUser.getUserId());
				map2.put("roleId", roleId);
				//向t_user_role表插入数据,保存用户角色的关系
				roleDao.addRoleUser(map2);
			}
			
			return newUser;
			
		}
		return userInfo;
	}



	public List<UserInfo> userList(PageBean pageBean, UserInfo userInfo) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("authName", userInfo.getAuthName());
		map.put("roleId", userInfo.getRoleIds());
		//map.put("roleId", manager.getRoleId());
		map.put("pageBean", pageBean);
		map.put("rows",pageBean.getRows());
		map.put("start",pageBean.getStart());
		return userMysqlDao.userList(map);
	}
	
	
	public int updateUserInfo(UserInfo userInfo) {
		 return userMysqlDao.updateUserInfo(userInfo);
	}
	
	/**
	 * 根据authName 查询当前用户是否存在
	 * @param authName
	 * @return
	 */
	public boolean existUserByUserId(String userId) {
		// TODO Auto-generated method stub
		int count = userMysqlDao.findUserByUserId(userId);
		if(count > 0){
			return true;
		}
		return false;
	}


	/**
	 * 向auth_user 添加客户
	 * @param userInfo
	 * @return
	 */
	public int insertUserInfo(UserInfo userInfo) {
		 return userMysqlDao.insertUserInfo(userInfo);
	}



	public int userCount(String authName, String roleId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("authName", authName);
		map.put("roleId", roleId);
		return userMysqlDao.userCount(map);
	}

	public int deleteUser(String[] userIds) {
		//String[] userIds = uIds.split(",");
		//String[] uIds = userIds.
		/*List<String> userIdList = new ArrayList<String>();
		int count = userIds.split(",").length;
		if(count == 1){
			userIdList.add(userIds);
		}else{*/
		//String[] uIds = userIds.split(",");
			/*for (String uId : uIds) {
				userIdList.add(uId);
			}
		}*/
		return userMysqlDao.deleteUser(userIds);
	}



	public int deleteUserRole(String[] userIds) {
		return userMysqlDao.deleteUserRole(userIds);
	}



	
	
	
	
	
	
	
}
	

