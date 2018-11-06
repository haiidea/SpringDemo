package com.haiidea;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDemo {
    public static void main(String[] args) {
        //老办法
        java.sql.Statement statement=null;
        Connection connection=null;
        try {
            // 注册
            DriverManager.registerDriver(new Driver());
            //连接数据库
            String url="jdbc:mysql://localhost:3306/mysql";
             connection = DriverManager.getConnection(url, "root", "root");
            //往表里加数据
             statement = connection.createStatement();
            int i = statement.executeUpdate("insert into student values(null,'lier')");

            System.out.println("i="+i+"   connection=" + connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) {
                    statement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
