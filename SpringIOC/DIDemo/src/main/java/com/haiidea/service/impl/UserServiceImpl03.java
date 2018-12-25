package com.haiidea.service.impl;

import com.haiidea.service.UserService;

public class UserServiceImpl03 implements UserService {
    private String[] addr;

    @Override
    public void save() {
        System.out.println("调用了impl"+ getAddr().toString());
    }

    public String[] getAddr() {
        return addr;
    }

    public void setAddr(String[] addr) {
        this.addr = addr;
    }
}
