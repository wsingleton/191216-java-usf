package com.ers.liberation.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Reimbursement {

    private Integer reimbId;
    private Double amount;
    private Timestamp submittedDate;
    private Timestamp resolvedDate;
    private String description;
    private InputStream receipt;
    private Integer AuthorId;
    private Integer resolverId;
    private ReimbursementStatus status;
    private ReimbursementType type;


    public Reimbursement(Integer reimbId, Double amount, Timestamp submittedDate, Timestamp resolvedDate, String description, InputStream receipt, Integer authorId, Integer resolverId, ReimbursementStatus status, ReimbursementType type) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.resolvedDate = resolvedDate;
        this.description = description;
        this.receipt = receipt;
        this.AuthorId = authorId;
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

    public Timestamp getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Timestamp submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Timestamp getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Timestamp resolvedDate) {
        this.resolvedDate = resolvedDate;
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
        return AuthorId;
    }

    public void setAuthorId(Integer authorId) {
        AuthorId = authorId;
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
                Objects.equals(submittedDate, that.submittedDate) &&
                Objects.equals(resolvedDate, that.resolvedDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                Objects.equals(AuthorId, that.AuthorId) &&
                Objects.equals(resolverId, that.resolverId) &&
                status == that.status &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbId, amount, submittedDate, resolvedDate, description, receipt, AuthorId, resolverId, status, type);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submittedDate=" + submittedDate +
                ", resolvedDate=" + resolvedDate +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", AuthorId=" + AuthorId +
                ", resolverId=" + resolverId +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
