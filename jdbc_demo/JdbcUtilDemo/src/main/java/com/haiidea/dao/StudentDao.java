package com.haiidea.dao;

import com.haiidea.Student;

import java.util.List;

public interface StudentDao {
    void add(String name,int age);
    void delete(int id);
    void upGrade(Student student);
    List<Student> query(int id);
}
