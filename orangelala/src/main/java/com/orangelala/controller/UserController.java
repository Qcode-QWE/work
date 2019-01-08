package com.orangelala.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orangelala.domain.RecordResult;
import com.orangelala.pojo.User;
import com.orangelala.service.UserService;

/**  
* <p>Title: LoginController.java</p>  
* <p>Description:登陆controller </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
    
    @RequestMapping("/loginUI")
    public String loginUI(){
	return "login";
    }
    
    @RequestMapping("/loginUI/login")
    @ResponseBody
    public RecordResult login(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest request){
	    try {
	    	String password1 = DigestUtils.md5Hex(password);
	    	User user = userService.getUser(username, password1);	
	    	HttpSession session = request.getSession();
	    	if(user==null) {
	    		throw new Exception();
	    	}
	    	session.setAttribute("user", user);
	    	return RecordResult.ok();
		} catch (Exception e) {
			// TODO: handle exception
			return RecordResult.build(400,"用户名或密码错误");
		}
    }
    
    @RequestMapping("/registerUI")
    public String registerUI(){
    	return "register";
    }
    
    @RequestMapping("/registerUI/checkUsername")
    @ResponseBody	
    public RecordResult checkUsername(@RequestParam("username") String username) {
    	try {
    		Integer num = userService.findUserByUsername(username);
			return RecordResult.ok(num);
		} catch (Exception e) {
			return RecordResult.build(400, "用户名已存在");
		}
    }
    
    @RequestMapping("/registerUI/addUser")
    @ResponseBody
    public RecordResult addUser(@RequestParam("username") String username,
    					@RequestParam("email")String email,@RequestParam("password")String password) {
    	try {
    		String password1 = DigestUtils.md5Hex(password);
    		int username_num = userService.findUserByUsername(username);
    		if(username_num == 1) {
    			throw new Exception();
    		}
    		int num = userService.addUser(username, email, password1);
			return RecordResult.ok(num);
		} catch (Exception e) {
			return RecordResult.build(400, "用户已存在");
		}
    }
}
