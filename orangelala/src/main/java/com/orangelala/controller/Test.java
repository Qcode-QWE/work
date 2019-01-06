package com.orangelala.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
    @RequestMapping("/test")
    public String test(){
	
	return "home";
    }
    
    @RequestMapping("/ajax")
    @ResponseBody
    public Map<String, String> ajax(@RequestParam("")String t){
	System.out.println("-----------------------------------------");
	Map<String, String> map = new HashMap<String,String>();
	map.put("1", "1");
	return map;
    }
    
    
}
