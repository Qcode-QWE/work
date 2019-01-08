package com.orangelala.service;

import com.orangelala.pojo.User;

public interface UserService {
	public User getUser(String username,String password) throws Exception;
	public Integer findUserByUsername(String username) throws Exception;
	public int addUser(String username, String email, String password) throws Exception;
}
