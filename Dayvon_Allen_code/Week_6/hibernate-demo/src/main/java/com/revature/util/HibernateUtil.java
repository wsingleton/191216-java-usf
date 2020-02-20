package com.revature.util;

import com.revature.models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static  SessionFactory buildSessionFactory() {
        try{
            //create the session factory
            Configuration config = new Configuration();
            //with no args, it looks for a file on the class path named: hibernate.cfg.xml, put string
            config.configure();

            //registering a JPA-annotated classes with hibernate
//            config.addAnnotatedClass(Student.class);
            //using the provided configuration, build the SessionFactory;
            assignAnnotatedClasses(config);
            return config.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw  new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return (sessionFactory == null) ? sessionFactory = buildSessionFactory() : sessionFactory;
    }

    private static void assignAnnotatedClasses(Configuration config){
        Reflections reflections = new Reflections("com.revature.models");
        Set<Class<? extends Object>> entities = reflections.getTypesAnnotatedWith(Entity.class);
        entities.forEach(config::addAnnotatedClass);
    }
}
