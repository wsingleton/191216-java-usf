package com.revature.models;

import java.util.Date;

public class Employee {

    private int id;
    private String name;
    private String role;
    private Date insertTime;

    public Employee() {

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

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}

