package com.bboss.model;


/**
 * 菜单资源返回实体类
 * @author admin
 *
 */
public class SysMenu {
	
	private Long menuId;
	private String menuCode;
	private String menuName;
	private String menuAddr;
	private Long parentMenuId;
	private Long resId;
	private Long modelId;
	
	
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuAddr() {
		return menuAddr;
	}
	public void setMenuAddr(String menuAddr) {
		this.menuAddr = menuAddr;
	}
	
	public Long getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public Long getResId() {
		return resId;
	}
	public void setResId(Long resId) {
		this.resId = resId;
	}
	
	
}
