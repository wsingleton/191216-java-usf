package com.revature.util;

import com.revature.models.Account;
import com.revature.models.User;

import java.sql.Connection;

public class UserSession {

    private User sessionUser;
   private Account accountType;
    private Connection connection;

    public UserSession(User user, Connection conn, Account account) {

        if(user == null || conn == null) {
            throw new RuntimeException("null values provided, cannot establish session");
        }

        sessionUser = user;
        accountType = account;
        connection = conn;

    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
