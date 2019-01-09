/**  
* <p>Title: OrderItemService.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service;

import com.orangelala.pojo.OrdeItem;

/**  
 * <p>Title: OrderItemService.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
public interface OrderItemService {
    public void saveOrderItem(OrdeItem ordeItem) throws Exception;
    public OrdeItem getById(Long id) throws Exception;
}
