package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.models.Student;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class ManyToManyDriver {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();

            Instructor me = session.get(Instructor.class, 3);
            Course course3 = new Course("React with Redux!");
            course3.setInstructor(me);

            Student s1 = new Student("Dayvon", "Allen", "da@gmail.com");
            Student s2 = new Student("Hoang", "Le", "hl@gmail.com");
            Student s3 = new Student("Tann", "Reagan", "tr@gmail.com");
            Student s4 = new Student("Ben", "Burke", "bb@gmail.com");

            course3.addStudent(s1, s2, s3, s4);

            session.save(course3);

            session.getTransaction().commit();

        }
    }
}
