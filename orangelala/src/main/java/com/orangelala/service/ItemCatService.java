package com.orangelala.service;

import java.util.List;

import com.orangelala.pojo.ItemCat;

/**  
* <p>Title: ItemCatService.java</p>  
* <p>Description:商品类目业务层接口 </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
public interface ItemCatService {
    public List<ItemCat> getItemCats(List<Integer> ids) throws Exception;
    public List<ItemCat> getTowItemCats(Long id) throws Exception;
    public List<ItemCat> getThreeItemCats(Long id) throws Exception;
}
