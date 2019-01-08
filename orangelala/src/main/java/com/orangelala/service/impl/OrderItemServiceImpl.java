/**  
* <p>Title: OrderItemServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.OrdeItemMapper;
import com.orangelala.pojo.OrdeItem;
import com.orangelala.service.OrderItemService;

/**  
 * <p>Title: OrderItemServiceImpl.java</p>  
 * <p>Description: </p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrdeItemMapper orderItemMapper;
    /**
     * @Description:保存
     * @param ordeItem
     * @throws Exception
     */
    @Override
    public void saveOrderItem(OrdeItem ordeItem) throws Exception {
	orderItemMapper.insert(ordeItem);
    }

}
