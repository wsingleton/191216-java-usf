package com.revature.mockERS.dto;

import java.sql.Timestamp;
import java.util.Objects;

public class ReimbursementOut {
    private Integer id;
    private String description, type, status;
    Timestamp received, completed;

    public ReimbursementOut(){}

    public ReimbursementOut(Integer id, String description, String type, String status, Timestamp received, Timestamp completed) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.status = status;
        this.received = received;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getReceived() {
        return received;
    }

    public void setReceived(Timestamp received) {
        this.received = received;
    }

    public Timestamp getCompleted() {
        return completed;
    }

    public void setCompleted(Timestamp completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementOut that = (ReimbursementOut) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(type, that.type) &&
                Objects.equals(status, that.status) &&
                Objects.equals(received, that.received) &&
                Objects.equals(completed, that.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, type, status, received, completed);
    }

    @Override
    public String toString() {
        return "ReimbursementOut{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", received=" + received +
                ", completed=" + completed +
                '}';
    }
}
