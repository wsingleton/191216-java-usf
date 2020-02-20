package com.revature.models;

import javax.persistence.*;
import java.util.Objects;
//named queries are pre written queries, which utilize HQL syntax for the query
@NamedQueries({
        @NamedQuery(name = "getStudentById_HQL", query = "from Student s where s.id = :id"),
        @NamedQuery(name = "getStudentByName_HQL", query = "from Student s where s.firstName = :fn and s.lastName = :ln"),
})

//Named native querues are pre-written queries which utilize native SQL syntax for the query, have to specify what  you expect to give back
@NamedNativeQueries({
        @NamedNativeQuery(name = "getStudentById_SQL", query = "SELECT * FROM students where id = :id", resultClass = Student.class)
})


@Entity //let's hibernate know that is class is an entity that will be mapped
@Table(name = "STUDENTS") // maps this class to the specified table name(optional, if left out it will map it to a table with same name as the class)
@SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
public class Student {

    @Id //designates this field as a primary key on the mapped table, doesn't make it a column
    @Column(name = "ID") // technically this is optional, it will use the field name if not provided
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen") // will use the sequence that is mapped to this table for the value
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
