package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToManyDriver {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            Transaction tx = session.beginTransaction();

            Instructor ben = session.get(Instructor.class, 4);

            Course course1 = new Course("Javascript Basics");
            Course course2 = new Course("Advanced Javascript");
            ben.addCourse(course1);
            ben.addCourse(course2);
            session.save(course1);
            session.save(course2);

            tx.commit();

        } catch (Exception e) { e.printStackTrace(); }
    }
}
