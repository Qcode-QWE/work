package com.orangelala.mapper;

import com.orangelala.pojo.carItem;
import com.orangelala.pojo.carItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface carItemMapper {
    long countByExample(carItemExample example);

    int deleteByExample(carItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(carItem record);

    int insertSelective(carItem record);

    List<carItem> selectByExample(carItemExample example);

    carItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") carItem record, @Param("example") carItemExample example);

    int updateByExample(@Param("record") carItem record, @Param("example") carItemExample example);

    int updateByPrimaryKeySelective(carItem record);

    int updateByPrimaryKey(carItem record);
}