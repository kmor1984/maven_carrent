package com.sxt.bus.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domian.Car;
import com.sxt.bus.domian.CheckList;
import com.sxt.bus.domian.Customer;
import com.sxt.bus.domian.RentsList;
import com.sxt.bus.mapper.CarMapper;
import com.sxt.bus.mapper.CheckListMapper;
import com.sxt.bus.mapper.CustomerMapper;
import com.sxt.bus.mapper.RentsListMapper;
import com.sxt.bus.service.CheckListService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CheckListVo;
import com.sxt.sys.constant.SYS_Constants;


@Service
public class CheckListServiceImpl implements CheckListService {
	@Autowired
	private CheckListMapper checkListMapper;
	@Autowired
	private RentsListMapper rentsListMapper;
	@Autowired
	private CarMapper carMapper;
	@Autowired 
	private CustomerMapper customerMapper;
	
	
	
	@Override
	public int deleteByPrimaryKey(String checkid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(CheckListVo checkListVo) {
		// TODO Auto-generated method stub
		Car car = new Car();
		RentsList carNumber= this.rentsListMapper.selectByPrimaryKey(checkListVo.getRentid());
		car.setCarnumber(carNumber.getCarnumber());
		car.setIsrenting(SYS_Constants.PUBLIC_TYPE_ZERO);
		this.carMapper.updateByPrimaryKeySelective(car);
		return this.checkListMapper.insert(checkListVo);
	}

	@Override
	public int insertSelective(CheckList record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CheckList selectByPrimaryKey(String checkid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(CheckList record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(CheckList record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/*查询到所有的页面要展示的数据*/
	//1、根据页面上传过来的租车单单号
	@Override
	public Map<String,Object> checkCreateBills(CheckListVo checkListVo){
		/*1、通过vo传过来的rentid,去bus_rents表里查出这张出租车单子*/
    RentsList rent= this.rentsListMapper.selectByPrimaryKey(checkListVo.getRentid());
		/*2、根据查出来的rent传过来的carnumber,去bus_car表里查出这辆车*/
    Car car=this.carMapper.selectByPrimaryKey(rent.getCarnumber());	
        /*3、根据查出来的rent中的indentity,去bus_customer这张表里查出这个客户信息*/
    Customer customer=this.customerMapper.selectByPrimaryKey(rent.getIdentity());
		/*4、把这3个查询出来的数据都放入map集合中*/	
    Map<String,Object> map = new HashMap<>();
		 map.put("rent",rent);
	     map.put("car",car);
		 map.put("customer",customer);
		return map;	
	}

	@Override
	public DataGridView queryAllChecks(CheckListVo checkListVo) {
		// TODO Auto-generated method stub
		Page<Object> page = PageHelper.startPage(checkListVo.getPage(), checkListVo.getRows());
		List<CheckList> list= this.checkListMapper.queryAllChecks(checkListVo);
		return new DataGridView(page.getTotal(),list) ;
	}
}
