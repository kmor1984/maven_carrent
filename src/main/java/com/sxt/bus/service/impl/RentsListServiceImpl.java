package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domian.Car;
import com.sxt.bus.domian.RentsList;
import com.sxt.bus.mapper.CarMapper;
import com.sxt.bus.mapper.RentsListMapper;
import com.sxt.bus.service.RentsListService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.RentsListVo;
import com.sxt.sys.constant.SYS_Constants;
@Service
public class RentsListServiceImpl implements RentsListService {
   @Autowired
	private RentsListMapper rentsListMapper ;
   @Autowired
   private CarMapper carMapper; 
   
   
   
	@Override
	public int deleteByPrimaryKey(RentsListVo record) {
		// TODO Auto-generated method stub
		String rentid=record.getRentid();
		return this.rentsListMapper.deleteByPrimaryKey(rentid);
	}

	@Override
	public int insert(RentsListVo record) {
		// TODO Auto-generated method stub
		int i=this.rentsListMapper.insert(record);
		if(i>0){
			Car car = new Car();
			car.setCarnumber(record.getCarnumber());
			car.setIsrenting(SYS_Constants.PUBLIC_TYPE_ONE);
			this.carMapper.updateByPrimaryKeySelective(car);
		}
		return i;
	}

	@Override
	public int insertSelective(RentsList record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RentsList selectByPrimaryKey(String rentid) {
		// TODO Auto-generated method stub
		return this.rentsListMapper.selectByPrimaryKey(rentid);
	}

	@Override
	public int updateByPrimaryKeySelective(RentsList record) {
		// TODO Auto-generated method stub
		return this.rentsListMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RentsList record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataGridView queryAllRentBills(RentsListVo rentsListVo) {
		// TODO Auto-generated method stub
		Page<Object> page=PageHelper.startPage(rentsListVo.getPage(), rentsListVo.getRows());
		List<RentsList> list=this.rentsListMapper.queryAllRentBills(rentsListVo);
		return new DataGridView(page.getTotal(),list);
	}

}
