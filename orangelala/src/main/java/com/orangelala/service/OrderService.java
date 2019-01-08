/**  
* <p>Title: OrderService.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service;

import com.orangelala.pojo.Order;

/**  
 * <p>Title: OrderService.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
public interface OrderService {
    public void saveOrder(Order order) throws Exception;
}
