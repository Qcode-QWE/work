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
	private ItemService itemService;
	
	/**
     * @Description:获取搜索页面
     * @param id
     * @return 搜索页面
     */
	
	@RequestMapping("/searchUI")
	public String searchUI() {
		return "search";
	}
	
	
	/**
     * @Description:搜索商品
     * @param pageno、title、sorttype
     * @return 商品信息
     */
	@RequestMapping("/searchUI/findall")
	@ResponseBody
	public RecordResult findall(@RequestParam("pageno")int pageno,@RequestParam("title")String title,@RequestParam("sorttype")String sorttype) {
		try {
			List<Item> items = new ArrayList<Item>();
			if(sorttype.equals("price")) {
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
