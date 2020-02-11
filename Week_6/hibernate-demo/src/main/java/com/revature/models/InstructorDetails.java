package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name="details_gen", sequenceName="details_seq", allocationSize=1)
public class InstructorDetails {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;

    @Column(nullable=false)
    private String focus;

    @Column(nullable=false)
    private String hobby;

    @OneToOne(mappedBy="details")
    private Instructor instructor;

    public InstructorDetails() {
        super();
    }

    public InstructorDetails(String focus, String hobby) {
        this.focus = focus;
        this.hobby = hobby;
    }

    public InstructorDetails(String focus, String hobby, Instructor instructor) {
        this.focus = focus;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    public InstructorDetails(int id, String focus, String hobby, Instructor instructor) {
        this.id = id;
        this.focus = focus;
        this.hobby = hobby;
        this.instructor = instructor;
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
        InstructorDetails that = (InstructorDetails) o;
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
        return "InstructorDetails{" +
                "id=" + id +
                ", focus='" + focus + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
