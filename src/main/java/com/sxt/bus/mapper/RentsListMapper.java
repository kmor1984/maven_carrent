package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domian.RentsList;

public interface RentsListMapper {
    int deleteByPrimaryKey(String rentid);

    int insert(RentsList record);

    int insertSelective(RentsList record);

    RentsList selectByPrimaryKey(String rentid);

    int updateByPrimaryKeySelective(RentsList record);

    int updateByPrimaryKey(RentsList record);
    List<RentsList> queryAllRentBills(RentsList record);
}