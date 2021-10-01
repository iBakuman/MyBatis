package com.example.dao;

import com.example.domain.Account;
import com.example.domain.AccountUser;

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

    /**
     * 查询所有账户及其户主信息
     * @return
     */
    List<AccountUser> findAllAccountWithUser();
}
