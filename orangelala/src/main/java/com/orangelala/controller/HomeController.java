package com.orangelala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orangelala.domain.RecordResult;
import com.orangelala.pojo.ItemCat;
import com.orangelala.service.HomeService;
import com.orangelala.service.ItemCatService;


/**  
* <p>Title: HomeController.java</p>  
* <p>Description:主页controller </p>   
* @author QEcode  
* @date 2019年1月6日  
* @version 1.0  
*/ 
@Controller
public class HomeController {
    
    @Autowired
    private HomeService homeService;
    @Autowired
    private ItemCatService itemCatService;
    
    @RequestMapping("/home/itemCat/subnav")
    @ResponseBody
    public RecordResult subnav(){
	List<ItemCat> itemCats = itemCatService.getItemCats();
	return RecordResult.ok(itemCats);
    }

}
