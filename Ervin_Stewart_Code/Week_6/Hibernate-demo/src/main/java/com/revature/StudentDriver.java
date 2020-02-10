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
try{
//    addStudent();
//    addStudents();
//    getStudentById();
//    loadStudentById();
//    queryForStudent();
//    namedQueryForStudents();
//            namedNativeQueryForStudents();
//            criteriaQueryForStudents();
//            updateStudent();
//            updateQueryStudent();
//            deleteStudent();
    getAllStudents();

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

    public static void getStudentById(int id) {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            // .get() returns the actual persistent object associated with the DB records (eagerly-fetched)
            Student retrievedStudent = session.get(Student.class, id); // returns null if not found

            System.out.println(retrievedStudent);

        } catch (Exception e) {
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
                students = query4.getResultList();
                students.forEach(s -> System.out.println(s));
            }
            }




        public static void namedQueryForStudents(){

            try(Session session =factory.getCurrentSession()){
                session.beginTransaction();
                Query query1 = session.getNamedQuery("getStudentByName_HQL");
                query1.setParameter("fn", "Genesis")
                .setParameter("ln","Bonds");

                List<Student> students = query1.getResultList();
                students.forEach(s -> System.out.println(s));

            }

        }
    public static void namedNativeQueryForStudents() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            List<Student> students = session.getNamedNativeQuery("getStudentById_SQL").setParameter("id", 1).getResultList();
            students.forEach(System.out::println);

        }
    }

    public static void criteriaQueryForStudents() {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            // Create a CriteriaBuilder object to build our CriteriaQuery/Update/Delete
            CriteriaBuilder queryBuilder = session.getCriteriaBuilder();

            // Query students with a particular email
            // SQL: select * from students where email = :email
            // HQL: from Student s where s.email = :email

            // Create our CriteriaQuery object
            CriteriaQuery<Student> critQuery = queryBuilder.createQuery(Student.class);

            // Set the query "root" (the table we will be querying)
            Root<Student> queryRoot = critQuery.from(Student.class);

            // Indicate the SELECT clause of our query
            critQuery.select(queryRoot);

            // Add a restrictions (WHERE clause)
            critQuery.where(
                    queryBuilder.equal(queryRoot.get("email"), "ws@gmail.com")
            );

            // Execute the query
            List<Student> students = session.createQuery(critQuery).getResultList();
            students.forEach(System.out::println);

        }
    }

    public static void updateStudent() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Student retrievedStudent = session.load(Student.class, 1);
            System.out.println(retrievedStudent);
            retrievedStudent.setFirstName("Wezley");
            session.getTransaction().commit(); // automatic dirty checking

            getStudentById(retrievedStudent.getId());

        }
    }

    public static void updateQueryStudent() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Query updateQuery = session.createQuery("update Student s set s.email = :email where s.id = :id");
            updateQuery.setParameter("email", "wezley.singleton@revature.com");
            updateQuery.setParameter("id", 1);
            updateQuery.executeUpdate();
            session.getTransaction().commit();

            getStudentById(1);

        }
    }

    public static void deleteStudent() {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, 4);
            session.delete(retrievedStudent);
            session.getTransaction().commit();
        }
    }

    public static void getAllStudents() {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Query query= session.createQuery("from Student");
            List<Student> students = query.getResultList();
            students.forEach(System.out::println);
        }
    }
}

