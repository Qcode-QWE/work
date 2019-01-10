package com.orangelala.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;

import com.github.pagehelper.PageHelper;
import com.orangelala.mapper.ItemMapper;
import com.orangelala.pojo.Item;
import com.orangelala.pojo.ItemCat;
import com.orangelala.pojo.ItemExample;
import com.orangelala.pojo.ItemExample.Criteria;
import com.orangelala.service.ItemService;
import com.orangelala.utils.JedisUtils;

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
    private static Boolean flage = false;
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
     * @Description:判断能否完成秒杀
     * @param id
     * @return(0:还没开始,1:秒杀失败,2:秒杀成功)
     * @throws Exception
     */
    
    public int updateKillItem(Long id) throws Exception {
	//判断秒杀是否开始
	//Jedis jedis = JedisUtils.getJedis();
	//String str = jedis.get("KILLITEMFLAGE");
	String str = "1";
	//秒杀还没开始
	if(str!=null&&str.length()>0){
	   return 0;
	}else{
	    // 判断商品是否已经被秒杀
	    if(!flage){
		synchronized (flage) {
		   // str = jedis.get("KILLITEMNUM-" + id);
		    str = "1";
		    int num = Integer.valueOf(str);
		    if (num > 0) {
			//jedis.set("KILLITEMNUM-" + id, String.valueOf(num-1));
			//JedisUtils.close(jedis);
			flage = true;
			return 2;
		    }else{
			//JedisUtils.close(jedis);
			return 1;
		    }
		}
	    }
	    //JedisUtils.close(jedis);
	    return 1;
	}
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
     * @Description:根据id列表获取多个商品
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public List<Item> getItmesById(List<Long> ids) throws Exception {
	ItemExample example = new ItemExample();
	Criteria criteria = example.createCriteria();
	criteria.andIdIn(ids);
	List<Item> items = itemMapper.selectByExample(example);
	return items;
    }

    /**
     * @Description:
     * @param item
     * @throws Exception
     */
    @Override
    public void updateItem(Item item) throws Exception {
	itemMapper.updateByPrimaryKey(item);
    }
    
    /**
     * @Description:查询所有商品
     * @param pageno,title
     * @return list
     * @throws Exception
     */
    @Override
    public List<Item> getItemByTitle(int pageno,String title) throws Exception {
    	ItemExample itemExample = new ItemExample();
    	//分页
    	PageHelper.startPage(pageno,12);
    	//查询条件
    	Criteria criteria = itemExample.createCriteria();
    	if(StringUtils.isNotBlank(title)) {
    		criteria.andTitleLike("%"+title+"%");
    	}
    	List<Item> items = itemMapper.selectByExample(itemExample);
    	return items;
    	
    }
    
    /**
     * @Description:查询所有商品且按照价格排序。
     * @param pageno,title,sorttype
     * @return list
     * @throws Exception
     */
    @Override
    public List<Item> getItemByTitleAndSorttype(int pageno, String title, String sorttype) throws Exception {
    	ItemExample itemExample = new ItemExample();
    	//分页
    	PageHelper.startPage(pageno, 12);
    	//查询
    	Criteria criteria = itemExample.createCriteria();
    	if(title!="") {
        	criteria.andTitleLike(title);
    	}
    	//升序
    	itemExample.setOrderByClause(sorttype);
    	List<Item> items = itemMapper.selectByExample(itemExample);
    	
    	
    	return items;
    }
}
