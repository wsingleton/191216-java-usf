package com.revature.util;

import com.revature.models.User;

import java.sql.Connection;

public class UserConnection {

    private User currentUser;
    private Connection currentConnection;
    private UserConnection existing;

    public UserConnection(User user, Connection connect) {

        if (user == null || connect == null) {
            throw new RuntimeException("Cannot establish the connection to this user");
        }

        currentUser = user;
        currentConnection = connect;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Connection getCurrentConnection() {
        return currentConnection;
    }

    public void setCurrentConnection(Connection currentConnection) {
        this.currentConnection = currentConnection;
    }

    public UserConnection getExisting() {
        return existing;
    }

    public void setExisting(UserConnection existing) {
        this.existing = existing;
    }
}
