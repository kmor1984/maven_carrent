package com.sxt.sys.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constant.SYS_Constants;
import com.sxt.sys.domian.Menu;
import com.sxt.sys.service.RolesService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.vo.MenuVo;
import com.sxt.sys.vo.RolesVo;



@Controller
@RequestMapping("role")
public class RolesController {
	@Autowired
	private RolesService rolesService;
	
    @RequestMapping("toRole")
	private String toRoles(){
	return "system/roles";
}
   
    //查询角色
    @RequestMapping("queryAllRoles")
    @ResponseBody
    private DataGridView queryAllRoles(RolesVo rolesVo){
    	return this.rolesService.queryAllRoles(rolesVo);
    }
    //删除角色
    @RequestMapping("delRoles")
    @ResponseBody
    private Boolean delRoles (RolesVo rolesVo){
    	int result= this.rolesService.deleteByPrimaryKey(rolesVo);
    	return result>0?true:false;	
    }
  //更改角色
    @RequestMapping("updateRoles")
    @ResponseBody
    private Boolean updateRoles (RolesVo rolesVo){
    	int result= this.rolesService.updateByPrimaryKey(rolesVo);
    	return result>0?true:false;	
    }
  //新增角色
    @RequestMapping("addRoles")
    @ResponseBody
    private Boolean addRoles (RolesVo rolesVo){
    	int result= this.rolesService.insert(rolesVo);
    	return result>0?true:false;	
    }
    //加载树选框，送查询角色之前拥有的权限
    @RequestMapping("invokeRoles")
    @ResponseBody
    private List<TreeNode> invokeRoles (RolesVo rolesVo){
    	/*思路：首先通过RolesVo得到角色ID，再通过角色ID查询出当前角色所拥有的菜单权限，
    	 * 再以easyUI要求的格式返回一个josn字符串给前端展示
    	 * */
    	List<Menu> menus_roleid = this.rolesService.queryMenuByRoleID(rolesVo.getRoleid());
    	
    	//查询可用的菜单
    	MenuVo menuVo = new MenuVo();
    	//设置菜单可用的属性
    	menuVo.setAvailable(SYS_Constants.MENUS_AVAILABLE_YES);
    	List<Menu> menus_all =this.rolesService.queryAllMenu(menuVo);
    	/*声明一个list集合，把TreeNode装进去，返回给前端*/
    	List<TreeNode> node_list = new ArrayList<>(); 
    	//遍历这两个菜单集合，拿到该角色可用的菜单
    	for(Menu menu1:menus_all ){
    		Boolean checked = false;
    		for(Menu menu2:menus_roleid){
    			if(menu1.getId()==menu2.getId()){
    			checked=true;
    			break;
    			}
    		}
    		Boolean isParent=menu1.getParent()==SYS_Constants.PUBLIC_TYPE_ONE?true:false;
    		Boolean open=menu1.getOpen()==SYS_Constants.PUBLIC_TYPE_ONE?true:false;
    		TreeNode node = new TreeNode(menu1.getId(), menu1.getName(), checked, isParent, open, menu1.getIcon(), menu1.getPid());
    		node_list.add(node);
    	}
    	return node_list;
    }
    
    /*保存已勾选的菜单*/
   
    @RequestMapping("saveInvokeRoles")
    @ResponseBody
    private Map<String,Object> saveInvokeRoles (RolesVo rolesVo){
     Map<String,Object> map = new HashMap<>();
    	try {
			int result = this.rolesService.insertByRoleID(rolesVo);
			if(result>SYS_Constants.PUBLIC_TYPE_ZERO){
				map.put("msg", "分配成功！");
			}else{
				map.put("msg", "分配失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("msg", "分配失败！");
		}
    	
     return map;
    }
    
}
