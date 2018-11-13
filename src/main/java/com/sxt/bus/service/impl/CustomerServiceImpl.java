package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domian.Customer;
import com.sxt.bus.mapper.CustomerMapper;
import com.sxt.bus.service.CustomerService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CustomerVo;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
private CustomerMapper customerMapper; 
	@Override
	public DataGridView queryAllCustomer(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getRows());
		List<Customer> list=this.customerMapper.queryAllCustomer(customerVo);
		return new DataGridView(page.getTotal(),list) ;
	}

	@Override
	public int updateByPrimaryKey(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		
		return this.customerMapper.updateByPrimaryKey(customerVo);
	}

	@Override
	public int insert(Customer customerVo) {
		// TODO Auto-generated method stub
		return this.customerMapper.insert(customerVo);
	}

	@Override
	public int deleteByPrimaryKey(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		return this.customerMapper.deleteByPrimaryKey(customerVo.getIdentity());
	}

	@Override
	public Customer selectByIdentity(String identity) {
		// TODO Auto-generated method stub
		return this.customerMapper.selectByPrimaryKey(identity);
	}
	

}
