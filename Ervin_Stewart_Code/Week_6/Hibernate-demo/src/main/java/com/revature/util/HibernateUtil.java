package com.revature.util;

import com.revature.models.Student;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.security.auth.login.AppConfigurationEntry;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import java.util.Set;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {

            Configuration config = new Configuration();
            config.configure("hibernate-cfg.xml");
//            config.addAnnotatedClass(Student.class);
            assignAnnotatedClasses(config);

            return config.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return (sessionFactory == null) ? sessionFactory = buildSessionFactory() : sessionFactory;
    }

    private static void assignAnnotatedClasses(Configuration config) {
        Reflections reflect = new Reflections("com.revature.models");
        Set<Class<? extends Object>> entities = reflect.getTypesAnnotatedWith(Entity.class);
        entities.forEach(config::addAnnotatedClass);
    }
}