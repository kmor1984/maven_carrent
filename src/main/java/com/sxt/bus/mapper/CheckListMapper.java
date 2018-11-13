package com.sxt.bus.mapper;

import java.util.List;
import java.util.Map;

import com.sxt.bus.domian.CheckList;
import com.sxt.bus.vo.CheckListVo;

public interface CheckListMapper {
    int deleteByPrimaryKey(String checkid);

    int insert(CheckList record);

    int insertSelective(CheckList record);

    CheckList selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(CheckList record);

    int updateByPrimaryKey(CheckList record);
    Map<String,Object> checkCreateBills(CheckListVo checkListVo);
    List<CheckList> queryAllChecks (CheckList record);
}