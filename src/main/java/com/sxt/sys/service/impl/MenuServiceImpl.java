package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domian.Menu;
import com.sxt.sys.mapper.MenuMapper;
import com.sxt.sys.service.MenuService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.MenuVo;

@Service
public class MenuServiceImpl implements MenuService {
@Autowired
	private MenuMapper menuMapper;

@Override
public List<Menu> queryAllMenus(MenuVo menuVo) {
	// TODO Auto-generated method stub
	return menuMapper.queryAllMenus(menuVo);
}

@Override
public List<Menu> queryAllMenusByUID(Integer userid) {
	// TODO Auto-generated method stub
	MenuVo menuVo = new MenuVo();
	return menuMapper.queryAllMenus(menuVo);
}
//查询所有的菜单for DataGridView
@Override
public DataGridView queryMenuForGrid(MenuVo menuVo) {
	// TODO Auto-generated method stub
	Page<Object> page = PageHelper.startPage(menuVo.getPage(), menuVo.getRows());
	List<Menu> list=this.menuMapper.queryAllMenus(menuVo);
	return new DataGridView(page.getTotal(),list);
}
	//增删改

@Override
public int updateByPrimaryKey(MenuVo menuVo) {
	// TODO Auto-generated method stub
	
	return this.menuMapper.updateByPrimaryKey(menuVo);
}

@Override
public int insert(Menu menu) {
	// TODO Auto-generated method stub
	return this.menuMapper.insert(menu);
}

@Override
public int deleteByPrimaryKey(MenuVo menuVo) {
	// TODO Auto-generated method stub
	return this.menuMapper.deleteByPrimaryKey(menuVo.getId());
}




	}


