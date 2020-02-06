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

    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        try {
//            addStudent()
//            addStudents();
//            getStudentsById();
//            loadStudentsById();
//            queryForStudent();
//            namedQueryForStudents();
//            namedNativeQueryForStudents();
//            criteriaQueryForStudents();
//            updateStudent();
//            updateQueryStudent();
//            deleteStudent();
//            getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addStudent() {


        try (Session session = factory.getCurrentSession()) {

            // CREATE STUDENT DEMO

            // Start a transaction
            session.beginTransaction();

            // Create a Stduent object
            Student student_1 = new Student("Tyler", "Rubbert", "coolguy@email.com");

            // Save the student as a record in the DB
            session.save(student_1);

            // Commit the transaction
            session.getTransaction().commit();

            // Review the results of the operation
            System.out.println(student_1);
        }

    }

    public static void addStudents() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student[] students = {
                    new Student("Blake", "Kruppa", "bk@gmail.com"),
                    new Student("Genesis", "Bonds", "gb@gmail.com"),
                    new Student("Emily", "Higgins", "eh@gmail.com")
            };

            for (Student s : students) session.save(s);
            session.getTransaction().commit();

            for (Student s : students) System.out.println(s);

        }

    }

    public static void getStudentsById(int id) {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            // .get returns the actual persistent object associated with the DB records (eagerly-fetched)
            Student retrievedStudent = session.get(Student.class, id);

            System.out.println(retrievedStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void loadStudentsById() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student retrievedStudent = session.load(Student.class, 22);

            System.out.println(retrievedStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void queryForStudent() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query query1 = session.createQuery("from Student s order by s.id desc", Student.class);
            List<Student> students = query1.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query2 = session.createQuery("from Student s where s.lastName = 'Rubbert'", Student.class);
            students = query2.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query3 = session.createQuery("from Student s where s.firstName = :fn or s.lastName = :ln",Student.class);
            query3.setParameter("fn", "Blake");
            query3.setParameter("ln", "Rubbert");
            students = query3.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query4 = session.createQuery("from Student s where s.email like :email", Student.class);
            query4.setParameter("email", "%@gmail.com");
            students = query4.getResultList();
            students.forEach(s -> System.out.println(s));

        }

    }

    public static void namedQueryForStudents() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query query1 = session.getNamedQuery("findStudentByName_HQL");
            query1.setParameter("fn", "Genesis")
                  .setParameter("ln", "Bonds");

            List<Student> students = query1.getResultList();
            students.forEach(s -> System.out.println(s));


        }

    }

    public static void namedNativeQueryForStudents() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            List<Student> students = session.getNamedQuery("getStudentById_SQL").setParameter("id",1).getResultList();
            students.forEach(System.out::println);

        }

    }

    public static void criteriaQueryForStudents() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            // Create a CriteriaBuilder object to build our CriteriaQuery/Update/Delete
            CriteriaBuilder queryBuilder = session.getCriteriaBuilder();

            // Query for students with a particular email
            // SQL: select * from students where email = ?
            // HQL: from Student

            // Create our CriteriaQuery object
            CriteriaQuery<Student> critQuery = queryBuilder.createQuery(Student.class);

            // Set the query "root" (the table we will be querying)
            Root<Student> queryRoot = critQuery.from(Student.class);

            // Indicate the SELECT clause of our query
            critQuery.select(queryRoot);

            // Add a restriction (WHERE clause)
            critQuery.where(
                    queryBuilder.equal(queryRoot.get("email"), "coolguy@email.com")
            );

            // Execute the query
            List<Student> students = session.createQuery(critQuery).getResultList();
            students.forEach(System.out::println);

        }

    }

    public static void updateStudent() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class,1);
            retrievedStudent.setFirstName("Tyler");
            session.getTransaction().commit(); // automatic dirty checking

            getStudentsById(retrievedStudent.getId());

        }

    }

    public static void updateQueryStudent() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query updateQuery = session.createQuery("update Student s set s.email = :email where s.id = :id");
            updateQuery.setParameter("email", "tyler.rubbert@email.com");
            updateQuery.setParameter("id", 1);
            updateQuery.executeUpdate();
            session.getTransaction().commit();

            getStudentsById(1);

        }

    }

    public static void deleteStudent() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, 23);
            session.delete(retrievedStudent);
            session.getTransaction().commit();

        }

    }

    public static void getAllStudents() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query query = session.createQuery("from Student");
            List<Student> students = query.getResultList();
            students.forEach(System.out::println);

        }

    }

}
