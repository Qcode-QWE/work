package com.orangelala.mapper;

import com.orangelala.pojo.contentCategory;
import com.orangelala.pojo.contentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface contentCategoryMapper {
    long countByExample(contentCategoryExample example);

    int deleteByExample(contentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(contentCategory record);

    int insertSelective(contentCategory record);

    List<contentCategory> selectByExample(contentCategoryExample example);

    contentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") contentCategory record, @Param("example") contentCategoryExample example);

    int updateByExample(@Param("record") contentCategory record, @Param("example") contentCategoryExample example);

    int updateByPrimaryKeySelective(contentCategory record);

    int updateByPrimaryKey(contentCategory record);
}