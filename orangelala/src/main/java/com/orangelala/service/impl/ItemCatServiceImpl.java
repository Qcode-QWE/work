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
    public List<ItemCat> getItemCats() {
	int[] ids = {2,74,161,249,291,296,378,438,495,558,580,633,699,749,865,903};
	List<ItemCat> itemCats = new ArrayList<ItemCat>();
	
	for(int id :ids){
	    ItemCat itemCat = itemCatMapper.selectByPrimaryKey(Long.valueOf(id));
	    itemCats.add(itemCat);
	}
	return itemCats;
    }
}
