package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.models.Student;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class ManyToManyDriver {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Course course3 = new Course("React-Redux-Recycle");

            Instructor evan = session.get(Instructor.class, 3);

            course3.setInstructor(evan);

            // session.save(course3);

            Student s1 = new Student("Tony", "Smith", "asmith@gmail.com");
            Student s2 = new Student("Jared", "Carter", "jcarter@gmail.com");
            Student s3 = new Student("Ivanna", "Mahabir", "im@gmail.com");
            course3.addStudents(s1, s2, s3);

            session.save(course3);

            session.getTransaction().commit();
        }
    }
}
