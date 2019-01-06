package com.orangelala.mapper;

import com.orangelala.pojo.content;
import com.orangelala.pojo.contentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface contentMapper {
    long countByExample(contentExample example);

    int deleteByExample(contentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(content record);

    int insertSelective(content record);

    List<content> selectByExampleWithBLOBs(contentExample example);

    List<content> selectByExample(contentExample example);

    content selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") content record, @Param("example") contentExample example);

    int updateByExampleWithBLOBs(@Param("record") content record, @Param("example") contentExample example);

    int updateByExample(@Param("record") content record, @Param("example") contentExample example);

    int updateByPrimaryKeySelective(content record);

    int updateByPrimaryKeyWithBLOBs(content record);

    int updateByPrimaryKey(content record);
}