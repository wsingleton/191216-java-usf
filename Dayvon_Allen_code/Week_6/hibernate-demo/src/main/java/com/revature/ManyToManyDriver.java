package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.models.Student;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManyToManyDriver {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            Transaction tx = session.beginTransaction();


            Instructor me = session.get(Instructor.class, 1);
            Course course3 = new Course("React with Redux");
            course3.setInstructor(me);

            Student student = new Student("Jerry", "Allen","jallen@gmail.com");
            Student student2 = new Student("Lee", "Hoang","leehoang@gmail.com");
            Student student3 = new Student("Tann", "Reagan","tannreagan@gmail.com");
            Student student4 = new Student("Ben", "Burke","bburke@gmail.com");

            course3.addStudent(student,student2,student3,student4);

            session.save(course3);


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
