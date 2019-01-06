package com.orangelala.mapper;

import com.orangelala.pojo.itemDesc;
import com.orangelala.pojo.itemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface itemDescMapper {
    long countByExample(itemDescExample example);

    int deleteByExample(itemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(itemDesc record);

    int insertSelective(itemDesc record);

    List<itemDesc> selectByExampleWithBLOBs(itemDescExample example);

    List<itemDesc> selectByExample(itemDescExample example);

    itemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") itemDesc record, @Param("example") itemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") itemDesc record, @Param("example") itemDescExample example);

    int updateByExample(@Param("record") itemDesc record, @Param("example") itemDescExample example);

    int updateByPrimaryKeySelective(itemDesc record);

    int updateByPrimaryKeyWithBLOBs(itemDesc record);

    int updateByPrimaryKey(itemDesc record);
}