package com.sxt.bus.service;
import com.sxt.bus.domian.Customer;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CustomerVo;


public interface CustomerService {
	DataGridView queryAllCustomer(CustomerVo customerVo);
	int deleteByPrimaryKey(CustomerVo customerVo);
	int updateByPrimaryKey(CustomerVo customerVo);
	int insert(Customer customerVo);
	Customer selectByIdentity(String identity);
}
