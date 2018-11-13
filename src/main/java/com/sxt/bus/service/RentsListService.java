package com.sxt.bus.service;
import com.sxt.bus.domian.RentsList;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.RentsListVo;

public interface RentsListService {
	int deleteByPrimaryKey(RentsListVo record);

    int insert(RentsListVo record);

    int insertSelective(RentsList record);

    RentsList selectByPrimaryKey(String rentid);

    int updateByPrimaryKeySelective(RentsList record);

    int updateByPrimaryKey(RentsList record);
    DataGridView queryAllRentBills(RentsListVo rentsListVo);
   
}
