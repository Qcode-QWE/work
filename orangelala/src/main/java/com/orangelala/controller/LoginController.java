package com.orangelala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orangelala.domain.RecordResult;
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
    public String login(String username,String password){
	loginService
	return "home";
	
    }
    
    
    
}
