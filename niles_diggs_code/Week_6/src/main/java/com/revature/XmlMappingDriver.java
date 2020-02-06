package com.revature;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class XmlMappingDriver {

    public static void main(String[] args) {
        // this would be the logic of the repo
        // Establish a session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        // create the Employee obj (it will first be in the transient state)
        Employee emp = new Employee();

        emp.setName("Niles");
        emp.setRole("GOD");
        emp.setInsertTime(new Date());

        // start a transaction
        session.beginTransaction();

        // persist/save the employee to DB (emp OBJ from line 17 is now in the persisted state)
        session.save(emp);

        // commit the transaction
        session.getTransaction().commit();
    }
}
