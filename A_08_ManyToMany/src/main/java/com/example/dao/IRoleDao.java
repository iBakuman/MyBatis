package com.example.dao;

import com.example.domain.Role;

import java.util.List;

/**
 * @author Avarice
 * @date 2021/10/1 19:36
 */
public interface IRoleDao {

    /**
     * 查询所有角色信息
     * @return
     */
    List<Role> findAll();
}
