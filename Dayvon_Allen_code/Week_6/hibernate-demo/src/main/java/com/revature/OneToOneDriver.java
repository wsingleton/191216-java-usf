package com.revature;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetails;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDriver {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Instructor instructor = new Instructor("David", "Singleton", "dsingleton@gmail.com");
            InstructorDetails details = new InstructorDetails("Java", "Drawing");

            Instructor instructor1 = new Instructor("Jacky", "Smith", "jsmith@gmail.com");
            InstructorDetails instructorDetails = new InstructorDetails("JavaScript", "Cooking");

            instructor.setDetails(details);
            instructor1.setDetails(instructorDetails);

            session.save(instructor);
            session.save(instructor1);

            session.getTransaction().commit();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
