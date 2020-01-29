package com.revature.mockERS.dto;

import java.math.BigDecimal;
import java.sql.Blob;

public class ReimbursementIn {
    BigDecimal amount;
    String desc;
    String type;
    String status;

    public ReimbursementIn(){}

    public ReimbursementIn(BigDecimal amount, String desc, String type, String status) {
        this.amount = amount;
        this.desc = desc;
        this.type = type;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
