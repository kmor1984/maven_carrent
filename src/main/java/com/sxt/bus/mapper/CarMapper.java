package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domian.Car;

public interface CarMapper {
    int deleteByPrimaryKey(String carnumber);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String carnumber);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
    List<Car> queryAllCar(Car car);
}