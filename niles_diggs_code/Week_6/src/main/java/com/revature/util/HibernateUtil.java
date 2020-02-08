package com.revature.util;

import com.revature.models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class HibernateUtil {

    //this is where we will build the SessionFactory

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {

            // Create the SessionFactory using the hibernate.cfg.xml
            Configuration config = new Configuration();

            // with no args this looks for the name we created our xml file with, add the string of name if changed
            config.configure();

            // registering JPA annotated classes with hibernate
            //config.addAnnotatedClass(Student.class);
            assignAnnotatedClasses(config);


            // building the SessionFactory, using the provided configuration
            return config.buildSessionFactory();
        }catch (Exception e) {
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
