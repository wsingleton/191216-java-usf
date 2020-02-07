package com.revature.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="INSTRUCTORS")
@SequenceGenerator(name="instructor_gen", sequenceName="instructor_seq", allocationSize=1)
public class Instructor {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructor_gen")
    private int id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false, unique=true)
    private String email;

    @JoinColumn
    @OneToOne(cascade=CascadeType.ALL)
    private InstructorDetails details;

    @OneToMany(mappedBy="instructor")
    private List<Course> courses;

    public Instructor() {
        super();
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor(String firstName, String lastName, String email, InstructorDetails details) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.details = details;
    }

    public Instructor(int id, String firstName, String lastName, String email, InstructorDetails details) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.details = details;
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

    public InstructorDetails getDetails() {
        return details;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        if (courses == null) courses = new ArrayList<>();
        course.setInstructor(this);
        courses.add(course);
    }

    public void setDetails(InstructorDetails details) {
        this.details = details;
        details.setInstructor(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(details, that.details) &&
                Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, details, courses);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", details=" + details +
                '}';
    }

}
