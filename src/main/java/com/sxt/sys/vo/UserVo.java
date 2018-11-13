package com.sxt.sys.vo;

import com.sxt.sys.domian.User;

public class UserVo extends User{
	//分页参数
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
