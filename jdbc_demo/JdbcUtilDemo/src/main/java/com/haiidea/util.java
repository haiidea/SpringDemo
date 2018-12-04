package com.haiidea;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
