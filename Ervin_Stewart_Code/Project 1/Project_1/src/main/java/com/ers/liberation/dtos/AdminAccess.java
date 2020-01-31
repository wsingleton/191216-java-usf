package com.ers.liberation.dtos;

import java.util.Objects;

public class AdminAccess {
    private Integer accessCode;
    public AdminAccess(){super();}

    public AdminAccess(Integer accessCode) {
        this.accessCode = accessCode;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminAccess that = (AdminAccess) o;
        return Objects.equals(accessCode, that.accessCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessCode);
    }

    @Override
    public String toString() {
        return "AdminAccess{" +
                "accessCode=" + accessCode +
                '}';
    }
}
