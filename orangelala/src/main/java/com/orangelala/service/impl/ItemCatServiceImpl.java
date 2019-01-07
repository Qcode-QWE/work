package com.orangelala.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.orangelala.mapper.ItemCatMapper;
import com.orangelala.pojo.ItemCat;
import com.orangelala.pojo.ItemCatExample;
import com.orangelala.pojo.ItemCatExample.Criteria;
import com.orangelala.service.ItemCatService;

/**  
* <p>Title: ItemCatServiceImpl.java</p>  
* <p>Description: 商品类目业务层实现类</p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
@Service
public class ItemCatServiceImpl implements ItemCatService{
    
    @Autowired
    private ItemCatMapper itemCatMapper;
    
    /**
     * @Description:获取一级分类的itemCat
     * @return
     */
    public List<ItemCat> getItemCats(List<Integer> ids) throws Exception{
	List<ItemCat> itemCats = new ArrayList<ItemCat>();
	
	for(int id :ids){
	    ItemCat itemCat = itemCatMapper.selectByPrimaryKey(Long.valueOf(id));
	    itemCats.add(itemCat);
	}
	return itemCats;
    }
    
    
    /**
     * @Description:根据一级目录id获取四个二级目录id
     * @param id
     * @return
     */
    public List<ItemCat> getTowItemCats(Long id) throws Exception{
	//分页处理
	//在执行查询前,进行分页
	ItemCatExample example = new ItemCatExample();
	PageHelper.startPage(1,4);
	Criteria criteria = example.createCriteria();
	//根据id查询
	criteria.andParentIdEqualTo(id);
	List<ItemCat> itemCats = itemCatMapper.selectByExample(example);
	return itemCats;
    }


    /**
     * @Description:根据二级目录id获取16个三级目录id
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<ItemCat> getThreeItemCats(Long id) throws Exception {
	//分页处理
	// 在执行查询前,进行分页
	ItemCatExample example = new ItemCatExample();
	PageHelper.startPage(1, 16);
	Criteria criteria = example.createCriteria();
	// 根据id查询
	criteria.andParentIdEqualTo(id);
	List<ItemCat> itemCats = itemCatMapper.selectByExample(example);
	return itemCats;
    }
    
    
}
