package com.sxt.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constant.SYS_Constants;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.UserVo;
@Controller
@RequestMapping("user")
public class UserController {
		@Autowired
		private UserService userService;
	    @RequestMapping("toUser")
		private String toUser(){
		return "system/user";
	}
	   
	    //查询用户
	    @RequestMapping("queryAllUser")
	    @ResponseBody
	    private DataGridView queryAllUser(UserVo userVo){
	    	return this.userService.queryAllUser(userVo);
	    }
	    //删除用户
	    @RequestMapping("delUser")
	    @ResponseBody
	    private Boolean delUser (UserVo userVo){
	    	int result= this.userService.deleteByPrimaryKey(userVo);
	    	return result>0?true:false;	
	    }
	  //更改用户
	    @RequestMapping("updateUser")
	    @ResponseBody
	    private Boolean updateUser (UserVo userVo){
	    	int result= this.userService.updateByPrimaryKey(userVo);
	    	return result>0?true:false;	
	    }
	  //新增用户
	    @RequestMapping("addUser")
	    @ResponseBody
	    private Boolean addUser (UserVo userVo){
	    	userVo.setPwd(SYS_Constants.PUBLIC_USERPWD_ONE);
	    	userVo.setType(SYS_Constants.PUBLIC_USERTYPE_TWO);
	    	int result= this.userService.insert(userVo);
	    	return result>0?true:false;	
	    }
}
