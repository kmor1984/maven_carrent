package com.sxt.bus.controller;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.sxt.bus.service.CarService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.utils.UploadFile;
import com.sxt.bus.vo.CarVo;



@Controller
@RequestMapping("car")
public class CarController {
	@Autowired
	private CarService carService;
    @RequestMapping("toCar")
	private String toCar(){
	return "business/car";
}
   
    //查询车辆
    @RequestMapping("queryAllCar")
    @ResponseBody
    private DataGridView queryAllCar(CarVo carVo){
    	return this.carService.queryAllCar(carVo);
    }
    //删除车辆
    @RequestMapping("delCar")
    @ResponseBody
    private Boolean delCar (CarVo carVo){
    	int result= this.carService.deleteByPrimaryKey(carVo);
    	return result>0?true:false;	
    }
  //更改车辆
    @RequestMapping("updateCar")
    @ResponseBody
    private Boolean updateCar (CarVo carVo){
    	int result= this.carService.updateByPrimaryKey(carVo);
    	return result>0?true:false;	
    }
  //新增车辆
    @RequestMapping("addCar")
    @ResponseBody
    private Boolean addCar (CarVo carVo){
    	int result= this.carService.insert(carVo);
    	return result>0?true:false;	
    }
   // 添加车辆图片
    @RequestMapping("uploadCarImg")
    @ResponseBody
    private Map<String,Object> uploadCarImg (MultipartFile mf,HttpServletRequest request){
    	Map<String,Object> map= new HashMap<>();
    	String carImg = UploadFile.upload(mf, request);
    	System.out.println(carImg);
    	map.put("carImgPath", carImg);
    	return map;
    }
    
    
    
    
    
    
    
    
    
    
    
}
