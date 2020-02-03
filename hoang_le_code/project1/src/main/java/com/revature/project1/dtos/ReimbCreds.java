package com.revature.project1.dtos;

public class ReimbCreds {
    public String amount;
    public String subTime;
    public String resTime;
    public String desc;
    public String receipt;
    public int authId;
    public int resolver;
    public int statusID;
    public int typeId;

    public ReimbCreds() {
        super();
    }

    public ReimbCreds(String amount, String subTime, String resTime, String desc, String receipt, int authId, int resolver, int statusID, int typeId) {
        this.amount = amount;
        this.subTime = subTime;
        this.resTime = resTime;
        this.desc = desc;
        this.receipt = receipt;
        this.authId = authId;
        this.resolver = resolver;
        this.statusID = statusID;
        this.typeId = typeId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public String getResTime() {
        return resTime;
    }

    public void setResTime(String resTime) {
        this.resTime = resTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
