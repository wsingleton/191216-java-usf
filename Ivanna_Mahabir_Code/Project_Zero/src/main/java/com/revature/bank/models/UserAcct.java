package com.revature.bank.models;

import java.util.Objects;

public class UserAcct {
    private Integer user_id;
    private Integer acct_id;

    public UserAcct(){
        super();
    }

    public UserAcct(Integer user_id, Integer acct_id) {
        this.user_id = user_id;
        this.acct_id = acct_id;
    }

    public UserAcct(Integer userId) {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAcct_id() {
        return acct_id;
    }

    public void setAcct_id(Integer acct_id) {
        this.acct_id = acct_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAcct userAcct = (UserAcct) o;
        return Objects.equals(user_id, userAcct.user_id) &&
                Objects.equals(acct_id, userAcct.acct_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, acct_id);
    }

    @Override
    public String toString() {
        return "UserAcct{" +
                "user_id=" + user_id +
                ", acct_id=" + acct_id +
                '}';
    }
}
