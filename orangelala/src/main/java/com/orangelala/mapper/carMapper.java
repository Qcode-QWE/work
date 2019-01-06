package com.orangelala.mapper;

import com.orangelala.pojo.car;
import com.orangelala.pojo.carExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface carMapper {
    long countByExample(carExample example);

    int deleteByExample(carExample example);

    int deleteByPrimaryKey(Long carId);

    int insert(car record);

    int insertSelective(car record);

    List<car> selectByExample(carExample example);

    car selectByPrimaryKey(Long carId);

    int updateByExampleSelective(@Param("record") car record, @Param("example") carExample example);

    int updateByExample(@Param("record") car record, @Param("example") carExample example);

    int updateByPrimaryKeySelective(car record);

    int updateByPrimaryKey(car record);
}