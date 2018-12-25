package com.haiidea.service.impl;

import com.haiidea.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl05 implements UserService {
    private Map<String,String> addr;

    @Override
    public void save() {
        System.out.println("调用了impl"+ getAddr().toString());
    }

    public Map<String,String> getAddr() {
        return addr;
    }

    public void setAddr(Map<String,String> addr) {
        this.addr = addr;
    }
}
