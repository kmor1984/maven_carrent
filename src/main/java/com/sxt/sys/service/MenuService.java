package com.sxt.sys.service;

import java.util.List;
import com.sxt.sys.domian.Menu;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.MenuVo;


public interface MenuService {
    /*查询所有的菜单*/
	List<Menu> queryAllMenus (MenuVo menuVo);
	/*根据用户ID查询其所拥有的菜单*/
	List<Menu> queryAllMenusByUID (Integer userid);
	//查询所有菜单forDataGridView
	 DataGridView queryMenuForGrid (MenuVo menuVo);
	 //增删改
	    int deleteByPrimaryKey(MenuVo menuVo);
		int updateByPrimaryKey(MenuVo menuVo);
		int insert(Menu menu);
}
