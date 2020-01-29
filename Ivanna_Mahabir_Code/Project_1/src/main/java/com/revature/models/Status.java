package com.revature.models;

public enum Status {
    APPROVED(1, "Approved"), DENIED(2, "Denied"), SUBMITTED(3, "Submitted");

    private int id;
    private String statusName;

    Status(Integer id, String stat) {
        this.id = id;
        this.statusName = stat;
    }

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

    public int getId() {
        return id;
    }

    @Override
    public String toString() { return statusName; }
}
