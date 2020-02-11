package com.revature.util;

import com.google.common.escape.Escaper;
import com.revature.models.Student;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.nio.channels.spi.SelectorProvider;
import java.util.List;

public class StudentDriver {

   private static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        try {

            addStudent();
            addStudents();
            //getStudentById();
            loadStudentById();
            queryForStudent();
            namedQueryForStudents();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void addStudent() {

            try (Session session = factory.getCurrentSession()) {

                session.beginTransaction();

                Student student_1 = new Student("niles", "diggs", "ndiggs@wes.edu");

                // Save the student as a record in the DB
                session.save(student_1);

                //Commit the transaction
                session.getTransaction().commit();

                //review the results
                System.out.println(student_1);

            }
        }

        public static void addStudents() {

            try (Session session = factory.getCurrentSession()) {

                session.beginTransaction();

                Student[] students = {
                        new Student("Blake", "Kruppa", "bk@gmail.com"),
                        new Student("Genesis", "Bonds", "gb@gmail.com"),
                        new Student("Emily", "Higgins", "eh@gmail.com"),
                };

                for (Student s : students) session.save(s);
                session.getTransaction().commit();
            }

        }

        public static void getStudentById(int id) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

                //.get() returns the actual persistent object associated with the DB records (eagerly-fetched)
                Student retrievedStudent = session.get(Student.class, id); // .get() will return null if not found

            }
        }

        public static void loadStudentById() {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

                // .load() returns a proxy, which is converted into a persistent obj when a method is invoked on it(lazily-fetched)
                Student retrievedStudent = session.load(Student.class, 4); //throws ObjectNotFoundException if not found
            }
        }

        public static void queryForStudent() {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

                Query query1 = session.createQuery("from Student s order by s.id desc", Student.class);
                List<Student> students = query1.getResultList();

                Query query2 = session.createQuery("from Student s where s.lastName = 'Singleton'",Student.class);
                students = query2.getResultList();

                Query query3 = session.createQuery("from Student s where s.firstName =:fn or lastName =: ln", Student.class);
                query3.setParameter("fn", "Blake");
                query3.setParameter("ln", "Singleton");
                students = query3.getResultList();

                Query query4 = session.createQuery("from Student s where s.email like :email", Student.class);
                query4.setParameter("email", "@gmail.com");
                students = query4.getResultList();
            }
        }

        public  static  void namedQueryForStudents() { // these use HQL statements
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

                Query query1 = session.getNamedQuery("getStudentByName_HQL");
                query1.setParameter("fn", "Genesis").setParameter("ln", "Bonds");

                List<Student> students = query1.getResultList();
            }
        }

        public static void namedNativeQueryForStudents() {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                List<Student> students = session.getNamedNativeQuery("getStudentById_SQL").setParameter("id", 1).getResultList();
            }
        }

        public static void criteriaQueryForStudents() {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

                //Create a CriteriaBuilder object to build our CriteriaQuery/Update/Delete
                CriteriaBuilder queryBuilder = session.getCriteriaBuilder();

                //Query students with a  particular email
                //SQL select * from students where email =:email
                //HQL from Student s where s.email =:email

                //Create our CriteriaQuery object
                CriteriaQuery<Student> criteriaQuery = queryBuilder.createQuery(Student.class);

                //Set the query "root" (the table we will be querying)
                Root<Student> queryRoot = criteriaQuery.from(Student.class);

                //Indicate the SELECT clause of our query
                criteriaQuery.select(queryRoot);

                //additional restrictions (WHERE clause)
                criteriaQuery.where(
                        queryBuilder.equal(queryRoot.get("email"), "ws@gmail.com")
                );

                //execute the query
                List<Student> students = session.createQuery(criteriaQuery).getResultList();
            }
        }

    }
