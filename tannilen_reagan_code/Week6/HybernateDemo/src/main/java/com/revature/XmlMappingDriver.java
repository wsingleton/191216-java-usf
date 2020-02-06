package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class XmlMappingDriver {
    public static void  main(String[] args) {
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println("Creating employee object.");
        Employee emp=new Employee();
        emp.setName("Steve");
        emp.setRole("Manager");
        emp.setInsertTime(new Date());
        System.out.println("Employee create: " + emp.toString());
        session.beginTransaction();
        session.save(emp);
        System.out.println("Persisting employee.");
        session.getTransaction().commit();
        System.out.println("Employee persisted: " + emp);

        session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createNamedQuery("getEmployeeByName");
        query.setParameter("name", "Wezley");
        List<Employee> employees=query.getResultList();
        employees.forEach(e -> System.out.println(e));
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
