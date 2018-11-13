package com.sxt.sys.mapper;

import java.util.List;
import com.sxt.sys.domian.Roles;

public interface RolesMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
    List<Roles> queryAllRoles(Roles roles);
    
}