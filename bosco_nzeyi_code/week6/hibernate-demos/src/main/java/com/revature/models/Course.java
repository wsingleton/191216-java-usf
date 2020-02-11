package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="COURSES")
@SequenceGenerator(name="course_gen", sequenceName = "course_seq", allocationSize = 1)
public class Course {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    private int id;

    @Column
    private String name;

    @JoinColumn
    @ManyToOne(cascade = {
            CascadeType.ALL, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST
    })
    private Instructor instructor;

    public Course() {
        super();
    }

    public Course(String name, Instructor instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getId() == course.getId() &&
                Objects.equals(getName(), course.getName()) &&
                Objects.equals(getInstructor(), course.getInstructor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getInstructor());
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
