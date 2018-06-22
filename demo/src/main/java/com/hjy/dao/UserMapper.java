package com.hjy.dao;

import com.hjy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 通过主键id进行删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加全部信息
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 添加部分信息
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 通过主键id进行查找
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getList();
}