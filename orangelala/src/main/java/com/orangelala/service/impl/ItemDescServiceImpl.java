/**  
* <p>Title: ItemDescServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.ItemDescMapper;
import com.orangelala.pojo.ItemDesc;
import com.orangelala.service.ItemDescService;

/**  
 * <p>Title: ItemDescServiceImpl.java</p>  
 * <p>Description: 商品简介</p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
@Service
public class ItemDescServiceImpl implements ItemDescService{

    @Autowired
    private ItemDescMapper itemDescMapper;
    
    /**
     * @Description:查询商品简介
     * @param itemId
     * @return
     * @throws Exception
     */
    @Override
    public ItemDesc getItemDesc(Long itemId) throws Exception {
	ItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
	return itemDesc;
    }

}
