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
     * 保存用户信息到数据库
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     */
    void deleteUser(Integer id);

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
     * 使用实体类的包装对象作为查询条件
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);
    /**
     * 查询总记录条数
     * @return 总记录条数
     */
    int findTotal();
}
