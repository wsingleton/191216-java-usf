package com.revature;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class ManyToMany {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();

            Instructor me =session.get(Instructor.class, 3);
            
            Course

            session.getTransaction().commit();


        }catch(){}
    }
}
