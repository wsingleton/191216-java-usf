package com.revature.ers.models;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reimbursement {

    private int id;
    private int submitId;
    private LocalDateTime submitTime;
    private int resolveId;
    private LocalDateTime resolveTime;
    private double amount;
    private String description;
    private String receipt;
    private Type type;
    private Status status;

    public Reimbursement() {
        this.id = 0;
        this.submitId = 0;
        this.submitTime = null;
        this.resolveId = 0;
        this.resolveTime = null;
        this.amount = 0;
        this.description = null;
        this.receipt = null;
        this.type = null;
        this.status = null;
    }

    public Reimbursement(int id, Status status) {
        this.id = id;
        this.status = status;
    }

    public Reimbursement(double amount, String description, String receipt, int type) {
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.type = Type.getById(type);
        this.status = Status.PENDING;
    }

    public Reimbursement(int submitId, LocalDateTime submitTime, int resolveId, LocalDateTime resolveTime, double amount, String description) {
        this.id = 0;
        this.submitId = submitId;
        this.submitTime = submitTime;
        this.resolveId = resolveId;
        this.resolveTime = resolveTime;
        this.amount = amount;
        this.description = description;
        this.receipt = null;
        this.type = Type.OTHER;
        this.status = Status.PENDING;
    }

    public Reimbursement(int id, int submitId, LocalDateTime submitTime, int resolveId, LocalDateTime resolveTime, double amount, String description, Type type, Status status) {
        this.id = id;
        this.submitId = submitId;
        this.submitTime = submitTime;
        this.resolveId = resolveId;
        this.resolveTime = resolveTime;
        this.amount = amount;
        this.description = description;
        this.receipt = null;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubmitId() {
        return submitId;
    }

    public void setSubmitId(int submitId) {
        this.submitId = submitId;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public int getResolveId() {
        return resolveId;
    }

    public void setResolveId(int resolveId) {
        this.resolveId = resolveId;
    }

    public LocalDateTime getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(LocalDateTime resolveTime) {
        this.resolveTime = resolveTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id &&
                submitId == that.submitId &&
                resolveId == that.resolveId &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(submitTime, that.submitTime) &&
                Objects.equals(resolveTime, that.resolveTime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                type == that.type &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, submitId, submitTime, resolveId, resolveTime, amount, description, receipt, type, status);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", submitId=" + submitId +
                ", submitTime='" + submitTime + '\'' +
                ", resolveId=" + resolveId +
                ", resolveTime='" + resolveTime + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}