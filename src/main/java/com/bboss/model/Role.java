package com.bboss.model;



public class Role {

	private Integer roleId;
	private String roleName;
	private String authIds;
	private String roleType;  //角色类型
	private String roleDescription;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	
	public Role(Integer roleId, String authIds) {
		super();
		this.roleId = roleId;
		this.authIds = authIds;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getAuthIds() {
		return authIds;
	}
	public void setAuthIds(String authIds) {
		this.authIds = authIds;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
}
