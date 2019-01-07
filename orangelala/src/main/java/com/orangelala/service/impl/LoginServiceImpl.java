package com.orangelala.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.UserMapper;
import com.orangelala.pojo.User;
import com.orangelala.pojo.UserExample;
import com.orangelala.pojo.UserExample.Criteria;
import com.orangelala.pojo.UserExample.Criterion;
import com.orangelala.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUser(String username,String password) throws Exception {
		// TODO Auto-generated method stub
		//
		UserExample userExample = new UserExample();
		Criteria criteria  = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(userExample);
		if(list!=null && list.size()==1) {
			return list.get(0);
		}
		return null;
	}
}
