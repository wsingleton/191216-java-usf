package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name="findStudentById_HQL", query="from Student s where s.id=:id"),
        @NamedQuery(name="findStudentByName_HQL", query="from Student s where s.givenName = :fn AND s.familyName = :ln")
})
@NamedNativeQueries({
        @NamedNativeQuery(name="getStudentByID_SQL", query="select * from students where id=:id", resultClass=Student.class)
})

@Entity
@Table(name="STUDENTS")
@SequenceGenerator(name="student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
public class Student {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "student_seq_gen")
    private int id;
    @Column(name="FirstName", nullable=false)
    private String givenName;
    @Column(name="LastName", nullable=false)
    private String familyName;
    @Column(name="email", nullable=false, unique = true)
    private String email;

    public Student() {
        super();
    }

    public Student(String givenName, String familyName, String email) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
    }

    public Student(int id, String givenName, String familyName, String email) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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
                Objects.equals(givenName, student.givenName) &&
                Objects.equals(familyName, student.familyName) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, givenName, familyName, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
