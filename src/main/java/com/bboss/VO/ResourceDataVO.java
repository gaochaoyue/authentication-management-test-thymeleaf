package com.bboss.VO;

import java.util.List;
import java.util.Map;

import com.bboss.model.Auth;


/**
 * 数据网格模型
 * @author GAO
 *
 */
public class ResourceDataVO {
	
	private int id;
	private String text;
	private String state;
	private boolean checked;
	private String iconCls;
	private List<ResourceDataVO> children;
	private String resourceCode;
	private  String  resourceAddr;
	private String resourceDescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public List<ResourceDataVO> getChildren() {
		return children;
	}
	public void setChildren(List<ResourceDataVO> children) {
		this.children = children;
	}
	
	
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
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

	
}
