package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domian.User;
import com.sxt.sys.mapper.UserMapper;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.UserVo;


@Service
public class UserServiceImpl implements UserService {
@Autowired
	private UserMapper userMapper;
	@Override
	public User login(UserVo vo) {
		return userMapper.login(vo);
	}
	
		@Override
		public DataGridView queryAllUser(UserVo userVo) {
			// TODO Auto-generated method stub
			Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getRows());
			List<User> list=this.userMapper.queryALLUser(userVo);
			return new DataGridView(page.getTotal(),list) ;
		}

		@Override
		public int updateByPrimaryKey(UserVo userVo) {
			// TODO Auto-generated method stub
			
			return this.userMapper.updateByPrimaryKey(userVo);
		}

		@Override
		public int insert(User user) {
			// TODO Auto-generated method stub
			return this.userMapper.insert(user);
		}

		@Override
		public int deleteByPrimaryKey(UserVo userVo) {
			// TODO Auto-generated method stub
			return this.userMapper.deleteByPrimaryKey(userVo.getUserid());
		}
		


	
}