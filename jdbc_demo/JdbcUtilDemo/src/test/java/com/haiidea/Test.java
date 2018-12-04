package com.haiidea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    @org.junit.Test
    public void query(){
        Connection connect = util.getConnect();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                System.out.println("id="+id+"   name="+name+"  age="+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            util.close(statement,connect);
        }
    }
    @org.junit.Test
    public void save(){
        Connection connect = util.getConnect();
        Statement statement = null;
        ResultSet resultSet =null;
        try {
            statement = connect.createStatement();
            statement.execute("insert into student values (null,'立白',23)");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(statement,connect, resultSet);
        }
    }
    @org.junit.Test
    public void update(){
        Connection connect = util.getConnect();
        Statement statement = null;
        try {
            statement = connect.createStatement();
            statement.execute("update student set age=222 where id=13");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(statement,connect);
        }
    }
    @org.junit.Test
    public void del(){
        Connection connect = util.getConnect();
        Statement statement = null;
        try {
            statement = connect.createStatement();
            statement.execute("delete from student where id=13");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(statement,connect);
        }
    }
}
