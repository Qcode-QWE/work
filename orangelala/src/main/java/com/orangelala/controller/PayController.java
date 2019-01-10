/**  
* <p>Title: PayController.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月9日  
* @version 1.0  
*/  
package com.orangelala.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.orangelala.domain.RecordResult;
import com.orangelala.pojo.Car;
import com.orangelala.pojo.CarItem;
import com.orangelala.pojo.Item;
import com.orangelala.pojo.OrdeItem;
import com.orangelala.pojo.Order;
import com.orangelala.pojo.User;
import com.orangelala.service.CarItemService;
import com.orangelala.service.CarService;
import com.orangelala.service.ItemService;
import com.orangelala.service.OrderItemService;
import com.orangelala.service.OrderService;
import com.orangelala.utils.JsonUtils;

/**  
 * <p>Title: PayController.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月9日  
 * @version 1.0  
 */
@Controller
//@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CarService carService;
    @Autowired
    private CarItemService carItemService;
    
    @RequestMapping("/to")
    public String to(){
	return "pay";
    }
    
    /**
     * @Description:直接支付,跳转到支付页面
     * @param oId
     * @param request
     * @return
     */
    @RequestMapping("/ItemtoPay")
    public ModelAndView buyItem(@RequestParam("id") Long id,@RequestParam("num") Integer num,HttpServletRequest request){
   	try {
   	    //获取商品
   	    Item item = itemService.getItemById(id);
   	    //判断商品数量是否足够
   	    if(item.getNum()<num){
   		return new ModelAndView("error/error");
   	    }
   	    // 创建订单-商品数据
   	    //
   	    List<OrdeItem> orderItems = new ArrayList<OrdeItem>();
   	    
   	    OrdeItem orderItem = new OrdeItem();
   	    //
   	    orderItem.setId(String.valueOf(new Date().getTime()));
   	    // 商品id
   	    orderItem.setItemId(String.valueOf(id));
   	    // 商品数量
   	    orderItem.setNum(num);
   	    //商品价格
   	    orderItem.setPrice(item.getPrice()/100);
   	    //商品总额
   	    orderItem.setTotalFee(num*item.getPrice()/100);
   	    //商品图片
   	    orderItem.setPicPath(item.getImage());
   	    //商品标题
   	    orderItem.setTitle(item.getTitle());
   	    // 创建订单表
   	    Order order = new Order();
   	    // 创建时间
   	    order.setCreateTime(new Date());
   	    order.setUpdateTime(new Date());
   	    // 未付款
   	    order.setStatus(0);
   	    // 用户id
   	    HttpSession session = request.getSession();
   	    User user = (User) session.getAttribute("user");
   	    order.setUserId(user.getId());
   	    //顶单编号
   	    String oId = String.valueOf(new Date().getTime());
   	    order.setOrderId(oId);
   	    //总额
   	    order.setPayment(String.valueOf(orderItem.getTotalFee()));
   	    // 将订单id存到订单-商品表中
   	    orderItem.setOrderId(oId);
   	    //保存
   	    orderService.saveOrder(order);
   	    orderItemService.saveOrderItem(orderItem);
   	    ModelMap modelMap = new ModelMap();
   	    orderItems.add(orderItem);
   	    modelMap.put("orderItems", orderItems);
   	    modelMap.put("order", order);
   	    return new ModelAndView("pay",modelMap);
   	} catch (Exception e) {
   	    e.printStackTrace();
   	    return new ModelAndView("error/error");
   	}
   	
       }
    /**
     * @Description:根据购物车商品生成订单,并跳转到支付页面
     * @param ids
     * @return
     */
    @RequestMapping("/carToPay")
    public ModelAndView carToPay(@RequestParam("ids")String ids,@RequestParam(value="nums",defaultValue="[0]")String numlist,HttpServletRequest request){
	try {  
	    List<Long> idlList = JsonUtils.jsonToList(ids, Long.class);
	    List<Integer> nums = JsonUtils.jsonToList(numlist, Integer.class);
	    //根据商品id查询商品
	    List<Item> items = itemService.getItmesById(idlList);
	    //生成一个订单对象
	    Order order = new Order();
	    order.setOrderId(String.valueOf(new Date().getTime()));
	    order.setCreateTime(new Date());
	    order.setUpdateTime(new Date());
	    order.setStatus(0);
	    //获取用户id
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
	    order.setUserId(user.getId());  //模仿用户id=18
	    //更加userId获取car
	    Car car = carService.getCarByUserId(user.getId());
	    List<OrdeItem> orderItems = new ArrayList<OrdeItem>();
	    //对每个商品生成一个order-item对象
	    Long price = 0L;
	    for(Item item:items){
		//创建商品-订单对象
		OrdeItem orderItem = new OrdeItem();
		//id
		String id = String.valueOf(new Date().getTime());
		orderItem.setId(id);
		//商品id
		orderItem.setItemId(String.valueOf(item.getId()));
		//订单id
		orderItem.setOrderId(order.getOrderId());
		//购买数量
		//根据carId和itemId查询car-item
		CarItem carItem = carItemService.getByItemidAndCid(item.getId(), car.getCarId());
		orderItem.setNum(carItem.getNumber());
		//标题
		orderItem.setTitle(item.getTitle());
		//价格
		orderItem.setPrice(item.getPrice()/100);
		//总额
		orderItem.setTotalFee(orderItem.getPrice()*orderItem.getNum()/100);
		//图片
		orderItem.setPicPath(item.getImage());
		//保存
		orderItemService.saveOrderItem(orderItem);
		orderItems.add(orderItem);
		price += orderItem.getTotalFee();
	    }
	    order.setPayment(String.valueOf(price));
	    orderService.saveOrder(order);
	    ModelMap modelMap = new ModelMap();
	    modelMap.put("orderItems", orderItems);
	    modelMap.put("order", order);
	    return new ModelAndView("pay",modelMap);
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ModelAndView("error/error");
	}
    }
    
    /**
     * @Description:提交订单
     * @param orderId
     * @return
     */
    @RequestMapping("/payItem")
    public ModelAndView payItem(@RequestParam("orderId")String orderId,String msg){
	try {
	    //
	    Order order = orderService.getOrderById(orderId);
	    //付款方式
	    order.setPaymentType(1);
	    //付款时间
	    order.setPaymentTime(new Date());
	    //邮费
	    order.setPostFee("10.0");
	    //已付款
	    order.setStatus(1);
	    order.setUpdateTime(new Date());
	    //用户留言
	    order.setBuyerMessage(msg);
	    //
	    orderService.updateOrder(order);
	    //根据orderId获取order-item
	    List<OrdeItem> orderItems = orderItemService.getByOrderId(orderId);
	    for(OrdeItem orderItem:orderItems){
		Item item = itemService.getItemById(Long.valueOf(orderItem.getItemId()));
		//修改商品的数量
		int num = item.getNum();
		int num1 = orderItem.getNum();
		item.setNum(num-num1);
		item.setUpdated(new Date());
		itemService.updateItem(item);
	    }
	    return new ModelAndView("success");
	} catch (Exception e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	    return new ModelAndView("error/error");
	}
    }
    
    
}
