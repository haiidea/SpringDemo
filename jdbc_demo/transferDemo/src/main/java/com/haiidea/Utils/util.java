package com.haiidea.Utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class util {
    private static String className;
    private static String url;
    private static String username;
    private static String password;
    static {
        try {
            Properties properties = new Properties();
            InputStream is = util.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            className = properties.getProperty("driverClassName");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnect(){
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(Statement statement, Connection connection){
        close(statement,connection,null);
    }
    public static void close(Statement statement, Connection connection,ResultSet resultSet){
        try {
            if(statement!=null) {
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
