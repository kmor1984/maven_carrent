package com.sxt.sys.mapper;
import java.util.List;

import com.sxt.sys.domian.Menu;
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    List<Menu> queryAllMenus (Menu menu);

	List<Menu> queryMenusByRoleID(Integer roleid);
   
}