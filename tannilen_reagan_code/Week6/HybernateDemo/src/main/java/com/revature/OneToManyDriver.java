package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class OneToManyDriver {
    public static void main (String[] args) {
        try (Session session= HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Instructor blake=session.get(Instructor.class, 4);
            System.out.println(blake);
            Course course1=new Course("Hibernate Basics");
            Course course2=new Course("Advanced Hibernate Mappings");
            System.out.println(course1);
            System.out.println(course2);
            blake.addCourse(course1);
            blake.addCourse(course2);
            System.out.println(blake.getCourses());
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
