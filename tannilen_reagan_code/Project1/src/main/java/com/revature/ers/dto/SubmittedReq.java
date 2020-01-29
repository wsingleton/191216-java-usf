package com.revature.ers.dto;

import java.util.Objects;

public class SubmittedReq {
    private int userID;
    private double amt;
    private String desc;
    private int type;

    public SubmittedReq() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        SubmittedReq that = (SubmittedReq) o;
        return userID == that.userID &&
                Double.compare(that.amt, amt) == 0 &&
                type == that.type &&
                Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, amt, desc, type);
    }

    @Override
    public String toString() {
        return "SubmittedReq{" +
                "userID=" + userID +
                ", amt=" + amt +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }
}
