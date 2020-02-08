package com.revature.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "detail_gen", sequenceName = "detail_seq",allocationSize = 1)
public class InstructorDetail {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_gen")
    private int id;

    @Column(nullable = false)
    private String focus;

    @Column(nullable = false)
    private String hobby;

    @OneToOne(mappedBy = "detail")
    private Instructor instructor;

    public InstructorDetail() {super();
    }

    public InstructorDetail(String focus, String hobby, Instructor instructor) {
        this.focus = focus;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    public InstructorDetail(int id, String focus, String hobby, Instructor instructor) {
        this.id = id;
        this.focus = focus;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    public InstructorDetail(String focus, String hobby) {
        this.focus = focus;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
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
        if (o == null || getClass() != o.getClass()) return false;
        InstructorDetail that = (InstructorDetail) o;
        return id == that.id &&
                Objects.equals(focus, that.focus) &&
                Objects.equals(hobby, that.hobby) &&
                Objects.equals(instructor, that.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, focus, hobby, instructor);
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", focus='" + focus + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
