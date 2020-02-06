package com.revature.models;

import java.util.Date;
import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String role;
    private Date enterTime;

    public Employee() {super();
    }

    public Employee(int id, String name, String role, Date enterTime) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.enterTime = enterTime;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(role, employee.role) &&
                Objects.equals(enterTime, employee.enterTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, enterTime);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", enterTime=" + enterTime +
                '}';
    }
}
