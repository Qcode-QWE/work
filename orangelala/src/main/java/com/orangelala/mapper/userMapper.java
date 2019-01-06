package com.orangelala.mapper;

import com.orangelala.pojo.user;
import com.orangelala.pojo.userExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userMapper {
    long countByExample(userExample example);

    int deleteByExample(userExample example);

    int deleteByPrimaryKey(Long id);

    int insert(user record);

    int insertSelective(user record);

    List<user> selectByExample(userExample example);

    user selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") user record, @Param("example") userExample example);

    int updateByExample(@Param("record") user record, @Param("example") userExample example);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}