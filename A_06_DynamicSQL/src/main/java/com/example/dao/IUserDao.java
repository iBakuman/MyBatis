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

    /**
     *
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件：有可能有用户名，有可能有性别，也有可能有地址，还有可能是都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id集合查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
