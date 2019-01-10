package com.orangelala.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.orangelala.domain.RecordResult;
import com.orangelala.pojo.Car;
import com.orangelala.pojo.CarItem;
import com.orangelala.pojo.Item;
import com.orangelala.pojo.ItemDesc;
import com.orangelala.pojo.ItemParamItem;
import com.orangelala.pojo.OrdeItem;
import com.orangelala.pojo.Order;
import com.orangelala.pojo.User;
import com.orangelala.service.CarItemService;
import com.orangelala.service.CarService;
import com.orangelala.service.ItemDescService;
import com.orangelala.service.ItemParamItemService;
import com.orangelala.service.ItemService;
import com.orangelala.service.OrderItemService;
import com.orangelala.service.OrderService;

/**  
* <p>Title: IntroductionController.java</p>  
* <p>Description:商品详情controller </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
@Controller
public class IntroductionController {
    
    @Autowired
    private ItemService itemService;
    @Autowired
    private CarService carService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CarItemService carItemService;
    @Autowired
    private ItemDescService itemDescService;
    @Autowired
    private ItemParamItemService itemParamItemService;
    
    @RequestMapping("/introduction/to")
    public ModelAndView TOIntroduction(@RequestParam("id") Long id){
	ModelMap model = new ModelMap();  
	model.put("ItemId",id);
	return new ModelAndView("introduction",model);  
    }
    
    /**
     * @Description:根据id获取商品
     * @param id
     * @return
     */
    @RequestMapping("/introduction/item/get")
    @ResponseBody
    public RecordResult getItem(Long id){
	try {
	    //获取item
	    Item item = itemService.getItemById(id);
	    //获取商品简介
	    ItemDesc itemDesc = itemDescService.getItemDesc(item.getId());
	    //获取商品规格
	    String itemParamItem = itemParamItemService.getItemParamItem(item.getId());
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("item",item);
	    map.put("itemDesc",itemDesc);
	    map.put("itemParamItem",itemParamItem);
	    return RecordResult.ok(map);
	} catch (Exception e) {
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");
	}	
    }
    
    /**
     * @Description:加到购物车
     * @param id
     * @param num
     * @param request
     * @return
     */
    @RequestMapping("/introduction/item/car")
    @ResponseBody
    public RecordResult addCar(@RequestParam("id") Long id,@RequestParam("num") Integer num,HttpServletRequest request){
	try {
	    //获取商品
	    Item item = itemService.getItemById(id);
	    //判断商品数量是否足够
	    if(item.getNum()<num){
		return RecordResult.build(0, "商品数量不足");
	    }
	    //获取user
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
	    //查询购物车
	    Car car = carService.getCarByUserId(user.getId());
	    if(car==null) {                  //
	    	car = new Car();
	    	car.setUserId(user.getId());
	    	carService.addCar(car);
	    	car = carService.getCarByUserId(user.getId());
	    }
	    //创建购物车-商品表
	    CarItem carItem = new CarItem();
	    carItem.setCarId(car.getCarId());
	    carItem.setItemId(item.getId());
	    carItem.setNumber(num);
	    carItem.setImg(item.getImage());
	    //保存
	    carItemService.saveCarItem(carItem);
	    return RecordResult.ok();
	} catch (Exception e) {
	    e.printStackTrace();
	    return RecordResult.build(400, "发生了错误");
	}
    }
    
    /**
     * 跳转到购物车页面
     * @return
     */
    @RequestMapping("/goCar")
    public String goCar() {
		return "shopcar";
	}
    
    
    /**
     * 显示购物车
     * @param request
     * @return
     */
    @RequestMapping("/showCar")
    @ResponseBody  
    public RecordResult showCar(HttpServletRequest request) {
    	try {
			//获取user
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Car car = carService.getCarByUserId(user.getId());
			//如果当前用户的购物车还没创建
		    if(car==null) {
		    	car = new Car();
		    	car.setUserId(user.getId());
		    	carService.addCar(car);  
		    	car = carService.getCarByUserId(user.getId());
		    }
		    Long carId=car.getCarId();
			List<CarItem> carItems = carItemService.getCarItems(carId);
			List<Item> items = new ArrayList<>();
			for (CarItem carItem : carItems) {
				items.add(itemService.getItemById(carItem.getItemId()));
			}
			Map<String, Object> map = new HashMap<>();
			map.put("catItems", carItems);
			map.put("items", items);
			if(carItems==null) {
				return RecordResult.ok();
			}else {
				return RecordResult.ok(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		    return RecordResult.build(400, "发生了错误");
		}
	}

    public static void main(String[] args) {
	System.out.println(new Date().getTime());
    }
}
