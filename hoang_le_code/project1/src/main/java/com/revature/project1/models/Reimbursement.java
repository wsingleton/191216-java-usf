package com.revature.project1.models;

public class Reimbursement {
    private int id;
    private String amount;
    private String subTime;
    private String resTimed;
    private String desc;
    private String receipt;
    private int authId;
    private int resId;
    private Status statusId;
    private Type typeId;



    public Reimbursement() {super();
    }

    public Reimbursement(String amount, String subTime, String resTimed, String desc, String receipt, int authId, int resId, Status statusId, Type typeId) {
        this.amount = amount;
        this.subTime = subTime;
        this.resTimed = resTimed;
        this.desc = desc;
        this.receipt = receipt;
        this.authId = authId;
        this.resId = resId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement(int id, String amount, int authId, Status statusId, Type typeId) {
        this.id = id;
        this.amount = amount;
        this.authId = authId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement(String amount, String desc, int authId, Type typeId) {
        this.amount = amount;
        this.desc = desc;
        this.authId = authId;
        this.typeId = typeId;
    }

    public Reimbursement(int id, String amount, String subTime, String desc, int authId, Status statusId, Type typeId) {
        this.id = id;
        this.amount = amount;
        this.subTime = subTime;
        this.desc = desc;
        this.authId = authId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement(int id, String amount, String subTime, String resTimed, String desc, int authId, int resId, Status statusId, Type typeId) {
        this.id = id;
        this.amount = amount;
        this.subTime = subTime;
        this.resTimed = resTimed;
        this.desc = desc;
        this.authId = authId;
        this.resId = resId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement(int id, String amount, String subTime, String resTimed, String desc, String receipt, int authId, int resId, Status statusId, Type typeId) {
        this.id = id;
        this.amount = amount;
        this.subTime = subTime;
        this.resTimed = resTimed;
        this.desc = desc;
        this.receipt = receipt;
        this.authId = authId;
        this.resId = resId;
        this.statusId = statusId;
        this.typeId = typeId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getResTimed() {
        return resTimed;
    }

    public void setResTimed(String resTimed) {
        this.resTimed = resTimed;
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

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount='" + amount + '\'' +
                ", subTime='" + subTime + '\'' +
                ", resTimed='" + resTimed + '\'' +
                ", desc='" + desc + '\'' +
                ", receipt='" + receipt + '\'' +
                ", authId=" + authId +
                ", resId=" + resId +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                '}';
    }
}
