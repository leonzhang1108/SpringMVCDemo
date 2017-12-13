package com.leon.dao;

import com.leon.entity.User;

import java.util.List;

/**
 * Author: jianliangzhang
 * Date: 2017/12/13
 * Time: 16:42
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
