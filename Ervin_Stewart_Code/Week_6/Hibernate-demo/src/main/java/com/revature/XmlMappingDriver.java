package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class XmlMappingDriver {
    public static void main(String[] args) {
        //establish a session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Employee emp = new Employee();
        emp.setName("John Stewart");
        emp.setRole("Developer King");
        emp.setInsertTime(new Date());

        System.out.println("Employee before being persisted: " + emp);

        session.beginTransaction();

        session.save(emp);

        session.getTransaction().commit();
        System.out.println("New Employee Added " + emp);

        //+--------------------------------------------------+

        session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name", "Ervin");

        List<Employee> employees = query.getResultList();
        employees.forEach(e -> System.out.println(e));

        HibernateUtil.getSessionFactory().close();

    }
}
