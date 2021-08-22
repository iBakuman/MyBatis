package com.example.dao.impl;

import com.example.dao.IUserDao;
import com.example.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factor;

    public UserDaoImpl(SqlSessionFactory factor) {
        this.factor = factor;
    }

    @Override
    public List<User> findAll() {
        // 1.根据factory获取sqlSession对象
        SqlSession session = factor.openSession();
        // 2.调用SqlSession中的方法，查询列表
        List<User> users = session.selectList("com.example.dao.IUserDao.findAll");
        // 3.释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factor.openSession();
        // 2.调用方法实现保存
        session.insert("com.example.dao.IUserDao.saveUser", user);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

    @Override
    public void updateUser(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factor.openSession();
        // 2.调用方法实现保存
        session.update("com.example.dao.IUserDao.updateUser", user);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

    @Override
    public void deleteUser(Integer id) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factor.openSession();
        // 2.调用方法实现保存
        session.update("com.example.dao.IUserDao.deleteUser", id);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

    @Override
    public User findById(Integer userId) {
        // 1.根据factory获取sqlSession对象
        SqlSession session = factor.openSession();
        // 2.调用SqlSession中的方法，查询单个用户（selectOne）
        User user = session.selectOne("com.example.dao.IUserDao.findById", userId);
        // 3.释放资源
        session.close();
        return user;
    }

    @Override
    public List<User> findByUsername(String username) {
        // 1.根据factory获取sqlSession对象
        SqlSession session = factor.openSession();
        // 2.调用SqlSession中的方法，查询列表
        List<User> users = session.selectList("com.example.dao.IUserDao.findByUsername", username);
        // 3.释放资源
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        // 1.根据factory获取sqlSession对象
        SqlSession session = factor.openSession();
        // 2.调用SqlSession中的方法，查询单个用户（selectOne）
        Integer count = session.selectOne("com.example.dao.IUserDao.findTotal");
        // 3.释放资源
        session.close();
        return count;
    }
}
