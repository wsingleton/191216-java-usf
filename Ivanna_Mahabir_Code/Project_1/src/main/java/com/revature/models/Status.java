package com.revature.models;

public enum Status {
    SUBMITTED("Submitted"), APPROVED("Approved"), DENIED("Denied");

    private String statusName;

    Status(String stat) { this.statusName = stat; }

    public static Status getStatusbyId(int id){

        Status status = null;

        switch(id){
            case 1:
                status = Status.APPROVED;
                break;

            case 2:
                status = Status.DENIED;
                break;

            default:
                status = Status.SUBMITTED;
        }
        return status;
    }
    @Override
    public String toString() { return statusName; }
}
