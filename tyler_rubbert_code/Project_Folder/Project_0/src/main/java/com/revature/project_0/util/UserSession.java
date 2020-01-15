package com.revature.project_0.util;

import com.revature.project_0.models.User;

import java.sql.Connection;

public class UserSession {

    private User sessionUser;
    private Connection connection;

    public UserSession(User user, Connection conn) {

        if(user == null || conn == null) {
            throw new RuntimeException("null values provided, cannot establish session");
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
