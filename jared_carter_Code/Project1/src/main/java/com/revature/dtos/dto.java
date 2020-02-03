package com.revature.dtos;

public class dto {
    private int id;
    private int status;
    public dto() {
    }
    public dto(int id, int status) {
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
        return "dto{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}