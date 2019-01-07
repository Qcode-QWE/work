package com.orangelala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orangelala.domain.RecordResult;

/**  
* <p>Title: LoginController.java</p>  
* <p>Description:登陆controller </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
@Controller
public class LoginController {
    
    @RequestMapping("/login/user")
    public String loginUI(){
	return "login";
    }
    
    @RequestMapping("/register/user")
    public String registerUI(){
	return "register";///aaaaaa
    }
    
    public String login(String userName,String password){
	
	
	return "home";
	
    }
    
    
    
}
