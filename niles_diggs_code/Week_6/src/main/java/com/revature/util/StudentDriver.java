package com.revature.util;

import com.revature.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentDriver {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student student_1 = new Student("niles", "diggs", "ndiggs@wes.edu");

            // Save the student as a record in the DB
            session.save(student_1);

            //Commit the transaction
            session.getTransaction().commit();

            //review the results
            System.out.println(student_1);
        }
    }
}
