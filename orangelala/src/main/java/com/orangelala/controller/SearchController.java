package com.orangelala.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orangelala.domain.RecordResult;
import com.orangelala.pojo.Item;
import com.orangelala.service.ItemService;
import com.orangelala.service.impl.ItemServiceImpl;

@Controller
public class SearchController {
    	@Autowired
    	ItemService itemService ;
	@RequestMapping("/searchUI")
	public String searchUI() {
		return "search";
	}
	
	@RequestMapping("/searchUI/findall")
	@ResponseBody
	public RecordResult findall(@RequestParam(value="pageno",defaultValue="1")int pageno,String title,@RequestParam(value="sorttype",defaultValue="1")String sorttype) {
		try {
			List<Item> items = new ArrayList<Item>();
			//ItemService itemService = new ItemServiceImpl();
			if(sorttype == "price") {
				items =  itemService.getItemByTitleAndSorttype(pageno, title, sorttype);
			}
			else {
				items = itemService.getItemByTitle(pageno, title);
			}
			return RecordResult.ok(items);
		} catch (Exception e) {
			e.printStackTrace();
			return RecordResult.build(400, "查询条件出错");
		}

	}
	
}
