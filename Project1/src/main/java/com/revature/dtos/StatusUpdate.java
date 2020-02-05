package com.revature.dtos;

public class StatusUpdate {

    private int id;
    private int statusId;

    public StatusUpdate() {
        super();
    }

    public StatusUpdate(int id, int statusId) {
        this.id = id;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "StatusUpdate{" +
                "id=" + id +
                ", statusId=" + statusId +
                '}';
    }
}
