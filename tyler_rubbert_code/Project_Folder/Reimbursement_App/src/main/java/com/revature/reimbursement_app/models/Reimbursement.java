package com.revature.reimbursement_app.models;

import java.util.Objects;

public class Reimbursement {

    private Integer id;
    private Double amount;
    private String timeSubmitted;
    private String timeResolved;
    private String description;
    private String receipt;
    private Integer authorId;
    private Integer resolverId;
    private ReimbursementStatus status;
    private ReimbursementType type;

    public Reimbursement() {
        super();
    }

    public Reimbursement(Double amount, String description, int authorId, ReimbursementType type) {
        this.amount = amount;
        this.description = description;
        this.authorId = authorId;
        this.type = type;
        status = ReimbursementStatus.PENDING;
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

    public String getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(String timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public String getTimeResolved() {
        return timeResolved;
    }

    public void setTimeResolved(String timeResolved) {
        this.timeResolved = timeResolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getResolverId() {
        return resolverId;
    }

    public void setResolverId(Integer resolverId) {
        this.resolverId = resolverId;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(timeSubmitted, that.timeSubmitted) &&
                Objects.equals(timeResolved, that.timeResolved) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(resolverId, that.resolverId) &&
                status == that.status &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, timeSubmitted, timeResolved, description, receipt, authorId, resolverId, status, type);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", timeSubmitted='" + timeSubmitted + '\'' +
                ", timeResolved='" + timeResolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", authorId=" + authorId +
                ", resolverId=" + resolverId +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
