package com.hjy.dao;

import com.hjy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getList();

    int checkUsername(String username);

    User selectLogin(@Param("username") String username, @Param("password")String password);

    int deleteByUserIds(@Param("userIdList")List<String> userIdList);



}