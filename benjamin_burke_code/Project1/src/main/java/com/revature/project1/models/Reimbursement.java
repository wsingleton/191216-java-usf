package com.revature.project1.models;

import java.io.InputStream;
import java.util.Objects;

public class Reimbursement {

    private Integer id;
    private Double amount;
    private String date;
    private String submitted;
    private String resolved;
    private String description;
    private InputStream receipt;
    private int authorId;
    private int resolverId;
    private Status status;
    private Type type;

    public Reimbursement() {
        super();
    }

    public Reimbursement(Integer id, Double amount, String date, String submitted, String description, InputStream receipt, int authorId, Status status, Type type) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.submitted = submitted;
        this.description = description;
        this.receipt = receipt;
        this.authorId = authorId;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(Double amount, String date, String submitted, int authorId, Type type) {
        this.amount = amount;
        this.date = date;
        this.submitted = submitted;
        this.authorId = authorId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InputStream getReceipt() {
        return receipt;
    }

    public void setReceipt(InputStream receipt) {
        this.receipt = receipt;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getResolverId() {
        return resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return authorId == that.authorId &&
                resolverId == that.resolverId &&
                status == that.status &&
                Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(date, that.date) &&
                Objects.equals(submitted, that.submitted) &&
                Objects.equals(resolved, that.resolved) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date, submitted, resolved, description, receipt, authorId, resolverId, status, type);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", authorId=" + authorId +
                ", resolverId=" + resolverId +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}


