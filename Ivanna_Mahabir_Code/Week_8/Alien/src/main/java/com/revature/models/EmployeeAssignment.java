package com.revature.models;


import java.util.Objects;

public class EmployeeAssignment {

    private int eaId;

    private Role role;

    private Employee employee;

    public EmployeeAssignment() {
        super();
    }

    public EmployeeAssignment(int eaId, Role role, Employee employee) {
        this.eaId = eaId;
        this.role = role;
        this.employee = employee;
    }

    public int getEaId() {
        return eaId;
    }

    public void setEaId(int eaId) {
        this.eaId = eaId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAssignment that = (EmployeeAssignment) o;
        return eaId == that.eaId &&
                role == that.role &&
                Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eaId, role, employee);
    }

    @Override
    public String toString() {
        return "EmployeeAssignment{" +
                "eaId=" + eaId +
                ", role=" + role +
                ", employee=" + employee +
                '}';
    }
}

