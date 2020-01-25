package com.revature.mockERS.models;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

public class ERS_Reimbursement {
    private Integer reimbId;
    private BigDecimal reimb_amount;
    private Timestamp reimb_submitted, reimb_resolved;
    private String reimb_description;
    private Blob reimb_receipt;
    private ERS_Reimbursement_Status status;
    private ERS_Reimbursement_Type type;


    public ERS_Reimbursement(){}

    public ERS_Reimbursement(BigDecimal reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved, String reimb_description, Blob reimb_receipt, ERS_Reimbursement_Status status, ERS_Reimbursement_Type type) {
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        this.status = status;
        this.type = type;
    }

    public ERS_Reimbursement(Integer reimbId, BigDecimal reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved, String reimb_description, Blob reimb_receipt) {
        this.reimbId = reimbId;
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
    }

    public BigDecimal getReimb_amount() {
        return reimb_amount;
    }

    public void setReimb_amount(BigDecimal reimb_amount) {
        this.reimb_amount = reimb_amount;
    }

    public Timestamp getReimb_submitted() {
        return reimb_submitted;
    }

    public void setReimb_submitted(Timestamp reimb_submitted) {
        this.reimb_submitted = reimb_submitted;
    }

    public Timestamp getReimb_resolved() {
        return reimb_resolved;
    }

    public void setReimb_resolved(Timestamp reimb_resolved) {
        this.reimb_resolved = reimb_resolved;
    }

    public String getReimb_description() {
        return reimb_description;
    }

    public void setReimb_description(String reimb_description) {
        this.reimb_description = reimb_description;
    }

    public Blob getReimb_receipt() {
        return reimb_receipt;
    }

    public void setReimb_receipt(Blob reimb_receipt) {
        this.reimb_receipt = reimb_receipt;
    }

    public Integer getReimbId() {
        return reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public ERS_Reimbursement_Status getStatus() {
        return status;
    }

    public void setStatus(ERS_Reimbursement_Status status) {
        this.status = status;
    }

    public ERS_Reimbursement_Type getType() {
        return type;
    }

    public void setType(ERS_Reimbursement_Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ERS_Reimbursement that = (ERS_Reimbursement) o;
        return Objects.equals(reimb_amount, that.reimb_amount) &&
                reimb_submitted == that.reimb_submitted &&
                reimb_resolved == that.reimb_resolved &&
                reimb_description == that.reimb_description &&
                Objects.equals(reimb_receipt, that.reimb_receipt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt);
    }

    @Override
    public String toString() {
        return "ERS_Reimbursement{" +
                "reimb_amount=" + reimb_amount +
                ", reimb_submitted=" + reimb_submitted +
                ", reimb_resolved=" + reimb_resolved +
                ", reimb_description=" + reimb_description +
                ", reimb_receipt=" + reimb_receipt +
                '}';
    }
}
