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

//       addStudents();
//        getStudentById();
//        loadStudentById();
        try{
//            queryForStudent();
//            criteriaQueryForStudents();
//            updateStudent();
            deleteStudent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void addStudent() {
//        try(Session session = factory.getCurrentSession()){
//
//            //Create student demo
//
//            //start transaction
//            session.beginTransaction();
//
//            //create a student object
//            Student student = new Student("Jim", "Smith", "jsmith@gmail.com");
//
//            //save the student as a record
//
//            session.save(student);
//
//            //commit the transaction
//            session.getTransaction().commit();
//
//            System.out.println(student);
//        }
//    }
//    public static void addStudents() {
//        try(Session session = factory.getCurrentSession()){
//            session.beginTransaction();
//
//            Student[] students = {
//                    new Student("Jeff", "Demps", "jdembs@gmail.com"),
//                    new Student("Sally", "Washington", "swash@gmail.com"),
//                    new Student("Jim", "Falley", "jfally@gmail.com")
//            };
//
//            for (Student s: students
//                 ) {
//                session.save(s);
//            }
//
//            session.getTransaction().commit();
//            for (Student s: students
//                 ) {
//                System.out.println(s);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void getStudentById() {
//        try(Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//
//            //.get returns the actual persisted object associated with the database(eagerly fetched) only work with id(returns null if no match)
//            //.load lazily fetches, if something doesn't exist with that id it will throw exception
//            Student retrievedStudent = session.get(Student.class, 3);//returns null if not found
//            System.out.println(retrievedStudent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }public static void loadStudentById() {
//        try(Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//
//            //.get returns the actual persisted object associated with the database(eagerly fetched) only work with id(returns null if no match)
//            //.load lazily fetches, if something doesn't exist with that id it will throw exception. returns a proxy which is then converted into a persistent object when a method is invoked on it
//            Student retrievedStudent = session.load(Student.class, 3);//thors ObjectNotFoundExceptionif not found
//            System.out.println(retrievedStudent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void queryForStudent() {
//        try(Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            Query query = session.createQuery("from Student s order by s.id desc", Student.class);
//            List<Student> students = query.getResultList();
//            students.forEach(s -> System.out.println(s));
//
//            Query query1 = session.createQuery("from Student s where s.lastName ='Demps'", Student.class);
//            students = query1.getResultList();
//            students.forEach(s -> System.out.println(s));
//        }
//    }
//
//    public static void namedQueryForStudents(){
//
//        try(Session session = factory.getCurrentSession()){
//            session.beginTransaction();
//
//            Query query1 = session.getNamedQuery("getStudentByName_HQL");
//            query1.setParameter("fn", "Jeff")
//                    .setParameter("ln", "Demps");
//            List<Student> students = query1.getResultList();
//            students.forEach(s -> System.out.println(s));
//        }
//    }
//programmatic query building
//    public static void criteriaQueryForStudents() {
//        try(Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
//
//            //create criteria builder object to build our criteria query/ update/delete
//
//            //create our criteriaquery object
//            CriteriaQuery<Student> criteriaQuery = queryBuilder.createQuery(Student.class);
//
//            Root<Student> queryRoot = criteriaQuery.from(Student.class);
//            criteriaQuery.select(queryRoot);
//
//            List<Student> students = session.createQuery(criteriaQuery).getResultList();
//            students.forEach(s -> System.out.println(s));
//
//        }
//    }

    public static void updateStudent() {

        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, 1);
            System.out.println(retrievedStudent);
            retrievedStudent.setFirstName("Harry");
            session.getTransaction().commit();
        }

    }

    public static void deleteStudent(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            Student retrieviedStudent = session.get(Student.class, 2);
            session.delete(retrieviedStudent);
            session.getTransaction().commit();
        }
    }
}
