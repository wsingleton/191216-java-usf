package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({@NamedQuery(name="getStudentById_HQL", query = "from Student s where s.id = :id"),
        @NamedQuery(name="getStudentByName_HQL", query = "from Student s where s.firstName like :fn and s.lastName like :ln")

})

@NamedNativeQueries({
        @NamedNativeQuery(name="getStudentById_SQL", query = "select * from students where id = :id", resultClass = Student.class)
})

@Entity
@Table(name="STUDENTS")
@SequenceGenerator(name="student_seq_gen",sequenceName = "student_seq", allocationSize = 1)
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    public Student(){
        super();
    }
    public Student( String firstName, String lastName, String email) {
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
