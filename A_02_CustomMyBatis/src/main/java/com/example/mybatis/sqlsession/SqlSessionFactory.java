package com.example.mybatis.sqlsession;

public interface SqlSessionFactory {
    /**
     * 用于带卡一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
