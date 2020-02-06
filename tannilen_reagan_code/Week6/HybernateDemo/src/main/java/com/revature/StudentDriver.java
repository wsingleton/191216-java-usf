package com.revature;

import com.revature.models.Student;
import com.revature.util.HibernateUtil;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentDriver {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        //addStudent();
        //addStudents();
        //getStudentByID();
        //loadStudentByID();
        //queryForStudent();
        //namedQueryForStudents();
        //namedNativeQueryForStudents();
        //criteriaQueryForStudents();
        //updateStudent();
        //updateQueryStudent();
    }

    public static void addStudent() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student s1 = new Student("Wezley", "Singleton", "ws@gmail.com");
            session.save(s1);
            session.getTransaction().commit();
            System.out.println(s1);
        }
    }

    public static void addStudents() {
        try (Session session = factory.getCurrentSession()) {
            Student[] students = {
                    new Student("Blake", "Kruppa", "bk@gmail.com"),
                    new Student("Genesis", "Bonds", "gb@gmail.com"),
                    new Student("Emily", "Higgins", "eh@gmail.com")
            };
            session.beginTransaction();
            for (Student s : students) session.save(s);
            session.getTransaction().commit();
            for (Student s : students) System.out.println(s);
        }
    }

    public static void getStudentByID() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student retrievedStudent = session.get(Student.class, 3);
            System.out.println(retrievedStudent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadStudentByID() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student retrievedStudent=session.load(Student.class, 4);
            System.out.println(retrievedStudent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void queryForStudent() {
        try (Session session=factory.getCurrentSession()) {
            session.beginTransaction();
            Query query1=session.createQuery("from Student s order by s.id desc", Student.class);
            List<Student> students=query1.getResultList();
            students.forEach(s-> System.out.println(s));

            Query query2=session.createQuery("from Student s where s.familyName='Singleton'", Student.class);
            students=query2.getResultList();
            students.forEach(s-> System.out.println(s));

            Query query3=session.createQuery("from Student s where s.givenName=:fn or s.familyName=:ln", Student.class);
            query3.setParameter("fn", "Blake");
            query3.setParameter("ln", "Singleton");
            students=query3.getResultList();
            students.forEach(s-> System.out.println(s));

            Query query4=session.createQuery("from Student s where s.email like :email", Student.class);
            query4.setParameter("email", "%@gmail.com");
            students=query4.getResultList();
            students.forEach(s-> System.out.println(s));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void namedQueryForStudents() {
        try (Session session=factory.getCurrentSession()) {
            session.beginTransaction();
            Query query1=session.getNamedQuery("findStudentByName_HQL");
            query1.setParameter("fn", "Genesis").setParameter("ln", "Bonds");
            List<Student> students=query1.getResultList();
            students.forEach(s-> System.out.println(s));
        }
    }

    public static void namedNativeQueryForStudents() {
        try (Session session=factory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> students= session.getNamedQuery("getStudentByID_SQL").setParameter("id", 3).getResultList();
            students.forEach(System.out::println);
        }
    }

    public static void criteriaQueryForStudents() {
        try (Session session=factory.getCurrentSession()) {
            session.beginTransaction();
            CriteriaBuilder queryBuilder=session.getCriteriaBuilder();
            CriteriaQuery<Student> critQuery=queryBuilder.createQuery(Student.class);
            Root<Student> queryRoot=critQuery.from(Student.class);
            critQuery.select(queryRoot);
            critQuery.where(queryBuilder.equal(queryRoot.get("email"),"ws@gmail.com"));
            List<Student> students=session.createQuery(critQuery).getResultList();
            students.forEach(System.out::println);
        }
    }

    public static void updateStudent() {
        try (Session session=factory.getCurrentSession()) {
            session.beginTransaction();
            Student s=session.get(Student.class, 1);
            System.out.println(s);
            s.setGivenName("Wesley");
            session.getTransaction().commit();
        }
    }

    public static void updateQueryStudent() {
        try(Session session=factory.getCurrentSession()) {
            session.beginTransaction();
            Query updateQuery=session.createQuery("update Student s set s.email=:email where s.id=:id");
            updateQuery.setParameter("email", "wsingleton@gmail.com").setParameter("id", 1);
            updateQuery.executeUpdate();
            session.getTransaction().commit();
            getAll();
        }
    }
    public static void getAll() {
        try (Session session=factory.getCurrentSession()) {
            session.beginTransaction();
            Query query1 = session.createQuery("from Student s order by s.id desc", Student.class);
            List<Student> students = query1.getResultList();
            students.forEach(s -> System.out.println(s));
        }
    }
}