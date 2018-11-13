package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sxt.sys.constant.SYS_Constants;
import com.sxt.sys.domian.Menu;
import com.sxt.sys.domian.User;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.service.MenuService;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.vo.LogInfoVo;
import com.sxt.sys.vo.MenuVo;
import com.sxt.sys.vo.UserVo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	private JedisPool pool;
	@Autowired
 private UserService userService;
	@Autowired
	private LogInfoService logInfoService; 
	@RequestMapping("toLogin")
	public String toLogin(){
		return("system/login");
	}
	@RequestMapping("login")
	public String login(HttpSession session,UserVo vo,HttpServletRequest request,Model model){
		User user=userService.login(vo);
		if(user!=null){
			/*这里要写登录信息，要拿到用户的ip，查是是拿不到IP的，所以我们把HttpSession改成request*/
			/*session.setAttribute("user", user);
			request.getSession().setAttribute("user", user);*/
			/*改造：用redis把用户的信息存起来*/
			Jedis jedis = null;
			try {
				user.setPwd("******");
				jedis = pool.getResource();
				jedis.set(String.valueOf(session.getId()),JSON.toJSONString(user) );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(jedis!=null) {
					jedis.close();
					}
			}
			/*开始拿用户登录信息，并记录日志*/
			LogInfoVo logInfoVo= new LogInfoVo();
			logInfoVo.setLoginname(user.getLoginname()+"-"+user.getRealname());
			logInfoVo.setLogintime(new Date());
			logInfoVo.setLoginip(request.getRemoteHost());
			logInfoService.insert(logInfoVo);
             return "system/index";	
		}else{
			model.addAttribute("error", "用户名或密码错误");
			return "system/login";
		}

	}
	/*加载左边的树形菜单*/
	@Autowired
	private MenuService menuService;
	@RequestMapping("loadTreeMenu")
	@ResponseBody
	public List<TreeNode> loadTreeMenu (HttpSession session, MenuVo menuVo){
		//User user=(User) session.getAttribute("user");
		Jedis jedis = null;
		User user=null;
		try {
			jedis = pool.getResource();
			String data = jedis.get(String.valueOf(session.getId()) );
			 user= JSON.parseObject(data, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(jedis!=null) {
				jedis.close();
				}
		}
		List<Menu> menus=null;
		//判断用户是管理员还是普通用户
		if(user.getType()==SYS_Constants.USER_TYPE_SUPPER){
			menus= menuService.queryAllMenus(menuVo);
		}else{
			menus= menuService.queryAllMenusByUID(user.getUserid());
		}
		//再循环从数据库中得到的菜单集合
		List<TreeNode> treeNodes = new ArrayList<> ();
		for(Menu menu:menus){
			Boolean isParent=menu.getParent()==SYS_Constants.PUBLIC_TYPE_ONE?true:false;
			Boolean open=menu.getOpen()==SYS_Constants.PUBLIC_TYPE_ONE?true:false;
			treeNodes.add(new TreeNode(menu.getId(), menu.getName(), isParent, open,
					menu.getHref(), menu.getIcon(), menu.getTabicon(), menu.getPid()));
		}
		return treeNodes;
	}
	
	
	
}
