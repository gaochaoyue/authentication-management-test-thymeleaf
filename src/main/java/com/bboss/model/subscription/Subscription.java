package com.bboss.model.subscription;



import java.util.List;

import com.bboss.model.SysMenu;


public class Subscription {
	private String subscriptionId;
	private String subscriptionName;
	private String productName;
	private String displayName;
	private Integer prodType;
	
	
	private List<SysMenu> menuList;
	
	
	
	
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public List<SysMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getProdType() {
		return prodType;
	}
	public void setProdType(Integer prodType) {
		this.prodType = prodType;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	
	
}
