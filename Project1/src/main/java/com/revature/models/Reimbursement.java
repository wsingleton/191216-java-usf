package com.revature.models;

public class Reimbursement {

    private int id;
    private int authId;
    private int resId;
    private String amount;
    private String dateSubmitted;
    private String dateResolved;
    private Category categoryId;
    private Status statusId;

    public Reimbursement() {
    }

    public Reimbursement(int id, int authId, String amount, Category categoryId, Status statusId) {
        this.id = id;
        this.authId = authId;
        this.amount = amount;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public Reimbursement(int authId, String amount, Category categoryId) {
        this.authId = authId;
        this.amount = amount;
        this.categoryId = categoryId;
    }

    public Reimbursement(int id, int authId, String amount, String dateSubmitted, Category categoryId, Status statusId) {
        this.id = id;
        this.authId = authId;
        this.amount = amount;
        this.dateSubmitted = dateSubmitted;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public Reimbursement(int id, int authId, int resId, String amount, String dateSubmitted, String dateResolved, Category categoryId, Status statusId) {
        this.id = id;
        this.authId = authId;
        this.resId = resId;
        this.amount = amount;
        this.dateSubmitted = dateSubmitted;
        this.dateResolved = dateResolved;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getDateResolved() {
        return dateResolved;
    }

    public void setDateResolved(String dateResolved) {
        this.dateResolved = dateResolved;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }
}
