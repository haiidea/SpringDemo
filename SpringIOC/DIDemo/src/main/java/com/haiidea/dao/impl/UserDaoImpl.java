package com.haiidea.dao.impl;

import com.haiidea.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("ud")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("调用 了 userdao");
    }
}
