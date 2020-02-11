package com.revature.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(){
        try{
            Configuration config = new Configuration();

            config.configure("hibernate.cfg.xml");

            // Option for assigning annotated classes
            assignAnnotatedClasses(config);

            return config.buildSessionFactory();

        }catch(Exception e){

            e.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory(){
        return (sessionFactory == null)? sessionFactory = buildSessionFactory(): sessionFactory;
    }

    private static void assignAnnotatedClasses(Configuration config){
        Reflections reflect = new Reflections("com.revature.models");
        Set<Class<? extends Object>> entities = reflect.getTypesAnnotatedWith(Entity.class);
        entities.forEach(config::addAnnotatedClass);
    }
}
