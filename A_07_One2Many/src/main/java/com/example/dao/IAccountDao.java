package com.example.dao;

import com.example.domain.Account;

import java.util.List;

/**
 * @author Avarice
 * @date 2021/9/30 22:40
 */
public interface IAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();


}
