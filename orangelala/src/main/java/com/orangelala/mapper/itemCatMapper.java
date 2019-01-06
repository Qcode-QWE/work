package com.orangelala.mapper;

import com.orangelala.pojo.itemCat;
import com.orangelala.pojo.itemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface itemCatMapper {
    long countByExample(itemCatExample example);

    int deleteByExample(itemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(itemCat record);

    int insertSelective(itemCat record);

    List<itemCat> selectByExample(itemCatExample example);

    itemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") itemCat record, @Param("example") itemCatExample example);

    int updateByExample(@Param("record") itemCat record, @Param("example") itemCatExample example);

    int updateByPrimaryKeySelective(itemCat record);

    int updateByPrimaryKey(itemCat record);
}