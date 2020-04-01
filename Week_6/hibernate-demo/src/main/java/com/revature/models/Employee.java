package com.revature.models;

import java.util.Date;
import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private String role;
    private Date insertTime;

    public Employee() {
        super();
    }

    public Employee(int id, String name, String role, Date insertTime) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.insertTime = insertTime;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Employee setRole(String role) {
        this.role = role;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public Employee setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(role, employee.role) &&
                Objects.equals(insertTime, employee.insertTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, insertTime);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }

}
