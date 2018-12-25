package com.haiidea.test;

import com.haiidea.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService) context.getBean("us");
//        UserService us = (UserService) context.getBean("us");
        us.save();
    }
}
