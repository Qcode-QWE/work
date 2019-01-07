package com.orangelala.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orangelala.domain.RecordResult;
import com.orangelala.pojo.Content;
import com.orangelala.pojo.Item;
import com.orangelala.pojo.ItemCat;
import com.orangelala.service.ContentService;
import com.orangelala.service.HomeService;
import com.orangelala.service.ItemCatService;
import com.orangelala.service.ItemService;


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
    @Autowired
    private ItemService itemService;
    @Autowired
    private ContentService contentService;
    
    
    @RequestMapping("/home")
    public String home(){
	return "home";
    }
    
    /**
     * @Description:一级菜单
     * @param ids
     * @return
     */
    @RequestMapping("/home/itemCat/subnav")
    @ResponseBody
    public RecordResult subnav(@RequestParam(value="id") List<Integer> ids){
	List<ItemCat> itempppCats;
	try {
		itempppCats = itemCatService.getItemCats(ids);
	    //啊啊啊
	    return RecordResult.ok(itempppCats);
	} catch (Exception e) {
	    return RecordResult.build(400, "发生了错误");
	}
    }
    
    /**
     * @Description:二级菜单
     * @param id
     * @return
     */
    @RequestMapping("/home/itemCat/subnavTwo")
    @ResponseBody
    public RecordResult subnavTwo(@RequestParam("id") Long id){
	Map<String,Object> map = new HashMap<String, Object>();
	try {
	    //二级菜单类目
	    List<ItemCat> itemCats = itemCatService.getTowItemCats(id);
	    map.put("subnavTwo", itemCats);
	    //三级菜单类目
	    Map<String, Object> itemMap = new HashMap<String,Object>();
	    List<ItemCat> items;
	    if(itemCats!=null && itemCats.size()>0){
		for(ItemCat itemCat:itemCats){
		    items = itemCatService.getThreeItemCats(itemCat.getId());
		    itemMap.put(itemCat.getName(), items);
		}
	    }
	    map.put("subnavThree",itemMap);
	    return RecordResult.ok(map);
	} catch (Exception e) {
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");
	}
	
    }
    
    /**
     * @Description:首页大广告
     * @param id
     * @return
     */
    @RequestMapping("/home/content/shuffling")
    @ResponseBody
    public RecordResult shuffling(@RequestParam("id") Long id){
	try {
		System.out.println("running");
	    List<Content> contents = contentService.getContentByCategoryId(id);
	    return RecordResult.ok(contents);
	} catch (Exception e) {
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");
	}
    }
    
    /**
     * @Description:广告列表
     * @param id
     * @return
     */
    @RequestMapping("/home/content/minAD")
    @ResponseBody
    public RecordResult minAD(@RequestParam("id") Long id){
	try {
	    List<Content> contents = contentService.getContentByCategoryId(id);
	    return RecordResult.ok(contents);
	} catch (Exception e) {
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");
	}
    }
    
    
    /**
     * @Description:根据id查询7篇文章
     * @param id
     * @return
     */
    @RequestMapping("/home/content/news")
    @ResponseBody
    public RecordResult news(@RequestParam("id") Long id){
	try {
	    List<Content> contents = contentService.getContentByCategoryIdOrderBy(id);
	    return RecordResult.ok(contents);
	} catch (Exception e) {
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");
	}
    }
    
    
    /**
     * @Description:返回四个秒杀商品id
     * @return
     */
    @RequestMapping("/home/secondsKill/items")
    @ResponseBody
    public RecordResult secondsKill(){
	try {
	    List<Item> items = itemService.getKillItem();
	    return RecordResult.ok(items);
	} catch (Exception e) {
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");
	}
    }
    
    /**
     * @Description:判断是否能秒杀
     * @param id
     * @return(0:还没开始,1:秒杀失败,2:秒杀成功)
     */
    @RequestMapping("/home/secondsKill/itemAble")
    @ResponseBody
    public RecordResult secondsKillAble(@RequestParam("id") Long id){
	try {
	    int i = itemService.updateKillItem(id);
	    return RecordResult.ok(i);//
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");//
	}
	
    }
    
    
    
}
