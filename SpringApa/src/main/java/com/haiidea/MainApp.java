package com.haiidea;

import com.haiidea.bean.User;

import javax.persistence.*;

public class MainApp {
    public static void main(String[] args) {
        //要执行增删改查 一定有管理员
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("aa");
        EntityManager manager = factory.createEntityManager();
        // 开事务
        EntityTransaction transaction = manager.getTransaction();
        // 写入事物一定要有事物，不然无法写入
        transaction.begin();
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        manager.persist(user);
        transaction.commit();


        // 查询 通过主键查询 find只能找一个
        User user1 = manager.find(User.class, 1);
        //删除 也要开事物
        transaction.begin();
        manager.remove(user1);
        transaction.commit();
        // 修改
        manager.persist(user1);
        //查所有 需要类的名字不是表的名字，*号也不能用
        Query query = manager.createQuery("select t from Student t");
        query.getResultList();
        //释放资源
        manager.close();

        factory.close();
    }
}
