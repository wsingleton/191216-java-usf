package com.revature;

import com.revature.models.Instructor;
import com.revature.models.IntstructorDetails;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDriver {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Instructor instructor1 = new Instructor("wezley", "Singleton", "ws@gmail.com");
            IntstructorDetails details1 = new IntstructorDetails("java", "Astronoby");

            Instructor instructor2 = new Instructor("blake", "Kruppa", "bk@gmail.com");
            IntstructorDetails details2 = new IntstructorDetails("JavaScript", "Turtles");

            instructor1.setDetails(details1);
            instructor2.setDetails(details2);

            session.save(instructor1);
            session.save(instructor2);

            session.getTransaction().commit();

        } catch (Exception e){


            e.printStackTrace();
        }
    }
}
