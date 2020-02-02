package com.revature.ers.models;
import java.util.Objects;

public class Reimbursement {
    private int id;
    private String amount;
    private String timeSubmitted;
    private String timeResolved;
    private String description;
    private String receipt;
    private int authorById;
    private int resolverById;
    private ReimbursementStatus reimbursementStatusId;
    private ReimbursementType reimbursementTypeId;

    public Reimbursement() {
        super();
    }


    public Reimbursement(int id, ReimbursementType reimbursementTypeId) {
        this.id = id;
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public Reimbursement(int id, String amount, String timeSubmitted, String timeResolved, String description, String receipt, int authorById, int resolverById, ReimbursementStatus reimbursementStatusId, ReimbursementType reimbursementTypeId) {
        this.id = id;
        this.amount = amount;
        this.timeSubmitted = timeSubmitted;
        this.timeResolved = timeResolved;
        this.description = description;
        this.receipt = receipt;
        this.authorById = authorById;
        this.resolverById = resolverById;
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public Reimbursement (String amount, String description, int authorById, ReimbursementStatus reimbursementStatusId, ReimbursementType reimbursementTypeId) {
        this.amount = amount;
        this.description = description;
        this.authorById = authorById;
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementTypeId = reimbursementTypeId;
    }


    public Reimbursement(int id, String amount, int authorById, ReimbursementStatus reimbursementStatusId, ReimbursementType reimbursementTypeId) {
        this.id = id;
        this.amount = amount;
        this.authorById = authorById;
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementTypeId = reimbursementTypeId;
    }


    public Reimbursement(String amount, String description, int authorById, ReimbursementType reimbursementTypeId) {
        this.amount = amount;
        this.description = description;
        this.authorById = authorById;
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(String timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public String getTimeResolved() {
        return timeResolved;
    }

    public void setTimeResolved(String timeResolved) {
        this.timeResolved = timeResolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public int getAuthorById() {
        return authorById;
    }

    public void setAuthorById(int authorById) {
        this.authorById = authorById;
    }

    public int getResolverById() {
        return resolverById;
    }

    public void setResolverById(int resolverById) {
        this.resolverById = resolverById;
    }

    public ReimbursementStatus getReimbursementStatusId() {
        return reimbursementStatusId;
    }

    public void setReimbursementStatusId(ReimbursementStatus reimbursementStatusId) {
        this.reimbursementStatusId = reimbursementStatusId;
    }

    public ReimbursementType getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public void setReimbursementTypeId(ReimbursementType reimbursementTypeId) {
        this.reimbursementTypeId = reimbursementTypeId;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount='" + amount + '\'' +
                ", timeSubmitted='" + timeSubmitted + '\'' +
                ", timeResolved='" + timeResolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", authorById=" + authorById +
                ", resolverById=" + resolverById +
                ", reimbursementStatusId=" + reimbursementStatusId +
                ", reimbursementTypeId=" + reimbursementTypeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement)) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id &&
                authorById == that.authorById &&
                resolverById == that.resolverById &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(timeSubmitted, that.timeSubmitted) &&
                Objects.equals(timeResolved, that.timeResolved) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                reimbursementStatusId == that.reimbursementStatusId &&
                reimbursementTypeId == that.reimbursementTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, timeSubmitted, timeResolved, description, receipt, authorById, resolverById, reimbursementStatusId, reimbursementTypeId);
    }
}