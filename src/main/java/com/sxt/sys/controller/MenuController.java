package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sxt.sys.constant.SYS_Constants;
import com.sxt.sys.domian.Menu;
import com.sxt.sys.service.MenuService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.utils.TreeNodesBulids;
import com.sxt.sys.vo.MenuVo;

//登录跳转到菜单管理页面
@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	
	
	@RequestMapping("toMenu")
	private String toLogInfo(){
	return "system/menu";
}
//加载右边的菜单列表
	@RequestMapping("queryAllMenu")
	@ResponseBody
	public DataGridView queryMenuForGrid(MenuVo menuVo){
		return this.menuService.queryMenuForGrid(menuVo);
	}
//加载左边的菜单树
	@RequestMapping("loadMunusForLeft")
	@ResponseBody
	public List<TreeNode> loadMunusForLeft(MenuVo menuVo){
	    List<TreeNode> treeNodes = new ArrayList<> ();
	    List<Menu> menus = this.menuService.queryAllMenus(menuVo);
	for(Menu menu:menus){
		Boolean isParent=menu.getParent()==SYS_Constants.PUBLIC_TYPE_ONE?true:false;
		Boolean open=menu.getOpen()==SYS_Constants.PUBLIC_TYPE_ONE?true:false;
		treeNodes.add(new TreeNode(menu.getId(), menu.getName(), isParent, open,
				menu.getHref(), menu.getIcon(), menu.getTabicon(), menu.getPid()));
	}
	return treeNodes;
	
	}
	/*组装comb-tree,easyui使用的是标准的joson格式，标准格式是需要有层级之分，如：
	 * var nodes = [
	{name: "父节点1", children: [
		{name: "子节点1"},
		{name: "子节点2"}
	]}
   ];
	 * 必须的四个元素是：id,pid,text,children;去TreeNode里面组装属性
	 * */
	
	@RequestMapping("loadMenusForAdd")
	@ResponseBody
	public List<TreeNode> loadMenusForAdd(MenuVo menuVo){
		List<TreeNode> treeNodes = new ArrayList<> ();
	    List<Menu> menus = this.menuService.queryAllMenus(menuVo);
	    for(Menu menu:menus){
			
			treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getName()));
		}
	    //return treeNodes;此时返回return treeNodes，不行，原因是这个是简单的json,不是标准的josn
	    //所以还要去构造有层级关系的joson返回去
	  
	    List<TreeNode> node=TreeNodesBulids.bulider(treeNodes ,0);
		return node;
	}
	
	
	/*菜单增删改*/
	
    //删除用户
    @RequestMapping("delMenu")
    @ResponseBody
    private Boolean delMenu (MenuVo menuVo){
    	int result= this.menuService.deleteByPrimaryKey(menuVo);
    	return result>0?true:false;	
    }
  //更改用户
    @RequestMapping("updateMenu")
    @ResponseBody
    private Boolean updateMenu (MenuVo menuVo){
    	int result= this.menuService.updateByPrimaryKey(menuVo);
    	return result>0?true:false;	
    }
  //新增用户
    @RequestMapping("addMenu")
    @ResponseBody
    private Boolean addMenu (MenuVo menuVo){
    	int result= this.menuService.insert(menuVo);
    	return result>0?true:false;	
    }
	
	
	
	
	
	
	
	
	
	
}
