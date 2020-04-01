package com.revature.util;

import com.revature.models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {

        try {

            // Create the SessionFactory using the hibernate.cfg.xml
            Configuration config = new Configuration();

            // With no args, this method looks for a file on the class path called: hibernate.cfg.xml
            config.configure("hibernate.cfg.xml");

            // Option #2 for "registering" JPA-annotated classes with Hibernate
//            config.addAnnotatedClass(Student.class);
            assignAnnotatedClasses(config);

            // Using the provided configuration, build the SessionFactory
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
