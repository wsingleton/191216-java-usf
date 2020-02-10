package com.revature.project1.models;

import java.io.InputStream;
import java.util.Objects;

public class Reimbursement {

    private Integer id;
    private Double amount;
    private String expenseDate;
    private String resolved;
    private String description;
    private InputStream receipt;
    private int authorId;
    private int resolverId;
    private Status status;
    private Type type;
    private String dateSubmitted;

    public Reimbursement() {
        super();
    }

    public Reimbursement(Double amount, String description, int authorId, Type type) {
        this.amount = amount;
        this.description = description;
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

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
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

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return authorId == that.authorId &&
                resolverId == that.resolverId &&
                Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(expenseDate, that.expenseDate) &&
                Objects.equals(resolved, that.resolved) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                status == that.status &&
                type == that.type &&
                Objects.equals(dateSubmitted, that.dateSubmitted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, expenseDate, resolved, description, receipt, authorId, resolverId, status, type, dateSubmitted);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", expenseDate='" + expenseDate + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", authorId=" + authorId +
                ", resolverId=" + resolverId +
                ", status=" + status +
                ", type=" + type +
                ", dateSubmitted='" + dateSubmitted + '\'' +
                '}';
    }
}


