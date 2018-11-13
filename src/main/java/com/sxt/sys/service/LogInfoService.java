package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domian.LogInfo;
import com.sxt.sys.vo.LogInfoVo;

public interface LogInfoService {
	List<LogInfo> queryAllLog(LogInfoVo vo);
	int deleteByPrimaryKey(LogInfoVo vo);
	int insert(LogInfoVo vo);

}
