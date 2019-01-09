/**  
* <p>Title: OrderItemServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.OrdeItemMapper;
import com.orangelala.pojo.OrdeItem;
import com.orangelala.pojo.OrdeItemExample;
import com.orangelala.pojo.OrdeItemExample.Criteria;
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
    /**
     * @Description:
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public OrdeItem getById(Long id) throws Exception {
	return orderItemMapper.selectByPrimaryKey(String.valueOf(id));
    }
    /**
     * @Description:根据orderId查询list
     * @param orderId
     * @return
     * @throws Exception
     */
    @Override
    public List<OrdeItem> getByOrderId(String orderId) throws Exception {
	OrdeItemExample example = new OrdeItemExample();
	Criteria criteria = example.createCriteria();
	criteria.andOrderIdEqualTo(orderId);
	List<OrdeItem> orderItems = orderItemMapper.selectByExample(example);
	return orderItems;
    }

}
