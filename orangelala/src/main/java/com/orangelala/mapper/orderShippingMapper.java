package com.orangelala.mapper;

import com.orangelala.pojo.orderShipping;
import com.orangelala.pojo.orderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderShippingMapper {
    long countByExample(orderShippingExample example);

    int deleteByExample(orderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(orderShipping record);

    int insertSelective(orderShipping record);

    List<orderShipping> selectByExample(orderShippingExample example);

    orderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") orderShipping record, @Param("example") orderShippingExample example);

    int updateByExample(@Param("record") orderShipping record, @Param("example") orderShippingExample example);

    int updateByPrimaryKeySelective(orderShipping record);

    int updateByPrimaryKey(orderShipping record);
}