package com.revature.dtos;

public class StatusUpdate {

    private int id;
    private int status;

    public StatusUpdate() {
        super();
    }

    public StatusUpdate(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusUpdate{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
