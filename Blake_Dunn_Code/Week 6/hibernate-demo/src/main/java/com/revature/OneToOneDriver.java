package com.revature;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetails;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDriver {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();

            Instructor instructor1 = new Instructor("Blake", "Dunn", "bd@buhlakify.com");
            InstructorDetails details1 = new InstructorDetails("Coding", "Lacrosse");

            Instructor instructor2 = new Instructor("Wezley", "Singleton", "ws@buhlakify.com");
            InstructorDetails details2 = new InstructorDetails("Java", "Astronomy");

            instructor1.setDetails(details1);
            instructor2.setDetails(details2);

            session.save(instructor1);
            session.save(instructor2);

            session.getTransaction().commit();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
