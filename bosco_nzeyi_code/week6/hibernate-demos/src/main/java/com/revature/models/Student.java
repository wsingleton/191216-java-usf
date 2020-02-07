package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "findStudentById_HQL", query = "from Student s where s.id = :id"),
        @NamedQuery(name = "getStudentByName_HQL", query = "from Student s where s.firstName = :fn and s.lastName = :ln")
})

@NamedNativeQueries({
        @NamedNativeQuery(name ="getStudentById_SQL", query = "select * from students s where id = :id", resultClass = Student.class)
})

@Entity // let's Hibernate know that this class is an entity that will be mapped
@Table(name = "STUDENTS") // maps this class to the specified table name
@SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
public class Student {

    @Id // designate that this is the table id and its primary key of the mapped table
    @Column(name ="id") // The column name is not really needed, but we add for convenience.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public Student() {
        super();
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
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() &&
                Objects.equals(getFirstName(), student.getFirstName()) &&
                Objects.equals(getLastName(), student.getLastName()) &&
                Objects.equals(getEmail(), student.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
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
