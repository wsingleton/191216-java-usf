package com.revature.util;

import com.revature.models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {

        try {

            // Create the SessionFactory using the hibernate.cfg.xml
            Configuration config = new Configuration();

            // with no args, this method looks for a file on the class path called: hibernate.cfg.xml
            config.configure();

            // Option #2 for "registering" JPA-annotated classes with Hibernate
            config.addAnnotatedClass(Student.class);

            // Using the provided configuration, build the sessionFactory
            return config.buildSessionFactory();

        }catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return (sessionFactory == null) ? sessionFactory = buildSessionFactory() : sessionFactory;
    }
}
