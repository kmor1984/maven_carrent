package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.constant.SYS_Constants;
import com.sxt.sys.domian.Menu;
import com.sxt.sys.domian.Roles;
import com.sxt.sys.mapper.MenuMapper;
import com.sxt.sys.mapper.RolemenuMapper;
import com.sxt.sys.mapper.RolesMapper;
import com.sxt.sys.service.RolesService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.MenuVo;
import com.sxt.sys.vo.RolesVo;

@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
private RolesMapper rolesMapper; 
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private RolemenuMapper rolemenuMapper; 
	
	@Override
	public DataGridView queryAllRoles(RolesVo rolesVo) {
		// TODO Auto-generated method stub
		Page<Object> page = PageHelper.startPage(rolesVo.getPage(), rolesVo.getRows());
		List<Roles> list=this.rolesMapper.queryAllRoles(rolesVo);
		return new DataGridView(page.getTotal(),list) ;
	}

	@Override
	public int updateByPrimaryKey(RolesVo rolesVo) {
		// TODO Auto-generated method stub
		
		return this.rolesMapper.updateByPrimaryKey(rolesVo);
	}

	@Override
	public int insert(Roles rolesVo) {
		// TODO Auto-generated method stub
		return this.rolesMapper.insert(rolesVo);
	}

	@Override
	public int deleteByPrimaryKey(RolesVo rolesVo) {
		// TODO Auto-generated method stub
		return this.rolesMapper.deleteByPrimaryKey(rolesVo.getRoleid());
	}


	@Override
	public Roles selectByroleid(Integer roleid) {
		// TODO Auto-generated method stub
		 return this.rolesMapper.selectByPrimaryKey(roleid);
	}

	@Override
	public List<Menu> queryMenuByRoleID(Integer roleid) {
		// TODO Auto-generated method stub
		
		return this.menuMapper.queryMenusByRoleID(roleid);
	}

	@Override
	public List<Menu> queryAllMenu(MenuVo menuVo) {
		// TODO Auto-generated method stub
		return this.menuMapper.queryAllMenus(menuVo);
	}

	@Override
	public Integer insertByRoleID(RolesVo rolesVo) {
		// TODO Auto-generated method stub
		Integer rid = rolesVo.getRoleid();
		Integer[] mid =rolesVo.getIds();
		this.rolemenuMapper.deleteByRoleID(rid);
		if(mid!=null&&mid.length>0){
			for(Integer e:mid){
			this.rolemenuMapper.insertByRoleID(rid, e);
		}
			return SYS_Constants.PUBLIC_TYPE_ONE;
		}else{
			return SYS_Constants.PUBLIC_TYPE_ZERO;
		}
		
	}
	

}
