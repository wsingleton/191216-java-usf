package com.revature.quizzard.web.dtos;

import com.revature.quizzard.entities.UserRole;

import java.util.Objects;

public class Principle {
    private int id;
    private String username;
    private UserRole Role;

    public Principle(){super();}

    public Principle(int id, String username, UserRole role) {
        this.id = id;
        this.username = username;
        Role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return Role;
    }

    public void setRole(UserRole role) {
        Role = role;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Principle principle = (Principle) o;
        return id == principle.id &&
                Objects.equals(username, principle.username) &&
                Objects.equals(Role, principle.Role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, Role);
    }

    @Override
    public String toString() {
        return "Principle{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Role=" + Role +
                '}';
    }
}
