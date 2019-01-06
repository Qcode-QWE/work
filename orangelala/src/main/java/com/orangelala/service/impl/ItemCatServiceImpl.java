package com.orangelala.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangelala.mapper.ItemCatMapper;
import com.orangelala.pojo.ItemCat;
import com.orangelala.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{
    
    @Autowired
    private ItemCatMapper itemCatMapper;
    
    /**
     * @Description:获取二级分类的itemCat
     * @return
     */
    public List<ItemCat> getItemCats(List<Integer> ids) {
	List<ItemCat> itemCats = new ArrayList<ItemCat>();
	
	for(int id :ids){
	    ItemCat itemCat = itemCatMapper.selectByPrimaryKey(Long.valueOf(id));
	    itemCats.add(itemCat);
	}
	return itemCats;
    }
}
