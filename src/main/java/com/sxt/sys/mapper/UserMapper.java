package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domian.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    User login (User user);
    //全查询
    List<User> queryALLUser(User record);
}