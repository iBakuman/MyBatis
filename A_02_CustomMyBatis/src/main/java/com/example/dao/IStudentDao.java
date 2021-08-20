package com.example.dao;

import com.example.domain.Student;
import com.example.mybatis.annotations.Select;
import java.util.List;

public interface IStudentDao {
    /**
     * 查询所有记录
     * @return 返回封装了的对象数组
     */
    @Select("select * from student")
    List<Student> findAll();
}
