package com.revature;

import com.revature.models.Student;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class StudentDriver {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
try{
    addStudent();
    addStudents();
    loadStudentById();
    queryForStudent();

}catch(Exception e){e.printStackTrace();

    }}
    public static void addStudent(){
        try(Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Student student_1 = new Student("Ervin", "Student", "es@gmail.com");
            session.save(student_1);
            session.getTransaction().commit();
        }}

        public static void addStudents(){
        try(Session session = factory.getCurrentSession()){
            Student[] students = {
              new Student("Blake","Dunn", "bd@gmail.com"),
                    new Student("Bob","McCullen", "bm@gmail.com"),
                    new Student("Gregory","MacMann", "gm@gmail.com"),
            };
            for (Student s : students)session.save(s);
            session.getTransaction().commit();
            for(Student s: students) System.out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        }

        public static void loadStudentById(){
        try(Session session =factory.getCurrentSession()){
            session.beginTransaction();
            Student retrievedStudent = session.load(Student.class, 3);
            System.out.println(retrievedStudent);
        }catch(Exception e){
            e.printStackTrace();
        }
        }

        public static void queryForStudent(){
            try(Session session =factory.getCurrentSession()){
                session.beginTransaction();
                Query query1 = session.createQuery("from Student s order by s.id desc", Student.class);
                List<Student> students = query1.getResultList();
                students.forEach(s -> System.out.println(s));

                Query query2 = session.createQuery("from Student s where s.lastName = 'Dunn'", Student.class);
                students = query2.getResultList();
                students.forEach(s -> System.out.println(s));

                Query query3 = session.createQuery("from Student s where s.firstName = :fn or s.lastName = :ln", Student.class);
                query3.setParameter("fn","Blake");
                query3.setParameter("ln","McCullen");
                students = query3.getResultList();
                students.forEach(s -> System.out.println(s));

                Query query4 = session.createQuery("from student s where s.email like :email", Student.class);
                query4.setParameter("email", "%@gmail.com");
            }catch(Exception e){
                e.printStackTrace();
            }


        }

        public static void namedQueryForStudents(){

            try(Session session =factory.getCurrentSession()){
                session.beginTransaction();


            }catch(Exception e){
                e.printStackTrace();
            }

        }
}
