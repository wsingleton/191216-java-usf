package com.revature.models;

public enum Status {
    APPROVED(1, "Approved"), DENIED(2, "Denied"), SUBMITTED(3, "Submitted");

    private Integer id;
    private String statusName;

    Status(Integer id, String status) {
        this.id = id;
        this.statusName = status;
    }

    public static Status getStatusbyId(int id){

       for(Status status : Status.values()){
           if(status.id == id){
               return status;
           }

        }
        return Status.SUBMITTED;
    }

    public int getId() {
        return id;
    }


}
