package com.revature.models;

public enum CreditScore {
    TRANSUNION(0),EXPERIAN(0);

    private Integer score;

    CreditScore(Integer score){
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
