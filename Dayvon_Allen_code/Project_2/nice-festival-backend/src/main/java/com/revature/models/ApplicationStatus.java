package com.revature.models;

public enum ApplicationStatus {

    APPROVED("Approved"), DENIED("Denied"), PENDING("Pending");

    private String statusName;

    ApplicationStatus(String name) {this.statusName = name;}

    @Override
    public String toString(){return this.statusName;}

}
