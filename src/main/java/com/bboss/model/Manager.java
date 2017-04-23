package com.bboss.model;

import java.io.Serializable;

public class  Manager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer managerId;
	private String managerName;
	private String password;
	private Integer managerType;
	private Integer roleId = -1;
	private String roleName;
	private String managerDescription;
	
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String managerName, String password) {
		super();
		this.managerName = managerName;
		this.password = password;
	}
	
	
	
	public Manager(String managerName, String password, int roleId,
			String managerDescription) {
		super();
		this.managerName = managerName;
		this.password = password;
		this.roleId = roleId;
		this.managerDescription = managerDescription;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getManagerType() {
		return managerType;
	}

	public void setManagerType(int managerType) {
		this.managerType = managerType;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getManagerDescription() {
		return managerDescription;
	}

	public void setManagerDescription(String managerDescription) {
		this.managerDescription = managerDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	

	
	
	
	

	
	
}
