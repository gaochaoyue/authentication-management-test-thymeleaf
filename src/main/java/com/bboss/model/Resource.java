package com.bboss.model;

import java.util.List;
/**
 * 菜单资源页面展示的实体类
 * @author admin
 *
 */
public class Resource {
	
	
	private Integer resourceId;  //sys_meun    meun_id
	
	private String resourceCode;
	
	private String resourceName;
	
	private String resourceAddr;
	
	private String resourceDescription;
	
	private Integer parentId;
	
	private String resType;
	
	private int resId;   //对应的资源Id
	
	private String state;
	
	private List<Resource> children;

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceAddr() {
		return resourceAddr;
	}

	public void setResourceAddr(String resourceAddr) {
		this.resourceAddr = resourceAddr;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Resource> getChildren() {
		return children;
	}

	public void setChildren(List<Resource> children) {
		this.children = children;
	}


	
	
}
