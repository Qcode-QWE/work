package com.orangelala.service;

import java.util.List;

import com.orangelala.pojo.Item;
import com.orangelala.pojo.ItemCat;

public interface ItemService {

    List<Item> getItemsByItemCat(ItemCat itemCat) throws Exception;
    public List<Item> getKillItem() throws Exception;
}
