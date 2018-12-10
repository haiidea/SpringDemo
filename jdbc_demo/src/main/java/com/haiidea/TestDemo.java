package com.haiidea;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestDemo {
    private static void registerDriver() throws SQLException, ClassNotFoundException {
        // 这样会注册两次
        // 第一次
//        DriverManager.registerDriver(new Driver());
        // 第二次在Driver的静态代码块中,重复注册
        //如果执行一次，就直接类加载一次，会执行里面的静态代码块
        Class.forName("com.mysql.jdbc.Driver");
    }
    public static void main(String[] args) {
        //老办法
        java.sql.Statement statement=null;
        Connection connection=null;
        try {
            // 注册
            registerDriver();
            //连接数据库
            String url="jdbc:mysql://localhost:3306/mysql";
             connection = DriverManager.getConnection(url, "root", "root");
            //往表里加数据
             statement = connection.createStatement();
            int i = statement.executeUpdate("insert into student values(null,'lier')");

            System.out.println("i="+i+"   connection=" + connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
