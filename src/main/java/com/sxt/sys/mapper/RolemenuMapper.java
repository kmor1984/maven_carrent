package com.sxt.sys.mapper;

import com.sxt.sys.domian.RolemenuKey;

public interface RolemenuMapper {
    int deleteByPrimaryKey(RolemenuKey key);

    int insert(RolemenuKey record);

    int insertSelective(RolemenuKey record);
    
    //通过角色ID来删除菜单关系
    void deleteByRoleID(Integer rid);
    //插入新增的角色菜单
    
    Integer insertByRoleID (Integer rid,Integer mid);
}