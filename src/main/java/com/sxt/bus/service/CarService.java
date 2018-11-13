package com.sxt.bus.service;
import com.sxt.bus.domian.Car;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CarVo;


public interface CarService {
	DataGridView queryAllCar(CarVo carVo);
	int deleteByPrimaryKey(CarVo carVo);
	int updateByPrimaryKey(CarVo carVo);
	int insert(Car car);
}
