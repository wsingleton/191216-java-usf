package com.revature;

import com.revature.models.Student;
import com.revature.utils.HibernateUtil;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class StudentDriver {

    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main (String... args){



        try(Session session = factory.getCurrentSession()){

//            Configuration config = new Configuration();

            // CREATING STUDENT DEMO

//            //start a transaction
//            session.beginTransaction();
//
//            Student student_1 = new Student("Bosco", "Nzeyi", "nzeyin@gmail.com");
//            session.save(student_1);
//            session.getTransaction().commit();
//
//            System.out.println(student_1);
           // addStudents();
           // getStudentById();
            //queryForStudents();
            //criteriaQueryForStudents();
            //criteriaQueryForStudentsCondtional();

            updateStudent();

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public static void addStudent(){}

    public static void getStudentById(int id){
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Student retrieveStudent = session.get(Student.class, id);
            System.out.println(retrieveStudent);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void addStudents(){
        try(Session session = factory.getCurrentSession()){

            Student[] students = {
                    new Student("Brandy", "Chris", "bobo@email.com"),
                    new Student ("Emily", "Study", "st@gmail.com")
            };
            session.beginTransaction();
            for (Student s: students){

                session.save(s);
                System.out.println(s);
            }
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void queryForStudents (){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            Query query1 = session.createQuery("from Student s order by s.id desc", Student.class);

            List<Student> students = query1.getResultList();

            students.forEach(System.out::println);


            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void criteriaQueryForStudents (){
        try(Session session = factory.getCurrentSession()){
           session.beginTransaction();

            CriteriaBuilder queryBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Student> critQuery = queryBuilder.createQuery(Student.class);

            Root<Student> queryRoot = critQuery.from(Student.class);

            critQuery.select(queryRoot);


            List<Student> students = session.createQuery(critQuery).getResultList();

            students.forEach(System.out::println);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void criteriaQueryForStudentsCondtional (){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            CriteriaBuilder queryBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Student> critQuery = queryBuilder.createQuery(Student.class);

            Root<Student> queryRoot = critQuery.from(Student.class);

            critQuery.select(queryRoot);

            critQuery.where(
                    queryBuilder.equal(queryRoot.get("email"), "bobo@email.com")
            );


            List<Student> students = session.createQuery(critQuery).getResultList();

            students.forEach(System.out::println);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateStudent(){
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, 1);
            System.out.println(retrievedStudent);
            retrievedStudent.setFirstName("Pascal");

            session.getTransaction().commit();

            getStudentById(retrievedStudent.getId());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateQueryStudent(){

        try(Session session = factory.getCurrentSession()){

        }catch( Exception e){
            e.printStackTrace();
        }

    }

}
