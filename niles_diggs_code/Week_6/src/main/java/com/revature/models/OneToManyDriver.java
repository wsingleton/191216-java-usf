package com.revature.models;

import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class OneToManyDriver {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction(); // part of the transaction interface

            Instructor blake = session.get(Instructor.class, 4);


            Course course1 = new Course ("Hibernate Basics");
            Course course2 = new Course ("Advanced Hibernate Mappings");

            blake.addCourse(course1);
            blake.addCourse(course2);

            session.beginTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
