package com.revature.mockERS.models;

import java.io.File;
import java.math.BigDecimal;
import java.util.Objects;

public class ERS_Reimbursement {
    private Integer reimbId;
    private BigDecimal reimb_amount;
    private ERS_Reimbursement_Status reimb_submitted, reimb_resolved;
    private ERS_Reimbursement_Type reimb_description;
    private File reimb_receipt;

    public ERS_Reimbursement(BigDecimal reimb_amount, ERS_Reimbursement_Status reimb_submitted, ERS_Reimbursement_Status reimb_resolved, ERS_Reimbursement_Type reimb_description, File reimb_receipt) {
        this.reimb_amount = reimb_amount;
        this.reimb_submitted = reimb_submitted;
        this.reimb_resolved = reimb_resolved;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
    }

    public ERS_Reimbursement(Integer reimbId, BigDecimal reimb_amount, ERS_Reimbursement_Status reimb_submitted, ERS_Reimbursement_Status reimb_resolved, ERS_Reimbursement_Type reimb_description, File reimb_receipt) {
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

    public ERS_Reimbursement_Status getReimb_submitted() {
        return reimb_submitted;
    }

    public void setReimb_submitted(ERS_Reimbursement_Status reimb_submitted) {
        this.reimb_submitted = reimb_submitted;
    }

    public ERS_Reimbursement_Status getReimb_resolved() {
        return reimb_resolved;
    }

    public void setReimb_resolved(ERS_Reimbursement_Status reimb_resolved) {
        this.reimb_resolved = reimb_resolved;
    }

    public ERS_Reimbursement_Type getReimb_description() {
        return reimb_description;
    }

    public void setReimb_description(ERS_Reimbursement_Type reimb_description) {
        this.reimb_description = reimb_description;
    }

    public File getReimb_receipt() {
        return reimb_receipt;
    }

    public void setReimb_receipt(File reimb_receipt) {
        this.reimb_receipt = reimb_receipt;
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
