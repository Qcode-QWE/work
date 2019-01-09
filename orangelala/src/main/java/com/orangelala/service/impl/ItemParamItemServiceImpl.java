/**  
* <p>Title: ItemParamItemServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月8日  
* @version 1.0  
*/  
package com.orangelala.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.ItemParamItemMapper;
import com.orangelala.pojo.ItemParamItem;
import com.orangelala.pojo.ItemParamItemExample;
import com.orangelala.pojo.ItemParamItemExample.Criteria;
import com.orangelala.service.ItemParamItemService;

/**  
 * <p>Title: ItemParamItemServiceImpl.java</p>  
 * <p>Description: 商品规格</p>   
 * @author QEcode  
 * @date 2019年1月8日  
 * @version 1.0  
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;
    /**
     * @Description:根据商品id查询商品规格
     * @param itemId
     * @return
     * @throws Exception
     */
    @Override
    public ItemParamItem getItemParamItem(Long itemId) throws Exception {
	ItemParamItemExample example  = new ItemParamItemExample();
	Criteria criteria = example.createCriteria();
	criteria.andItemIdEqualTo(itemId);
	List<ItemParamItem> itemParamItems = itemParamItemMapper.selectByExample(example);
	ItemParamItem itemParamItem = null;
	if (itemParamItems!=null&&itemParamItems.size()>0) {
	    itemParamItem = itemParamItems.get(0);
	}
	return itemParamItem;
    }

}
