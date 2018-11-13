package com.sxt.sys.vo;

import com.sxt.sys.domian.Menu;

public class MenuVo extends Menu {
private Integer page;
private Integer rows;
public Integer getPage() {
	return page;
}
public void setPage(Integer page) {
	this.page = page;
}
public Integer getRows() {
	return rows;
}
public void setRows(Integer rows) {
	this.rows = rows;
}

}
