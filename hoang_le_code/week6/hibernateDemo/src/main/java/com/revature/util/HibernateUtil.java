package com.revature.util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory(){
        try{
            Configuration config = new Configuration();

            config.configure("hibernate.cfg.xml");
            return config.buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError();
        }


    }

    public static SessionFactory getSessionFactory(){
        return (sessionFactory == null) ? sessionFactory = buildSessionFactory(): sessionFactory;
    }

}
