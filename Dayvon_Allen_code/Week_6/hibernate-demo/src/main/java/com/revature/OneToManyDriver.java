package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToManyDriver {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){

            Transaction tx = session.beginTransaction();

            Instructor instruct = session.get(Instructor.class, 2);
            instruct.getCourses().forEach(System.out::println);
//            Course course = new Course(("Hibernate Basic"));
//            Course course1 = new Course("Advanced Hibernate Mappings");
//
//            instruct.addCourse(course);
//            instruct.addCourse(course1);
//
//            session.save(course);
//            session.save(course1);
//
//            tx.commit();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
