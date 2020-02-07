package com.revature;

import com.revature.models.Student;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public class StudentDriver {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    public static void main(String[] args){


//        addStudents();
//        getStudentById();
//        loadStudentById();
//        queryForStudent();
        nameQueryForStudent();



    }

    public static void addStudent(){
        try(Session session = factory.getCurrentSession()){

            // Create Student demo

            //start transaction
            session.beginTransaction();

            // create studne object

            Student student1 = new Student("hoang","le","hoangle.com");

            //save
            session.save(student1);

            //commit
            session.getTransaction().commit();

            //review result
            System.out.println(student1);

        }catch (Exception e){
            e.printStackTrace();

        }


    }

    public static void addStudents(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

         Student[] students = {
                 new Student("hoang1", "le1", "hoangle.com1"),
            new Student("hoang12", "le12", "hoangle.com12"),
            new Student("hoang13", "le13", "hoangle.com13")

            };

         for (Student s : students) session.save(s);
         session.getTransaction().commit();

         for (Student s: students) System.out.println(s);

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public static void getStudentById(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class,3);

            System.out.println(retrievedStudent);


        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void loadStudentById(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();

            Student retrievedStudent = session.load(Student.class,3);

            System.out.println(retrievedStudent);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void queryForStudent(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Query query1 = session.createQuery("from Student s order by s.id", Student.class);
            List<Student> students = query1.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query2 = session.createQuery("from Student s where s.lastName = 'le1'", Student.class);
            students = query2.getResultList();
            students.forEach(s -> System.out.println(s));

            Query query3 = session.createQuery("from Student s where s.firstName = :fn or s.lastName = :ln ", Student.class);
            query3.setParameter("fn","hoang");
            query3.setParameter("ln","le");
            students = query3.getResultList();
            students.forEach(s-> System.out.println(s));



        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void nameQueryForStudent(){
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Query query1 = session.getNamedQuery("findStudentByName_HQL");

            query1.setParameter("fn", "hoang12")
                    .setParameter("ln","le12");

            List<Student> students = query1.getResultList();
            students.forEach(s -> System.out.println(s));


        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void idNativeQueryForStudent(){
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Query query1 = session.getNamedQuery("getStudentById_SQL");

            query1.setParameter("fn", "hoang12")
                    .setParameter("ln","le12");

            List<Student> students = session.getNamedQuery("getStudentById_SQL").setParameter("id",1).getResultList();
            students.forEach(System.out::println);


        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void criteriaQueryForStudent(){
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();
           // create a criteria obj to build criteria query/update/delete
            // query for all student


        }catch (Exception e){
            e.printStackTrace();

        }
    }


}
