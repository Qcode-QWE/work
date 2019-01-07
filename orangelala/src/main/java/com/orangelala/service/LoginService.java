package com.orangelala.service;

import com.orangelala.pojo.User;

public interface LoginService {
	public User getUser(String username,String password) throws Exception;
}
