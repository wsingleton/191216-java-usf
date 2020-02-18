package com.revature;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetails;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDriver {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();

            Instructor instructor1 = new Instructor("Evan", "Hsi", "ehsi@gmail.com");
            InstructorDetails details1 = new InstructorDetails("Java", "Music");

            Instructor instructor2 = new Instructor("Ben", "Levine", "benlvn@gmail.com");
            InstructorDetails details2 = new InstructorDetails("Javascript", "Slacklining");

            instructor1.setInstructorDetails(details1);
            instructor2.setInstructorDetails(details2);

            session.save(instructor1);
            session.save(instructor2);

            session.getTransaction().commit();

        } catch(Exception e) {e.printStackTrace();}
    }
}
