package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.Date;

public class XmlMappingDriver {
    public static  void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Employee emp = new Employee();
        emp.setName("hoang");
        emp.setRole("Devoloper");
        emp.setEnterTime(new Date());

        System.out.println(" Employ before being persisted:  " + emp);

        // start transaction
        session.beginTransaction();

        //persis/ save emp

        session.save(emp);

        //commit
        session.getTransaction().commit();

        System.out.println("new employee" + emp);
    }
}
