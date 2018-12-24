package com.haiidea.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class c3p0 {
    public void init() {
        //代码方式不方便管理，推荐用配置文件
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///itcast");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setInitialPoolSize(5);//初始数量
            dataSource.setMaxPoolSize(20);//如果达到最大值，后续任务等待执行，等的时间太长会放弃执行，或强行关闭比较久的链接。
            Connection connection = dataSource.getConnection();
            connection.prepareStatement("select * from student");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }

}
