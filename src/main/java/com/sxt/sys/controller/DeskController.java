package com.sxt.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.domian.News;
import com.sxt.sys.service.NewsService;

@Controller
@RequestMapping("desk")
public class DeskController {
	@Autowired
	private NewsService newsService;
       @RequestMapping("toDesk")
       public String toDesk(){
    	   return "system/mainDesk";
       }
       //查询新闻表单数据
       @RequestMapping("mainData")
       @ResponseBody
       public List<News> mainData(){
    	   return this.newsService.selectAllNews();
       }
       
       
       
       
       
       
       
       
       
}

