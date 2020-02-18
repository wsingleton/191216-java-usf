package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name="getStudentById_HQL", query="from Student s where s.id = :id"),
        @NamedQuery(name="getStudentByName_HQL", query="from Student s where s.firstName = :fn and s.lastName = :ln")
})

@NamedNativeQueries({
        @NamedNativeQuery(name="getStudentById_SQL", query="SELECT * FROM STUDENTS WHERE id = :id", resultClass=Student.class)
})

@Entity  // Lets hibernate know that this class is an entity that will be mapped
@Table(name="STUDENTS") // Maps this class to the specified table name
@SequenceGenerator(name="student_seq_gen", sequenceName="student_seq", allocationSize=1)
public class Student {

    @Id // Designates this field as a PK on the mapped table
    @Column(name="id") // Technically the name attribute is not needed; Hibernate will look to the field name
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="email", unique=true, nullable = false)
    private String email;

    public Student() {
    }

    public Student(String firstname, String lastname, String email) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
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
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
