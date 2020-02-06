package com.revature.util;

import com.revature.models.Student;
import org.hibernate.SessionFactory;

import javax.security.auth.login.AppConfigurationEntry;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory(){
        try{

            Configuration config = new Configuration();
            config.configure("hibernate-cfg.xml");
            config.addAnnotatedClass(Student.class);

            return config.buildSessionFactory();

        }catch(Exception e){ e.printStackTrace();
        throw new ExceptionInInitializerError(e);}
    }

    public static SessionFactory getSessionFactory(){
        return (sessionFactory == null) ? sessionFactory = buildSessionFactory() : sessionFactory;
    }
}
