package com.example.dao;

import com.example.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查找用户信息
     */
    User findById(Integer userId);
}
