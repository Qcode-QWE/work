package com.orangelala.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.UserMapper;
import com.orangelala.pojo.User;
import com.orangelala.pojo.UserExample;
import com.orangelala.pojo.UserExample.Criteria;
import com.orangelala.pojo.UserExample.Criterion;
import com.orangelala.service.UserService;

@Service
public class UserServiceImpl implements UserService{

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
	
	
	public Integer findUserByUsername(String username) throws Exception{
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(userExample);
		if(list.size()==0) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public int addUser(String username, String email, String password) throws Exception {
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		user.setCreated(new Date());
		user.setUpdated(new Date());
		int num = userMapper.insert(user);
		return num;
	}
}
