package com.revature.project1.models;

public enum Status {


    PENDING(1,"Pending"), APPROVED(2, "Approval"), DENIED(3,"Denied");

    private Integer id;
    private String status;

    Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public static Status getStatusById(int id) {

        Status status = null;

        switch (id) {
            case 1:
                status = Status.PENDING;
                break;
            case 2:
                status = Status.APPROVED;
                break;
            default:
                status = Status.DENIED;
        }

        return status;
    }

    public int getStatusId() {
        return id;
    }

    @Override
    public String toString() {
        return status;
    }

}
