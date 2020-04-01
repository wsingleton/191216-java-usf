package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToManyDriver {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            Transaction tx = session.beginTransaction();

            Instructor blake = session.get(Instructor.class, 4);
            blake.getCourses().forEach(System.out::println);

            Course course1 = new Course("Hibernate Basics");
            Course course2 = new Course("Advanced Hibernate Mappings");

            blake.addCourse(course1);
            blake.addCourse(course2);

            session.save(course1);
            session.save(course2);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
