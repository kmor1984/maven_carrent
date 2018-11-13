package com.sxt.bus.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domian.Car;
import com.sxt.bus.mapper.CarMapper;
import com.sxt.bus.service.CarService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CarVo;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
private CarMapper carMapper; 
	@Override
	public DataGridView queryAllCar(CarVo carVo) {
		// TODO Auto-generated method stub
		Page<Object> page = PageHelper.startPage(carVo.getPage(), carVo.getRows());
		List<Car> list=this.carMapper.queryAllCar(carVo);
		return new DataGridView(page.getTotal(),list) ;
	}

	@Override
	public int updateByPrimaryKey(CarVo carVo) {
		// TODO Auto-generated method stub
		
		return this.carMapper.updateByPrimaryKey(carVo);
	}

	@Override
	public int insert(Car car) {
		// TODO Auto-generated method stub
		return this.carMapper.insert(car);
	}

	@Override
	public int deleteByPrimaryKey(CarVo carVo) {
		// TODO Auto-generated method stub
		return this.carMapper.deleteByPrimaryKey(carVo.getCarnumber());
	}
	

}
