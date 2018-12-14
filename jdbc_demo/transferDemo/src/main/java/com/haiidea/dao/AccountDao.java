package com.haiidea.dao;

import java.sql.SQLException;

public interface AccountDao {
    void outMoney() throws SQLException;
    void inMoney() throws SQLException;
}
