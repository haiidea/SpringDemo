package com.haiidea.dao.Impl;

import com.haiidea.dao.AccountDao;
import com.haiidea.Utils.util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void outMoney() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update account set money=money-? where id=?";
        queryRunner.update(util.getConnect(),sql,500,1);
    }

    @Override
    public void inMoney() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update account set money=money+? where id=?";
        queryRunner.update(util.getConnect(),sql,500,1);
    }
}
