package com.haiidea.service.impl;

import com.haiidea.dao.UserDao;
import com.haiidea.service.UserService;

public class UserServiceImpl06 implements UserService {
    private UserDao userDao;

    public UserServiceImpl06(){
//        userDao = new UserDaoImpl();
    }
    @Override
    public void save() {
        System.out.println("调用了impl");
        getUserDao().save();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
