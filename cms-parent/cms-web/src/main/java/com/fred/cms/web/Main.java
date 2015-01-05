package com.fred.cms.web;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fred.cms.model.User;

public class Main {

    public static void main(String[] args) throws JSONException {
//        System.out.println("-------------");
//
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        UserController userController = (UserController) ac.getBean("userController");
//
//        System.out.println(userController);
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fred");
//        EntityManager em = emf.createEntityManager();
//        System.out.println(em);
//
        User user = new User();
        user.setPassword("123");
        user.setSalt("sault");
        user.setClientIp(99L);
        user.setCreated(new Date());
        user.setLastLogin(new Date());
//
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        em.persist(user);
//        transaction.commit();
//        em.close();
        
        System.out.println("AAA");
        JSONObject jo = new JSONObject();
        jo.accumulate("status", "success");
        
        System.out.println(jo.toString());
        
    }
}
