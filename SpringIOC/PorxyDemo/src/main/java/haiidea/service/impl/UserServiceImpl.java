package haiidea.service.impl;


import haiidea.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("调用了impl");
    }
}
