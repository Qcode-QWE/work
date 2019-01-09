package com.orangelala.service;

import java.util.List;

import com.orangelala.pojo.Item;
import com.orangelala.pojo.ItemCat;

public interface ItemService {

    public List<Item> getItemsByItemCat(ItemCat itemCat) throws Exception;
    public List<Item> getKillItem() throws Exception;

    public Item getItemById(Long id) throws Exception;
    public List<Item> getItemByTitle(int pageno,String title) throws Exception;
    public List<Item> getItemByTitleAndSorttype(int pageno,String title,String sorttype) throws Exception;

    public int updateKillItem(Long id) throws Exception;

}
