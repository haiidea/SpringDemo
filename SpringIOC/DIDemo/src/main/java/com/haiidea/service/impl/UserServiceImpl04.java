package com.haiidea.service.impl;

import com.haiidea.service.UserService;

import java.util.List;

public class UserServiceImpl04 implements UserService {
    private List<String> addr;

    @Override
    public void save() {
        System.out.println("调用了impl"+ getAddr().toString());
    }

    public List<String> getAddr() {
        return addr;
    }

    public void setAddr(List<String> addr) {
        this.addr = addr;
    }
}
