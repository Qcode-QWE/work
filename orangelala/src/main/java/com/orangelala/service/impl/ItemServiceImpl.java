package com.orangelala.service.impl;

import java.util.ArrayList;
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
    
    /**
     * @Description:获取秒杀商品
     * @return
     */
    public List<Item> getKillItem() throws Exception{
	
	List<Long> idsList = new ArrayList<Long>();
	idsList.add(54227992398604L);
	idsList.add(54227992398601L);
	idsList.add(54227992398602L);
	idsList.add(54227992398603L);
	ItemExample example = new ItemExample();
	Criteria criteria = example.createCriteria();
	criteria.andIdIn(idsList);
	List<Item> items = itemMapper.selectByExample(example);
	return items;
    }

    /**
     * @Description:根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Item getItemById(Long id) throws Exception {
	Item item = itemMapper.selectByPrimaryKey(id);
	return item;
    }
    
    /**
     * @Description:查询所有商品
     * @param pageno,title
     * @return 商品list
     * @throws Exception
     */
    @Override
    public List<Item> getItemByTitle(int pageno,String title) throws Exception {
    	ItemExample itemExample = new ItemExample();
    	//分页
    	PageHelper.startPage(pageno,12);
    	//查询条件
    	Criteria criteria = itemExample.createCriteria();
		criteria.andTitleLike("%"+title+"%");

    	List<Item> items = itemMapper.selectByExample(itemExample);
    	
    	
    	return items;
    	
    }
    
    /**
     * @Description:查询所有商品且按照价格排序。
     * @param pageno,title,sorttype
     * @return 商品list
     * @throws Exception
     */
    @Override
    public List<Item> getItemByTitleAndSorttype(int pageno, String title, String sorttype) throws Exception {
    	ItemExample itemExample = new ItemExample();
    	//分页
    	PageHelper.startPage(pageno, 12);
    	//升序
    	System.out.println(sorttype);
    	itemExample.setOrderByClause(sorttype);
    	//查询
    	Criteria criteria = itemExample.createCriteria();
    	criteria.andTitleLike("%"+title+"%");
    	List<Item> items = itemMapper.selectByExample(itemExample);
    	
    	
    	return items;
    }
}
