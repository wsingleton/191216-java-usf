package com.revature.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="COURSES")
@SequenceGenerator(name="course_seq_gen", sequenceName="course_seq", allocationSize = 1)
public class Course {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq_gen")
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @JoinColumn
    @ManyToOne(cascade={CascadeType.REMOVE, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private Instructor instructor;

    @JoinTable(
            name="course_students",
            joinColumns=@JoinColumn(name="COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name="STUDENT_ID")
    )
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> students;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, Instructor instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    public Course(int id, String name, Instructor instructor) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudents(Student... students) {
        if (this.students == null) this.students = new ArrayList<>();
        for(Student s : students) this.students.add(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                Objects.equals(name, course.name) &&
                Objects.equals(instructor, course.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, instructor);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
