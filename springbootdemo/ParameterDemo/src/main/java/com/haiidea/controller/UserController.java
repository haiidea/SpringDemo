package com.haiidea.controller;

import com.haiidea.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("sign")
    public String sign(User user){
        System.out.println("name"+user.getName()+"    pw="+user.getPw());
        return "注册 success";
    }
}
