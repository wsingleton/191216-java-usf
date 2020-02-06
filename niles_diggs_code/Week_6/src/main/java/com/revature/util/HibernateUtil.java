package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //this is where we will build the SessionFactory

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {

            // Create the SessionFactory using the hibernate.cfg.xml
            Configuration config = new Configuration();

            // with no args this looks for the name we created our xml file with, add the string of name if changed
            config.configure();

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
}
