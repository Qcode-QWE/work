package com.orangelala.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.orangelala.mapper.ContentMapper;
import com.orangelala.pojo.Content;
import com.orangelala.pojo.ContentExample;
import com.orangelala.pojo.ContentExample.Criteria;
import com.orangelala.service.ContentService;

/**  
* <p>Title: ContentServiceImpl.java</p>  
* <p>Description:广告业务层实现类 </p>   
* @author QEcode  
* @date 2019年1月7日  
* @version 1.0  
*/ 
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;


    /**
     * @Description:根据广告类目id查询广告
     * @param cid
     * @return
     * @throws Exception
     */
    public List<Content> getContentByCategoryId(Long cid) throws Exception {
	//条件查询
	ContentExample example  = new ContentExample();
	//根据广告类目id查询广告
	Criteria criteria = example.createCriteria();
	criteria.andCategoryIdEqualTo(cid);
	//查询
	List<Content> contents = contentMapper.selectByExample(example);
	return contents;
    }


    /**
     * @Description:根据广告类目id查询最新的7篇文章
     * @param cid
     * @return
     * @throws Exception
     */
    @Override
    public List<Content> getContentByCategoryIdOrderBy(Long cid)
	    throws Exception {
	//条件查询
	ContentExample example = new ContentExample();
	//分页
	PageHelper.startPage(1,7);
	// 根据广告类目id查询广告
	Criteria criteria = example.createCriteria();
	criteria.andCategoryIdEqualTo(cid);
	//排序
	example.setOrderByClause("updated desc");
	//查询
	List<Content> contents = contentMapper.selectByExample(example);
	return contents;
    }
    
  
    
}
