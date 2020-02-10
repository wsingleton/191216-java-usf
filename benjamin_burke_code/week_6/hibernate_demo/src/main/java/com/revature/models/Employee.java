package com.revature.models;

import java.util.Date;
import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String role;
    private Date inserttime;

    public Employee() {
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employees = (Employee) o;
        return id == employees.id &&
                Objects.equals(name, employees.name) &&
                Objects.equals(role, employees.role) &&
                Objects.equals(inserttime, employees.inserttime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, inserttime);
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", inserttime=" + inserttime +
                '}';
    }
}
