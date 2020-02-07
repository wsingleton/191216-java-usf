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

        //addStudent();
        //addStudents();
        //getStudentById();
        //loadStudentById();
        //queryForStudent();
        //namedQueryForStudents();
        //namedNativeQueryForStudents();
        //criteriaQueryForStudents();
        //updateStudent();
        //updateQueryStudent();
        //deleteStudent();
        getAllStudents();
    }

    public static void addStudent(){

        try(Session session = factory.getCurrentSession()){

            //Create Student Demo

            //Start a transaction (Transient state)
            session.beginTransaction();

            //Create student object
            Student student_1 = new Student("Scarlet", "Sky", "sky@gmail.com");

            //save (Persistence state)
            session.save(student_1);

            //commit  (Detached ttate)
            session.getTransaction().commit();

            //review the results opf the operation
            System.out.println(student_1);
        }


    }

    public static void addStudents() {

        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();

            Student[] students = {
                    new Student("Blake", "Kruppa", "bk@gmail.com"),
                    new Student("James", "Bond", "jb@gmail.com"),
                    new Student("Kenny", "Loggins", "kl@gmail.com")
            };

            for(Student s : students) session.save(s); //problem with save
            session.getTransaction().commit();

            for(Student s : students) System.out.println(s);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getStudentById(int id) {
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Student retrievedStudent = session.get(Student.class, id);
            System.out.println(retrievedStudent);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void loadStudentById() {
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Student retrievedStudent = session.load(Student.class, 4);
            System.out.println(retrievedStudent);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void queryForStudent() {
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();

            Query query1 = session.createQuery("from Student s order by s.id desc", Student.class);
            List<Student> students = query1.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query2 = session.createQuery("from Student s where s.lastName = 'bond", Student.class);
            students = query2.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query3 = session.createQuery("from Student s where s.firstName = :fn or s.lastname = :ln", Student.class);
            query3.setParameter("fn", "James");
            query3.setParameter("ln", "Loggins");
            students = query3.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query4 = session.createQuery("from Student s where s.email like :email", Student.class);
            query4.setParameter("emial", "%@gmail.com");
            students = query4.getResultList();
            students.forEach(s -> System.out.println(s));


        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void namedQueryForStudents() {

        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            Query query1 = session.getNamedQuery("getStudentByName_HQL");
            query1.setParameter("fn", "Kenny")
                   .setParameter("ln", "Loggins");

            List<Student> students = query1.getResultList();
            students.forEach(s -> System.out.println(s));
        }
    }

    public static void namedNativeQueryForStudents() {

        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            List<Student> students = session.getNamedNativeQuery("getStudentByName_HQL").setParameter("id", 1).getResultList();
            students.forEach(System.out::println);
        }
    }

    public static void criteriaQueryForStudents(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            // Create a CriteriaBuilder obj to build our CriteriaQuery/Update/Delete
            CriteriaBuilder querBuilder = session.getCriteriaBuilder();

            //Query for all students
            //SQL: select * from students
            //HQL: from students

            //Create our CriteriaQuery object
            CriteriaQuery<Student> critQuery = querBuilder.createQuery(Student.class);

            //Set the query "root" (the table we will be querying)
            Root<Student> queryRoot = critQuery.from(Student.class);
            critQuery.select(queryRoot);

            critQuery.where(
                    querBuilder.equal(queryRoot.get("email"), "kl@gmail.com")
            );
            //
            List<Student> students = session.createQuery(critQuery).getResultList();
            students.forEach(s -> System.out.println(s));
        }
    }

    public static void updateStudent() {
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, 1);
            retrievedStudent.setFirstName("Bloom");
            session.getTransaction().commit();

            getStudentById(retrievedStudent.getId());

        }
    }

    public static void updateQueryStudent(){
        try(Session session = factory.getCurrentSession()){
             session.beginTransaction();

             Query updateQuery = session. createQuery("update Student s set s.email = :email where s.id = :id");
             updateQuery.setParameter("email", "bloom@gmail.com");
             updateQuery.setParameter("id", 1);
             updateQuery.executeUpdate();
             session.getTransaction().commit();

             getStudentById(1);
        }
    }

    public static void deleteStudent(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, 4);
            session.delete(retrievedStudent);
            session.getTransaction().commit();
        }
    }

    public static void getAllStudents(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Query query = session.createQuery("from Student");
            List<Student> students = query.getResultList();
            students.forEach(System.out::println);
        }
    }
}
