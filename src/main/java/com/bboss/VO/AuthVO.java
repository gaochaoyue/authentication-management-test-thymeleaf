package com.bboss.VO;

import java.util.List;
import java.util.Map;

import com.bboss.model.Auth;


/**
 * 树形网格模型
 * @author GAO
 *
 */
public class AuthVO {
	
	private int id;
	private String text;
	private String state;
	private String iconCls;
	private boolean checked;
	private List<AuthVO> children;
	private  Map<String,Object> attributes; 
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
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<AuthVO> getChildren() {
		return children;
	}
	public void setChildren(List<AuthVO> children) {
		this.children = children;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
