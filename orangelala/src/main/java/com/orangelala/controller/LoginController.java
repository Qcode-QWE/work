package com.orangelala.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orangelala.domain.RecordResult;
import com.orangelala.pojo.User;
import com.orangelala.service.LoginService;

/**  
* <p>Title: LoginController.java</p>  
* <p>Description:登陆controller </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
@Controller
public class LoginController {
	
	 @Autowired
	 private LoginService loginService;
    
    @RequestMapping("/login/loginUI")
    public String loginUI(){
	return "login";
    }
    
    @RequestMapping("/register/user")
    public String registerUI(){
	return "register";///aaaaaaaaaaaaa
    }
    
    @RequestMapping("/login/login")
    @ResponseBody
    public RecordResult login(@RequestParam("username") String username,@RequestParam("password") String password){
    try {
    	String password1 = DigestUtils.md5Hex(password);
    	User user = loginService.getUser(username, password1);	
    	if(user==null) {
    		throw new Exception();
    	}
    	return RecordResult.ok(user);
	} catch (Exception e) {
		// TODO: handle exception
		return RecordResult.build(400,"用户名或密码错误");
	}
	
	
    }
    

    
}
