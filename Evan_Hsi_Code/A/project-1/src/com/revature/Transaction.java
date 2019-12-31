package com.revature;

public class Transaction {
    private int transID;
    private int Y;
    private int M;
    private int D;
    private int hr;
    private int min;
    private int sec;
    private int amnt;
    private TransactionType transType;
    private int locationID;

    public Transaction() {
    }

    public Transaction(int transID, int y, int m, int d, int hr, int min, int sec, int amnt, TransactionType transType, int locationID) {
        this.transID = transID;
        Y = y;
        M = m;
        D = d;
        this.hr = hr;
        this.min = min;
        this.sec = sec;
        this.amnt = amnt;
        this.transType = transType;
        this.locationID = locationID;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getAmnt() {
        return amnt;
    }

    public void setAmnt(int amnt) {
        this.amnt = amnt;
    }

    public TransactionType getTransType() {
        return transType;
    }

    public void setTransType(TransactionType transType) {
        this.transType = transType;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transID=" + transID +
                ", Y=" + Y +
                ", M=" + M +
                ", D=" + D +
                ", hr=" + hr +
                ", min=" + min +
                ", sec=" + sec +
                ", amnt=" + amnt +
                ", transType=" + transType +
                ", locationID=" + locationID +
                '}';
    }
}
