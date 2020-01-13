package com.revature.fauxbankextended.util;

import com.revature.fauxbankextended.models.Account;
import com.revature.fauxbankextended.models.User;

import java.sql.Connection;

public class UserSession {

    private User sessionUser;
    private Connection connection;
    private Account sessionAccount;

    public UserSession(User user, Account acct, Connection conn) {

        if(user == null || acct == null || conn == null) {
            throw new RuntimeException("Cannot establish user session, null values provided.");
        }

        sessionUser = user;
        sessionAccount = acct;
        connection = conn;
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }

    public Account getSessionAccount() {
        return sessionAccount;
    }

    public void setSessionAccount(Account sessionAccount) {
        this.sessionAccount = sessionAccount;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
