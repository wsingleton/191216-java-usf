package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.transaction.UserTransaction;
import java.util.Date;
import java.util.List;

public class XmlMappingDriver {

    public static void main(String[] args) {
        // this would be the logic of the repo
        // Establish a session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        // create the Employee obj (it will first be in the transient state)
        Employee emp = new Employee();

        emp.setName("Steve");
        emp.setRole("Angel");
        emp.setInsertTime(new Date());

        // start a transaction
        session.beginTransaction();

        // persist/save the employee to DB (emp OBJ from line 17 is now in the persisted state)
        session.save(emp);

        // commit the transaction
        session.getTransaction().commit();

        System.out.println("++++++++++++++++++++++++++++++++++++++");

        session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        //Get the named query defined in the get-employee-by-name.hbm.xml
        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name", "Niles");

        //Run the query and save its returned values in to the collection
        List<Employee> employees = query.getResultList();

        //print out the retrieved employees
        employees.forEach(System.out::println);

        //Close the SessionFactory - otherwise the app does not always stop after completing the main method
        HibernateUtil.getSessionFactory().close();
    }
}
