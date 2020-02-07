package com.revature;

import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class XMLMappingDriver {

    public static void main (String [] args){

        // establish a session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        // Adding an employee (mapped using hbm xml no JPA annotations

        // create the employee object (it will first be in the transient state)
        Employee emp = new Employee();
        emp.setName("Steve");
        emp.setRole("Manager");
        emp.setInsertTime(new Date());

        System.out.println("Employee before being posted : " + emp);

        // start a transaction within our session
        session.beginTransaction();

        session.save(emp);

        session.getTransaction().commit();

        System.out.println("new Employee added: " + emp);

        // ----------------------------------------------------------------
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // get the named querry in the get-employee-by-name xml file
        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name", "Wezley");

        List<Employee> employees = query.getResultList();

        // print out the results
        employees.forEach(e -> System.out.println(e));

        // close the session factory
        HibernateUtil.getSessionFactory().close();


    }
}
