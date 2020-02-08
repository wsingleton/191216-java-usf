package com.revature.util;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;

public class OneToOneDriver {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();

            Instructor instructor1 = new Instructor("Wez", "Singleton", "wez@gmail.com");
            InstructorDetails details1 = new InstructorDetails("Java", "Astronomy");

            Instructor instructor2 = new Instructor("Blake", "Kruppa", "bk@gmail.com");
            InstructorDetails details2 = new InstructorDetails("JavaScript", "Turtles");

            instructor1.setDetails(details1);
            instructor2.setDetails(details2);

            session.save(instructor1);
            session.save(instructor2);

            session.getTransaction().commit();
        }
    }
}
