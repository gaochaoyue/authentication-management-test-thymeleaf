package com.bboss.model;



import java.io.Serializable;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1479868737697012443L;
	
	private Long userId;
	private String authId;
	private String userType;   //登录用户对应的角色类型
	private String authName;
	private String authNumber;
	private String roleIds;
	private String roleNames;
	
	
	private String createTime;
	
	
	public String getAuthNumber() {
		return authNumber;
	}
	public void setAuthNumber(String authNumber) {
		this.authNumber = authNumber;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	
	
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", authId=" + authId + "]";
	}
	
	
}
