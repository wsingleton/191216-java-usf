package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.Date;
import java.util.List;

public class XmlMappingDriver {
    public static  void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Employee emp = new Employee();
        emp.setName("hoangle");
        emp.setRole("Manager");
        emp.setEnterTime(new Date());

        System.out.println(" Employ before being persisted:  " + emp);

        // start transaction
        session.beginTransaction();

        //persis/ save emp

        session.save(emp);

        //commit
        session.getTransaction().commit();

        System.out.println("new employee" + emp);


        //--------------------------------------

        System.out.println("---------------------------------------------");
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name","hoang");
        // run and save it to list
        List<Employee> employees = query.getResultList();


        // print out list
        employees.forEach(e -> System.out.println(e));


        HibernateUtil.getSessionFactory().close();


    }
}
