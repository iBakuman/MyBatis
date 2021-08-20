package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有操作
     * @return 查询结果的链表
     */
    List<User> findAll();
}
