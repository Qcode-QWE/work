package com.orangelala.mapper;

import com.orangelala.pojo.OrdeItem;
import com.orangelala.pojo.OrdeItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdeItemMapper {
    long countByExample(OrdeItemExample example);

    int deleteByExample(OrdeItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrdeItem record);

    int insertSelective(OrdeItem record);

    List<OrdeItem> selectByExample(OrdeItemExample example);

    OrdeItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrdeItem record, @Param("example") OrdeItemExample example);

    int updateByExample(@Param("record") OrdeItem record, @Param("example") OrdeItemExample example);

    int updateByPrimaryKeySelective(OrdeItem record);

    int updateByPrimaryKey(OrdeItem record);
}