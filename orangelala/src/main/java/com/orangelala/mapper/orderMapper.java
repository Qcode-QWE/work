package com.orangelala.mapper;

import com.orangelala.pojo.order;
import com.orangelala.pojo.orderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderMapper {
    long countByExample(orderExample example);

    int deleteByExample(orderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(order record);

    int insertSelective(order record);

    List<order> selectByExample(orderExample example);

    order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") order record, @Param("example") orderExample example);

    int updateByExample(@Param("record") order record, @Param("example") orderExample example);

    int updateByPrimaryKeySelective(order record);

    int updateByPrimaryKey(order record);
}