package com.orangelala.mapper;

import com.orangelala.pojo.CarItem;
import com.orangelala.pojo.CarItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarItemMapper {
    long countByExample(CarItemExample example);

    int deleteByExample(CarItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarItem record);

    int insertSelective(CarItem record);

    List<CarItem> selectByExample(CarItemExample example);

    CarItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarItem record, @Param("example") CarItemExample example);

    int updateByExample(@Param("record") CarItem record, @Param("example") CarItemExample example);

    int updateByPrimaryKeySelective(CarItem record);

    int updateByPrimaryKey(CarItem record);
}