package com.bboss.VO;

import java.util.List;
import java.util.Map;

import com.bboss.model.Auth;


/**
 * 数据网格模型
 * @author GAO
 *
 */
public class AuthDataVO {
	
	private int id;
	private String text;
	private String state;
	private String iconCls;
	private boolean checked;
	private List<AuthDataVO> children;
	private  String  authPath;
	private String authDescription;
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
	public List<AuthDataVO> getChildren() {
		return children;
	}
	public void setChildren(List<AuthDataVO> children) {
		this.children = children;
	}
	public String getAuthPath() {
		return authPath;
	}
	public void setAuthPath(String authPath) {
		this.authPath = authPath;
	}
	public String getAuthDescription() {
		return authDescription;
	}
	public void setAuthDescription(String authDescription) {
		this.authDescription = authDescription;
	}
	
}
