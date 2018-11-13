package com.sxt.sys.utils;

import java.util.List;

/**
 * 适应easyui的表格需要的json对象
 * @author LJH
 *
 */
public class DataGridView {
	
	private Long total;
	
	private List<?> rows;

	
	public DataGridView() {
		// TODO Auto-generated constructor stub
	}
	public DataGridView(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	

}
