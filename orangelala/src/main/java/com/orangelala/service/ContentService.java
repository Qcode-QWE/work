package com.orangelala.service;

import java.util.List;

import com.orangelala.pojo.Content;

/**  
* <p>Title: ContentService.java</p>  
* <p>Description:广告业务层 </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
public interface ContentService {
    public List<Content> getContentByCategoryId(Long cid) throws Exception;
    public List<Content> getContentByCategoryIdOrderBy(Long cid) throws Exception;
}
