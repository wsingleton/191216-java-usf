package com.revature.project1.models;

public enum Status {


    PENDING(1,"Pending"), APPROVED(2, "Approval"), DENIED(3,"Denied");

    private Integer id;
    private String name;

    Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Status getById(int id){
        for (Status status : Status.values()) {
            if (status.id ==id) {
                return status;
            }
        }
        return Status.PENDING;
    }

    public int getId(){ return id;}

    @Override
    public String toString(){return name;}
}
