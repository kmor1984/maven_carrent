package com.sxt.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domian.LogInfo;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.LogInfoVo;

@Controller
@RequestMapping("LogInfo")
public class LogInfoController {
	@Autowired
	private LogInfoService logInfoService;
	
    @RequestMapping("toLogInfo")
	private String toLogInfo(){
	return "system/logInfo";
}
    //查询日志
    @RequestMapping("LogInfo")
    @ResponseBody
    private DataGridView LogInfo(LogInfoVo vo){
    	Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
    	List<LogInfo> list = this.logInfoService.queryAllLog(vo);
    	return new DataGridView(page.getTotal(),list);
    }
    //删除日志
    @RequestMapping("deleteLog")
    @ResponseBody
    private Boolean deleteLog (LogInfoVo vo){
    	int result= this.logInfoService.deleteByPrimaryKey(vo);
    	System.out.println(result);
    	return result>0?true:false;	
    }
    
}
