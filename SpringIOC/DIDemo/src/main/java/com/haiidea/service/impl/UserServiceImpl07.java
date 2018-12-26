package com.haiidea.service.impl;

import com.haiidea.dao.UserDao;
import com.haiidea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("us")
public class UserServiceImpl07 implements UserService {
//    @Resource(name = "ud")
    @Autowired //与上面的作用效果相同，只能用在只有一个实现类的情况
    private UserDao userDao;

    public UserServiceImpl07(){
//        userDao = new UserDaoImpl();
    }
    @Override
    public void save() {
        System.out.println("调用了impl07");
        userDao.save();
    }

}
