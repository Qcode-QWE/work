package com.orangelala.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.orangelala.mapper.ItemMapper;
import com.orangelala.pojo.Item;
import com.orangelala.pojo.ItemCat;
import com.orangelala.pojo.ItemExample;
import com.orangelala.pojo.ItemExample.Criteria;
import com.orangelala.service.ItemService;

/**  
* <p>Title: ItemServiceImpl.java</p>  
* <p>Description: </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    
    /**
     * @Description:根据商品类目id查询商品
     * @param itemCat
     * @return
     */
    @Override
    public List<Item> getItemsByItemCat(ItemCat itemCat)throws Exception {
	
	//分页处理
	ItemExample itemExample = new ItemExample();
	//分页
	PageHelper.startPage(1,12);
	//查询条件
	Criteria criteria = itemExample.createCriteria();
	criteria.andCidEqualTo(itemCat.getId());
	List<Item> items = itemMapper.selectByExample(itemExample);
	return items;
    }

}
