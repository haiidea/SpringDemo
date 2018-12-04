package com.haiidea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestDemo {
    public static void main(String[] args) {
        //老办法
        java.sql.Statement statement=null;
        Connection connection=null;
        try {
            connection = util.getConnect();
            //往表里加数据
             statement = connection.createStatement();
            int i = statement.executeUpdate("insert into student values(null,'lier')");

            System.out.println("i="+i+"   connection=" + connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(statement,connection);
        }
    }
}
