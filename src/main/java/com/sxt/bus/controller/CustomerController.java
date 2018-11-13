package com.sxt.bus.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.service.CustomerService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CustomerVo;



@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
    @RequestMapping("toCustomer")
	private String toCustomer(){
	return "business/customer";
}
   
    //查询用户
    @RequestMapping("queryAllCustomer")
    @ResponseBody
    private DataGridView queryAllCustomer(CustomerVo customerVo){
    	return this.customerService.queryAllCustomer(customerVo);
    }
    //删除用户
    @RequestMapping("delCustomer")
    @ResponseBody
    private Boolean delCustomer (CustomerVo customerVo){
    	int result= this.customerService.deleteByPrimaryKey(customerVo);
    	return result>0?true:false;	
    }
  //更改用户
    @RequestMapping("updateCustomer")
    @ResponseBody
    private Boolean updateCustomer (CustomerVo customerVo){
    	int result= this.customerService.updateByPrimaryKey(customerVo);
    	return result>0?true:false;	
    }
  //新增用户
    @RequestMapping("addCustomer")
    @ResponseBody
    private Boolean addCustomer (CustomerVo customerVo){
    	int result= this.customerService.insert(customerVo);
    	return result>0?true:false;	
    }
    
}
