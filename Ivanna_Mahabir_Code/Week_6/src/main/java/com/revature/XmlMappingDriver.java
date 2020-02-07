package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class XmlMappingDriver {

    public static void main(String[] args){

        //Establish a session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        // Adding an employee (mapped using .hbm XML  - no JPA annotations)

        // Create the employee object (it will first be in the TRANSIENT state)
        Employee emp = new Employee();
        emp.setName("Scarlet");
        emp.setRole("Developer");
        emp.setInserTime(new Date());

        System.out.println("Employee before being persisted: " + emp);

        // Start a transaction within our session
        session.beginTransaction();

        // Persist/save the employee to our DB (Employee object created on line 19, is now in persisted state)
        session.save(emp);

        // Commit the transaction
        session.getTransaction().commit();


        System.out.println("New employee added: " + emp);

        // -------------------------------------
        System.out.println("------------------------");
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Get the named query in the get-employee-by-name.hbm.xml
        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name", "Stella");

        // Run the query and save its returned value into a collection
        List<Employee> employees = query.getResultList();

        // Print out the retrieved employee(s)
        employees.forEach(e -> System.out.println(e));

        // Close the SessionFactory - otherwise the app does not always stop after completing the main method
        HibernateUtil.getSessionFactory().close();

    }

}
