package com.revature.ers.dto;

import java.util.Objects;

public class Approvals {
    private int reimbID;
    private boolean approved;

    public Approvals() {
    }

    public int getReimbID() {
        return reimbID;
    }

    public void setReimbID(int reimbID) {
        this.reimbID = reimbID;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Approvals approvals = (Approvals) o;
        return reimbID == approvals.reimbID &&
                approved == approvals.approved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbID, approved);
    }

    @Override
    public String toString() {
        return "Approvals{" +
                "reimbID=" + reimbID +
                ", approved=" + approved +
                '}';
    }
}
