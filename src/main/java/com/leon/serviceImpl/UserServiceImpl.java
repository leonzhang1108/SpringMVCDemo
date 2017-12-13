package com.leon.serviceImpl;

import com.leon.dao.UserMapper;
import com.leon.entity.User;
import com.leon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: jianliangzhang
 * Date: 2017/12/13
 * Time: 16:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
