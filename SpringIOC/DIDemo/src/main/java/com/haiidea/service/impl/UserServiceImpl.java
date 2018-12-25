package com.haiidea.service.impl;

import com.haiidea.service.UserService;

public class UserServiceImpl implements UserService {
    private String addr;

    public UserServiceImpl(){
    }

    public UserServiceImpl(String addr){
        this.addr = addr;
    }
    @Override
    public void save() {
        System.out.println("调用了impl"+addr);
    }
}
