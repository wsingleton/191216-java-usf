package com.revature.models;

import java.util.Arrays;
import java.util.Objects;

public class Reimburstment {
    private Integer id;
    private Double amount;
    private long submitted;
    private long resolved;
    private String description;
    private Byte[] receipt;
    private Integer author;
    private Integer resolver;
    private Integer status;
    private Integer type;

    public Reimburstment() { super(); }

    public Reimburstment(Double amount, long submitted, String description, Byte[] receipt, Integer author, Integer status, Integer type) {
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.status = status;
        this.type = type;
    }

    public Reimburstment(Integer id, Double amount, long submitted, long resolved, String description, Byte[] receipt, Integer author, Integer resolver, Integer status, Integer type) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
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

    public long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(long submitted) {
        this.submitted = submitted;
    }

    public long getResolved() {
        return resolved;
    }

    public void setResolved(long resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(Byte[] receipt) {
        this.receipt = receipt;
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
                Arrays.equals(receipt, that.receipt) &&
                Objects.equals(author, that.author) &&
                Objects.equals(resolver, that.resolver) &&
                Objects.equals(status, that.status) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, amount, submitted, resolved, description, author, resolver, status, type);
        result = 31 * result + Arrays.hashCode(receipt);
        return result;
    }

    @Override
    public String toString() {
        return "Reimburstment{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt=" + Arrays.toString(receipt) +
                ", author=" + author +
                ", resolver=" + resolver +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}

