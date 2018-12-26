package com.haiidea.service.impl;

import com.haiidea.service.UserService;
import org.springframework.stereotype.Service;

@Service("us")
public class UserserviceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("调用了impl us");
    }
}
