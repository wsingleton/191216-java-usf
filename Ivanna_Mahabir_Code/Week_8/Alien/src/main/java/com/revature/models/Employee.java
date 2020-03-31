package com.revature.models;


import java.util.Objects;

public class Employee {

    private int empId;

    private String first;

    private String last;

    public Employee() {
        super();
    }

    public Employee(int empId, String first, String last) {
        this.empId = empId;
        this.first = first;
        this.last = last;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId &&
                Objects.equals(first, employee.first) &&
                Objects.equals(last, employee.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, first, last);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
