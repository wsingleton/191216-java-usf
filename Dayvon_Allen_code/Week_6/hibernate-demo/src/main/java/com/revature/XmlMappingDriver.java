package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class XmlMappingDriver {

    public static void main(String[] args) {

        //Establish a session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        //Adding an employee(mapped using .hbm xml - no JPA annotation)


        //create the employee object (it will first be in the transietn state)
        System.out.println("creating employee");

        Employee emp = new Employee();
        emp.setName("Jeffrey");
        emp.setRole("Developer");
        emp.setInsertTime(new Date());
        System.out.println("Employee before persistence: " + emp);

        //start a transaction within our session
        session.beginTransaction();

        //persist or save employee to our db(employee object persisted)
        session.save(emp);

        //commit employee
        session.getTransaction().commit();

        System.out.println("Persisted employee: " + emp);

        //-------------------------------------

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //get the named query defined in the get-employee-by-name.xml file
        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name", "Jack");

        //Run the query and save its returned value into a collection

        List<Employee> employees = query.getResultList();

        //print out the retrieved employees
        employees.forEach(e -> System.out.println(e));

        //close the session factory - otherwise the app does not always stop after completing the main method
        session.close();
        HibernateUtil.getSessionFactory().close();


    }

}
