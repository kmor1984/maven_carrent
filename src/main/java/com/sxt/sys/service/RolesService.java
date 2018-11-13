package com.sxt.sys.service;


import java.util.List;

import com.sxt.sys.domian.Menu;
import com.sxt.sys.domian.Roles;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.MenuVo;
import com.sxt.sys.vo.RolesVo;



public interface RolesService {
	DataGridView queryAllRoles(RolesVo rolesVo);
	int deleteByPrimaryKey(RolesVo rolesVo);
	int updateByPrimaryKey(RolesVo rolesVo);
	int insert(Roles rolesVo);
	Roles selectByroleid(Integer roleid);
	List<Menu> queryMenuByRoleID(Integer roleid);
	List<Menu> queryAllMenu(MenuVo menuVo);
	Integer insertByRoleID(RolesVo rolesVo);
}
