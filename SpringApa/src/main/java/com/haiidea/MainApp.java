package com.haiidea;

import com.haiidea.bean.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("aa");
        EntityManager manager = factory.createEntityManager();
        // 开事务
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        manager.persist(user);
        transaction.commit();
    }
}
