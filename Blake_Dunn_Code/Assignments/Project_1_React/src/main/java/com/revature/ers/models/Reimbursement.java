package com.revature.ers.models;

import java.io.InputStream;
import java.util.Objects;

public class Reimbursement {

    private Integer reimbId;
    private Double amount;
    private String submitted;
    private String resolved;
    private String description;
    private InputStream receipt;
    private Integer authorId;
    private Integer resolverId;
    private ReimbursementStatus status;
    private ReimbursementType type;

    public Reimbursement () {
        super();
    }

    public Reimbursement(Integer reimbId, ReimbursementStatus status) {
        this.reimbId = reimbId;
        this.status = status;
    }

    public Reimbursement(Integer reimbId, Integer authorId, ReimbursementStatus status) {
        this.reimbId = reimbId;
        this.authorId = authorId;
        this.status = status;
    }

    public Reimbursement(Double amount, String description, ReimbursementType type) {
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public Reimbursement(Double amount, String description, Integer authorId, ReimbursementType type) {
        this.amount = amount;
        this.description = description;
        this.authorId = authorId;
        this.type = type;
    }

    public Reimbursement(Double amount, String description, InputStream receipt, ReimbursementType type) {
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.type = type;
    }

    public Reimbursement(Integer reimbId, Double amount, String submitted, Integer authorId, ReimbursementStatus status, ReimbursementType type) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.authorId = authorId;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(Integer reimbId, Double amount, String submitted, String description, Integer authorId, ReimbursementStatus status, ReimbursementType type) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.authorId = authorId;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(Integer reimbId, Double amount, String submitted, String description, InputStream receipt, Integer authorId, ReimbursementStatus status, ReimbursementType type) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.receipt = receipt;
        this.authorId = authorId;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(Integer reimbId, Double amount, String submitted, String resolved, String description, InputStream receipt, Integer authorId, Integer resolverId, ReimbursementStatus status, ReimbursementType type) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.authorId = authorId;
        this.resolverId = resolverId;
        this.status = status;
        this.type = type;
    }

    public Integer getReimbId() {
        return reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        return Objects.equals(reimbId, that.reimbId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(submitted, that.submitted) &&
                Objects.equals(resolved, that.resolved) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(resolverId, that.resolverId) &&
                status == that.status &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbId, amount, submitted, resolved, description, receipt, authorId, resolverId, status, type);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
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
