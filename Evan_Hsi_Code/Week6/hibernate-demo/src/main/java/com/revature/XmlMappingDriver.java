package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class XmlMappingDriver {

    public static void main(String[] args) {

        // Establish a session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        // ADDING AN EMPLOYEE (mapped using .hbm XML - no JPA annotations)

        // Create the Employee object (it will first be in the TRANSIENT state)
        Employee emp = new Employee();
        emp.setName("Conrad");
        emp.setRole("Marketing");
        emp.setInsertTime(new Date());

        System.out.println("Employee before being persisted: " + emp);

        // Start a transaction with our session
        session.beginTransaction();

        // Persist/save the employee to our DB (Employee object is now in the PERSISTENT state)
        session.save(emp);

        // Commit the transaction
        session.getTransaction().commit();

        System.out.println("New employee added: " + emp);

        //------------------------------------------------

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Get the named query defined in the get-employee-by-name.hbm.xml

        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name", "Conrad");

        // Run the query and save its returned value into a collection

        List<Employee> employees = query.getResultList();

        // Print out the retrieved employee(s)

        employees.forEach(e -> System.out.println(e));

        // Close the SessionFactory - otherwise, the app does not always stop after completing the main method
        HibernateUtil.getSessionFactory().close();

    }
}
