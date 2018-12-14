package com.haiidea.controller;

import com.haiidea.dao.Impl.AccountDaoImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class AccountController {
    @RequestMapping("doTransfer")
    public String doTransfer(){
        AccountDaoImpl dao = new AccountDaoImpl();
        try {
            dao.outMoney();
            dao.inMoney();
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getStackTrace().toString();
        }

        return "更新成功";
    }
}
