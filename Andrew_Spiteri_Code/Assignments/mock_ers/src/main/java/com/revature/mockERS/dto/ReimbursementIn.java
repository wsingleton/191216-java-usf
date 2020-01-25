package com.revature.mockERS.dto;

import java.math.BigDecimal;
import java.sql.Blob;

public class ReimbursementIn {
    BigDecimal amount;
    String desc;
    Blob blob;
    String type;

    public ReimbursementIn(BigDecimal amount, String desc, Blob blob, String type) {
        this.amount = amount;
        this.desc = desc;
        this.blob = blob;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
