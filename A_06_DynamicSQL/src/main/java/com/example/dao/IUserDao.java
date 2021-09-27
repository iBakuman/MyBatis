package com.example.dao;

import com.example.domain.QueryVo;
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

    /**
     * 根据名称模糊查询用户信息
     * @param username 要查询的用户名
     * @return 结果列表
     */
    List<User> findByUsername(String username);

    List<User> findUserByVo(QueryVo vo);
}
