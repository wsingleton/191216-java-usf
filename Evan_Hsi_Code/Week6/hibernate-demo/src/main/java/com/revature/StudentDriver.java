package com.revature;

import com.revature.models.Student;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class StudentDriver {

    public static void main(String[] args) {

        // addStudent();
        // addStudents();
        // getStudentById(2);
        // loadStudentsById(2);
        // queryForStudent();
        // namedQueryForStudents();
        // namedNativeQueryForStudents();
        // criteriaQueryForStudents();
        // updateStudent();
        updateQueryStudent();
        // deleteStudent();
    }

    public static void addStudent() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            // CREATE STUDENT DEMO
            session.beginTransaction();

            // Create a student object
            Student student_1 = new Student("Evan", "Hsi", "ehsi@gmail.com");

            // Save the student as a record in the DB
            session.save(student_1);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println(student_1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStudents() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student[] students = {
                    new Student("Conrad", "Diao", "ecdiao@gmail.om"),
                    new Student("Jake", "Wilson", "jakewi@gmail.com"),
                    new Student("Ryan", "Sharrar", "rsharrar@gmail.com")
            };

            for(Student s: students) session.save(s);
            session.getTransaction().commit();

            for(Student s: students) System.out.println(s);
        }
    }

    public static void getStudentById(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            // .get() returns the persistent object (eagerly-fetched)
            // returns null if not found
            Student retrievedStudent = session.get(Student.class, id);

            System.out.println(retrievedStudent);

        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void loadStudentById(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            // .load() returns a proxy, which is then converted into a persistent object when a method is invoked on it. (lazily-fetched)
            // throws SQLException if not found.
            Student retrievedStudent = session.load(Student.class, id);

            System.out.println(retrievedStudent);

        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void queryForStudent() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Query query1 = session.createQuery("from Student s order by s.id desc", Student.class);
            List<Student> students = query1.getResultList();
            students.forEach(student -> System.out.println(student));

            Query query2 = session.createQuery("from Student s where s.lastName = 'Sharrar'", Student.class);
            students = query2.getResultList();
            students.forEach(student -> System.out.println(student));

            Query query3 = session.createQuery("from Student s where s.firstName = :fn or s.lastName = :ln", Student.class);

            query3.setParameter("fn", "Evan");
            query3.setParameter("ln", "Diao");

            students = query3.getResultList();
            students.forEach(student -> System.out.println(student));

            Query query4 = session.createQuery("from Student s where s.email like :email", Student.class);
            query4.setParameter("email", "%@gmail.%");
            students = query4.getResultList();
            students.forEach(student -> System.out.println(student));


        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void namedQueryForStudents() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query query1 = session.getNamedQuery("getStudentByName_HQL");
            query1.setParameter("fn", "Jake").setParameter("ln", "Wilson");
            List<Student> students = query1.getResultList();
            students.forEach(student -> System.out.println(student));

        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void namedNativeQueryForStudents() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query query1 = session.getNamedNativeQuery("getStudentById_SQL");
            query1.setParameter("id", 2);
            List<Student> students = query1.getResultList();
            students.forEach(System.out::println);

        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void criteriaQueryForStudents() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            // Create a CriteriaBuilder object to build our CriteriaQuery/Update/Delete

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            // Query for all students
            // SQL: select * from students
            // HQL: from Student

            // Create our CriteriaQuery object
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            // Set the query "root" (the table we will be querying)
            Root<Student> queryRoot = criteriaQuery.from(Student.class);

            // Indicate the SELECT clause of our query
            criteriaQuery.select(queryRoot);

            // Add a restriction (WHERE clause)
            criteriaQuery.where(
                criteriaBuilder.equal(queryRoot.get("email"), "ehsi@gmail.com")
            );

            // Execute the query
            List<Student> students = session.createQuery(criteriaQuery).getResultList();
            students.forEach(System.out::println);


            session.getTransaction().commit();
        }
    }

    public static void updateStudent() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student retrieveStudent = session.get(Student.class, 1);
            retrieveStudent.setFirstname("Evan");
            session.getTransaction().commit(); // automatic dirty checking

            getStudentById(retrieveStudent.getId());

        } catch(Exception e) {e.printStackTrace();}
    }

    public static void updateQueryStudent() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query updateQuery = session.createQuery("update Student s set s.email = :email where s.id = :id");
            updateQuery.setParameter("email", "ecdiao@gmail.com");
            updateQuery.setParameter("id", 2);
            updateQuery.executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void deleteStudent() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student retrieveStudent = session.get(Student.class, 4);
            session.delete(retrieveStudent);
            session.getTransaction().commit();
        }
    }

}
