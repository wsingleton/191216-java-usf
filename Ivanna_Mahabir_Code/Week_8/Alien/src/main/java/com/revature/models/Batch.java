package com.revature.models;


import java.util.Objects;
import java.util.Set;

public class Batch {

    private int batchId;

    private String title;

    private long start_date;

    private long end_date;

    private Set<EmployeeAssignment> emplAssignment;

    public Batch() {
        super();
    }

    public Batch(int batchId, String title, long start_date, long end_date) {
        this.batchId = batchId;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStart_date() {
        return start_date;
    }

    public void setStart_date(long start_date) {
        this.start_date = start_date;
    }

    public long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(long end_date) {
        this.end_date = end_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return batchId == batch.batchId &&
                start_date == batch.start_date &&
                end_date == batch.end_date &&
                Objects.equals(title, batch.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchId, title, start_date, end_date);
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", title='" + title + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
