package com.haiidea.dao.impl;

import com.haiidea.Student;
import com.haiidea.dao.StudentDao;
import com.haiidea.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 操作数据库代码
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public void add(String name, int age) {
        Connection connect = util.getConnect();
        String sql = "insert into student values(null,?,?)";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1,"name");
            preparedStatement.setInt(2,123);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(preparedStatement,connect);
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void upGrade(Student student) {

    }

    @Override
    public List<Student> query(int id) {
        Connection connect = util.getConnect();
        String sql = "select * from student where id=?";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(preparedStatement,connect);
        }

        return null;
    }
}
