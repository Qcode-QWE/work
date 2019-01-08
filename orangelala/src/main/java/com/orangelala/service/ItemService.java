package com.orangelala.service;

import java.util.List;

import com.orangelala.pojo.Item;
import com.orangelala.pojo.ItemCat;

public interface ItemService {

    public List<Item> getItemsByItemCat(ItemCat itemCat) throws Exception;
    public List<Item> getKillItem() throws Exception;
    public Item getItemById(Long id) throws Exception;
}
