package com.sxt.sys.service;
import com.sxt.sys.domian.User;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.UserVo;


public interface UserService {
	 User login(UserVo vo);
	 
	 DataGridView queryAllUser(UserVo userVo);
		int deleteByPrimaryKey(UserVo userVo);
		int updateByPrimaryKey(UserVo userVo);
		int insert(User user);
}
