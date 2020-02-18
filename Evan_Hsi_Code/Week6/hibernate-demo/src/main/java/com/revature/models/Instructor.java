package com.revature.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="INSTRUCTORS")
@SequenceGenerator(name="instructor_seq_gen", sequenceName = "instructor_seq", allocationSize=1)
public class Instructor {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "instructor_seq_gen")
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetails instructorDetails;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList;

    public Instructor() {
    }



    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }


    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor(String firstName, String lastName, String email, InstructorDetails instructorDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetails = instructorDetails;
    }

    public Instructor(int id, String firstName, String lastName, String email, InstructorDetails instructorDetails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetails = instructorDetails;
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

    public InstructorDetails getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(InstructorDetails instructorDetails) {
        this.instructorDetails = instructorDetails;
        instructorDetails.setInstructor(this);
    }

    public void addCourse(Course course) {
        if(courseList == null) courseList = new ArrayList<>();
        course.setInstructor(this);
        courseList.add(course);
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
                Objects.equals(instructorDetails, that.instructorDetails) &&
                Objects.equals(courseList, that.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, instructorDetails, courseList);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetails=" + instructorDetails +
                ", courseList=" + courseList +
                '}';
    }
}
