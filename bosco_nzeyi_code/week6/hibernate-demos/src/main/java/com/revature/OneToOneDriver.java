package com.revature;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetails;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDriver {


    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    public static void main (String... args){

        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();

            Instructor instructor1 = new Instructor("Wezley", "Singleton", "ws@gmail.com");
            InstructorDetails details1 = new InstructorDetails("Java", "Astronomy");

            Instructor instructor2 = new Instructor("Blake", "Kruppa", "bk@gmail.com");
            InstructorDetails details2 = new InstructorDetails("JavaScript", "Turtles");

            instructor1.setDetails(details1);
            instructor2.setDetails(details2);

            session.save(instructor1);
            session.save(instructor2);

            session.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}