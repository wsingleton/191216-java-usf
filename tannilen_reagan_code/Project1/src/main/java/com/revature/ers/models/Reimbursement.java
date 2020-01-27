package com.revature.ers.models;

import java.util.Arrays;
import java.util.Objects;

public class Reimbursement {
    private int reimbID;
    private double amt;
    private long submitted;
    private long resolved;
    private String desc;
    private byte[] receipt;
    private int authID;
    private int resID;
    private int status;
    private int type;

    public Reimbursement(int reimbID, double amt, long submitted, int authID, int status, int type) {
        this.reimbID = reimbID;
        this.amt = amt;
        this.submitted = submitted;
        this.authID = authID;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(int reimbID, double amt, long submitted, long resolved, String desc, byte[] receipt, int authID, int resID, int status, int type) {
        this.reimbID = reimbID;
        this.amt = amt;
        this.submitted = submitted;
        this.resolved = resolved;
        this.desc = desc;
        this.receipt = receipt;
        this.authID = authID;
        this.resID = resID;
        this.status = status;
        this.type = type;
    }

    public Reimbursement() {
    }

    public int getReimbID() {
        return reimbID;
    }

    public void setReimbID(int reimbID) {
        this.reimbID = reimbID;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    public int getAuthID() {
        return authID;
    }

    public void setAuthID(int authID) {
        this.authID = authID;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return reimbID == that.reimbID &&
                Double.compare(that.amt, amt) == 0 &&
                submitted == that.submitted &&
                resolved == that.resolved &&
                authID == that.authID &&
                resID == that.resID &&
                status == that.status &&
                type == that.type &&
                Objects.equals(desc, that.desc) &&
                Arrays.equals(receipt, that.receipt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(reimbID, amt, submitted, resolved, desc, authID, resID, status, type);
        result = 31 * result + Arrays.hashCode(receipt);
        return result;
    }

    @Override
    public String toString() {
        String typeName;
        switch (type) {
            case 1:
                typeName="travel";
                break;
            case 2:
                typeName="supply";
                break;
            case 3:
                typeName="PR";
                break;
            case 4:
                typeName="recurring";
            default:
                typeName="other";
                break;
        }
        String statusName;
        switch (status) {
            case 1:
                statusName="submitted";
                break;
            case 2:
                statusName="approved";
                break;
            case 3:
                statusName="rejected";
                break;
            default:
                statusName="unknown";
        }
        return "Reimbursement{" +
                "reimbID=" + reimbID +
                ", amt=" + amt +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", desc='" + desc + '\'' +
                ", receipt=" + Arrays.toString(receipt) +
                ", authID=" + authID +
                ", resID=" + resID +
                ", status=" + statusName +
                ", type=" + typeName +
                '}';
    }
}