package com.sxt.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.sys.domian.LogInfo;
import com.sxt.sys.mapper.LogInfoMapper;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.vo.LogInfoVo;
@Service
public class LogInfoServiceImpl implements LogInfoService {
    @Autowired
	private LogInfoMapper logInfoMapper;
	@Override
	public List<LogInfo> queryAllLog(LogInfoVo vo) {
		// TODO Auto-generated method stub
		return this.logInfoMapper.queryAllLog(vo);
	}
	@Override
	public int deleteByPrimaryKey(LogInfoVo vo) {
		// TODO Auto-generated method stub
		return this.logInfoMapper.deleteByPrimaryKey(vo.getId());
	}
	@Override
	public int insert(LogInfoVo vo) {
		// TODO Auto-generated method stub
		return this.logInfoMapper.insert(vo);
	}

}
