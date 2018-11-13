package com.sxt.bus.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domian.Customer;
import com.sxt.bus.domian.RentsList;
import com.sxt.bus.service.CheckListService;
import com.sxt.bus.service.CustomerService;
import com.sxt.bus.service.RentsListService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.utils.RandomUtils;
import com.sxt.bus.vo.CheckListVo;
import com.sxt.bus.vo.RentsListVo;
import com.sxt.sys.constant.SYS_Constants;
import com.sxt.sys.domian.User;



@Controller
@RequestMapping("rent")
public class RentController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RentsListService rentsListService ;
	@Autowired
	private CheckListService checkListService ;
	
	
	
	
	/*===============租车业务开始1=====================*/
    @RequestMapping("toRent")
	private String toRent(){
	return "business/rentCar";
}
   
    //身份证查询用户是否客户有效
    @RequestMapping("queryCustomer")
    @ResponseBody
    private Boolean  queryCustomer(String identity){
    	Customer men=customerService.selectByIdentity(identity);
    	if(men!=null){
    		return true;
    	}else{
    		return false;
    	}
    	}
   //拼接有效数在强出层进行展示
    @RequestMapping("initRentFormData")
    @ResponseBody
    private RentsListVo  initRentFormData(RentsListVo rentsListVo,HttpServletRequest request ){
    	User user = (User) request.getSession().getAttribute("user") ;
    	rentsListVo.setRentid(RandomUtils.createBill(SYS_Constants.RENTS_BILL_PREFIX));
    	rentsListVo.setOpername(user.getRealname());
    	return rentsListVo;
    }
   // 添加租车记录
    @RequestMapping("addRentRecord")
    @ResponseBody
    private Boolean  addRentRecord(RentsListVo rentsListVo){
    	rentsListVo.setRentflag(SYS_Constants.PUBLIC_TYPE_ONE);
    	int result= this.rentsListService.insert(rentsListVo);
    	return result>0?true:false;
    }
    /*===============租车业务结束=====================*/ 
    
    /*===============租车单管理开始=====================*/
    @RequestMapping("toRentBills")
	private String toRentBills(){
	return "business/rentCarBills";
    }
    //全查询出租车单
    @RequestMapping("queryAllRentBills")
    @ResponseBody
    private DataGridView  queryAllRentBills(RentsListVo rentsListVo){
    	return this.rentsListService.queryAllRentBills(rentsListVo);
    }
    
    //修改租车单
    @RequestMapping("updateRentBills")
    @ResponseBody
    private Boolean updateRentBills(RentsListVo rentsListVo){
    	int result= this.rentsListService.updateByPrimaryKeySelective(rentsListVo);
    	return result>0?true:false;	
    }
    
  //删除租车单
    @RequestMapping("delRentBills")
    @ResponseBody
    private Boolean delRentBills(RentsListVo rentsListVo){
    	int result= this.rentsListService.deleteByPrimaryKey(rentsListVo);
    	return result>0?true:false;
    }
    
    
    /*====================汽车入库开始=========================*/
    @RequestMapping("toReturnCar")
	private String toReturnCar(){
	return "business/carCheck";
    }
    
   //根据页面传过来的出租车单号查询该车是否归还，如果已归还，则不显示列表内容，如果未归还则展示
    @RequestMapping("checkRentBills")
    @ResponseBody
    private Map<String,Object> checkRentBills(String rentid){
    	Map<String,Object> map =new HashMap<String,Object>();
    	RentsList list = this.rentsListService.selectByPrimaryKey(rentid);
    	if(list!=null){
    		if(list.getRentflag()!=SYS_Constants.PUBLIC_TYPE_ZERO){
    			map.put("obj",true);
    		}else{
    			 map.put("msg","该车未出租，哪来的归还？");
    			 map.put("obj",false);
    		}
    	}else{
    		map.put("obj",false);
    		map.put("msg", "请输入正确的出租车单号！");
    	}
    	return map;
    };
    
    //自动展示生成单上的，检查单号，出租单号，操作人员
    @RequestMapping("checkCreateBills")
    @ResponseBody
    private Map<String,Object> checkCreateBills(CheckListVo checkListVo, HttpSession session){
    	/*1、生成检查单号*/
    	String checkid = RandomUtils.createBill(SYS_Constants.CHECK_BILL_PREFIX);
    	//2、得到操作人员：
    	User user=(User) session.getAttribute("user");
    	//3、将上面的这两个属属性都set到checkListVo里
    	checkListVo.setCheckid(checkid);
    	checkListVo.setOpername(user.getRealname());;
    	//4、调用CheckService得到如下的数据
    	Map<String,Object> map=this.checkListService.checkCreateBills(checkListVo);
    	//5、把checkListVo放入到map里面去。
    	map.put("checkListVo", checkListVo);
    	System.out.println(checkListVo);
    	return map;
    }
    
    /*
     * 新增检查单数据
     * */
    @RequestMapping("checkSaveBills")
    @ResponseBody
    private Map<String,Object> checkCreateBills(CheckListVo checkListVo){
    	Map<String,Object> map = new HashMap<>();
    	int result= this.checkListService.insert(checkListVo);
    	if(result>0){
    		map.put("msg", "检查单已建立，汽车已入库！");
    	}else{
    		map.put("msg", "检查单未建立，汽车未入库！");
    	}
    	return map;
    }
    
  
    /*====================汽车入库结束=========================*/
    
    /*====================查询检查单开始=========================*/
    
    @RequestMapping("toCheckList")
	private String toCheckList(){
	return "business/checkList";
    }
    
    
    @RequestMapping("checkList")
    @ResponseBody 
    private DataGridView checkList(CheckListVo checkListVo){
    	return this.checkListService.queryAllChecks(checkListVo);
    }
    
    
    
    
    
    
    
    /*====================查询检查单结束=========================*/
    
}
