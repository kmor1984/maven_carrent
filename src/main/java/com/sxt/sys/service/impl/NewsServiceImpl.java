package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.sys.domian.News;
import com.sxt.sys.mapper.NewsMapper;
import com.sxt.sys.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {
   @Autowired
	private NewsMapper newsMapper;
	@Override
	public List<News> selectAllNews() {
		// TODO Auto-generated method stub
		return this.newsMapper.selectAllNews();
	}

}
