/**  
* <p>Title: OrderServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.OrderMapper;
import com.orangelala.pojo.Order;
import com.orangelala.service.OrderService;

/**  
 * <p>Title: OrderServiceImpl.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderMapper orderMapper;
    /**
     * @Description:保存订单表
     * @param order
     * @throws Exception
     */
    @Override
    public void saveOrder(Order order) throws Exception {
	orderMapper.insert(order);
    }

}
