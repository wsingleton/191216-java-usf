package com.revature.models;

import java.sql.Date;
import java.util.Objects;

public class Reimburstment {
    private Integer id;
    private Double amount;
    private Date submitted;
    private Date resolved;
    private String description;

    private Integer author;
    private Integer resolver;
    private Integer status;
    private Integer type;

    public Reimburstment() {
        id = 0;
        amount = 0.0;
        submitted = new Date(0);
        resolved = new Date(0);
        description = "";
        author = 0;
        resolver = 0;
        status = 0;
        type = 0;
    }

    public Reimburstment(Double amount, Date submitted, String description, Integer author, Integer status, Integer type) {
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.author = author;
        this.status = status;
        this.type = type;
    }

    public Reimburstment(Integer id, Double amount, Date submitted, Date resolved, String description, Integer author, Integer resolver, Integer status, Integer type) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getResolver() {
        return resolver;
    }

    public void setResolver(Integer resolver) {
        this.resolver = resolver;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimburstment that = (Reimburstment) o;
        return submitted == that.submitted &&
                resolved == that.resolved &&
                Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(description, that.description) &&
                Objects.equals(author, that.author) &&
                Objects.equals(resolver, that.resolver) &&
                Objects.equals(status, that.status) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, submitted, resolved, description, author, resolver, status, type);
    }

    @Override
    public String toString() {
        return "Reimburstment{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", resolver=" + resolver +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}