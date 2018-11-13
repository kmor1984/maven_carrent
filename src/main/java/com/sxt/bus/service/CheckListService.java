package com.sxt.bus.service;

import java.util.Map;
import com.sxt.bus.domian.CheckList;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CheckListVo;


public interface CheckListService {
	int deleteByPrimaryKey(String checkid);

    int insert(CheckListVo checkListVo);

    int insertSelective(CheckList record);

    CheckList selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(CheckList record);

    int updateByPrimaryKey(CheckList record);
    Map<String,Object> checkCreateBills(CheckListVo checkListVo);
    DataGridView queryAllChecks (CheckListVo checkListVo);
}
