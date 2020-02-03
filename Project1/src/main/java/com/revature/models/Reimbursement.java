package com.revature.models;

public class Reimbursement {

    private int id;
    private int authId;
    private int resId;
    private String receipt;
    private String description;
    private String amount;
    private String timeSubmitted;
    private String timeResolved;
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

    public Reimbursement(int id, int authId, String amount, String timeSubmitted, Category categoryId, Status statusId) {
        this.id = id;
        this.authId = authId;
        this.amount = amount;
        this.timeSubmitted = timeSubmitted;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public Reimbursement(int id, int authId, int resId, String amount, String timeSubmitted, String timeResolved, Category categoryId, Status statusId) {
        this.id = id;
        this.authId = authId;
        this.resId = resId;
        this.amount = amount;
        this.timeSubmitted = timeSubmitted;
        this.timeResolved = timeResolved;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public Reimbursement(int id, int authId, int resId, String receipt, String description, String amount, String timeSubmitted, String timeResolved, Category categoryId, Status statusId) {
        this.id = id;
        this.authId = authId;
        this.resId = resId;
        this.receipt = receipt;
        this.description = description;
        this.amount = amount;
        this.timeSubmitted = timeSubmitted;
        this.timeResolved = timeResolved;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(String timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public String getTimeResolved() {
        return timeResolved;
    }

    public void setTimeResolved(String timeResolved) {
        this.timeResolved = timeResolved;
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
