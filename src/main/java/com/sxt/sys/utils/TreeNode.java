package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

/*
 * 此类给左边的导航菜单所使用
 * 
 */
public class TreeNode {
private Integer  id;
private String  name;
private Boolean checked;
private Boolean  isParent;
private Boolean  open;
private String  href;
private String  icon;
private String  tabIcon;
private Integer  pId;
private String  text;
private List<TreeNode> children = new ArrayList<>();
//增加一个node节点id的属性check,作为结点被选中的标识

/*再生成一个有层级关系，且带选中属性的构造函数*/

//标准的josn构造方法

public TreeNode(Integer id, Integer pId, String text) {
	super();
	this.id = id;
	this.pId = pId;
	this.text = text;
}

public TreeNode(Integer id, String name, Boolean checked, Boolean isParent,
		Boolean open, String icon, Integer pId) {
	super();
	this.id = id;
	this.name = name;
	this.checked = checked;
	this.isParent = isParent;
	this.open = open;
	this.icon = icon;
	this.pId = pId;
}

public Boolean getChecked() {
	return checked;
}

public void setChecked(Boolean checked) {
	this.checked = checked;
}

public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public List<TreeNode> getChildren() {
	return children;
}
public void setChildren(List<TreeNode> children) {
	this.children = children;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Boolean getIsParent() {
	return isParent;
}
public void setIsParent(Boolean isParent) {
	this.isParent = isParent;
}
public Boolean getOpen() {
	return open;
}
public void setOpen(Boolean open) {
	this.open = open;
}
public String getHref() {
	return href;
}
public void setHref(String href) {
	this.href = href;
}
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
public String getTabIcon() {
	return tabIcon;
}
public void setTabIcon(String tabIcon) {
	this.tabIcon = tabIcon;
}
public Integer getpId() {
	return pId;
}
public void setpId(Integer pId) {
	this.pId = pId;
}
public TreeNode(Integer id, String name, Boolean isParent, Boolean open,
		String href, String icon, String tabIcon, Integer pId) {
	super();
	this.id = id;
	this.name = name;
	this.isParent = isParent;
	this.open = open;
	this.href = href;
	this.icon = icon;
	this.tabIcon = tabIcon;
	this.pId = pId;
}
public TreeNode() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "TreeNode [id=" + id + ", name=" + name + ", checked=" + checked
			+ ", isParent=" + isParent + ", open=" + open + ", href=" + href
			+ ", icon=" + icon + ", tabIcon=" + tabIcon + ", pId=" + pId
			+ ", text=" + text + ", children=" + children + "]";
}


}
