package com.revature.ers.dtos;

import com.revature.ers.models.Type;

import javax.sql.rowset.serial.SerialBlob;

public class NewReimbursement {
    private byte[] receipt1;
    private String receipt;
    private double amount;
    private String description;
    int type;

    public NewReimbursement() {
    }

    public NewReimbursement(String receipt, double amount, String description, int type) {
        this.receipt = receipt;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Type getConvertedType() {
        return Type.getById(this.type);
    }

    public SerialBlob getBlob() {
        SerialBlob blob = null;
        receipt1 = receipt.getBytes();
        try {
            blob = new SerialBlob(receipt1);
        } catch (Exception e) { e.printStackTrace(); }
        return blob;
    }
}
