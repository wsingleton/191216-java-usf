package com.revature;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetails;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOneDriver {
    public static void main (String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction tx=session.beginTransaction();
//            Instructor inst1=new Instructor("Wezley", "Singleton", "wsingleton@gmail.com");
//            InstructorDetails deets1=new InstructorDetails("Java", "astronomy");
//            Instructor inst2=new Instructor("Blake", "Kruppa", "bk@gmail.com");
//            InstructorDetails deets2=new InstructorDetails("JavaScript", "Turtles");
//            inst1.setDetails(deets1);
//            inst2.setDetails(deets2);
//
//            session.save(inst1);
//            session.save(inst2);

           tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
