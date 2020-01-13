package com.revature.fauxbankextended.util;

import com.revature.fauxbankextended.models.User;

import java.sql.Connection;

public class UserSession {

    private User sessionUser;
    private Connection connection;

    public UserSession(User user, Connection conn) {

        if(user == null || conn == null) {
            throw new RuntimeException("Cannot establish user session, null values provided.");
        }

        sessionUser = user;
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
