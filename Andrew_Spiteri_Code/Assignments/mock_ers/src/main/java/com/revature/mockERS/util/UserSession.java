package com.revature.mockERS.util;

import com.revature.mockERS.models.ERS_User_Roles;
import com.revature.mockERS.models.ERS_Users;

import java.sql.Connection;

public class UserSession {
    private ERS_Users sessionUser;
    private Connection connection;

    public UserSession(ERS_Users user, Connection conn){
        if(user == null || conn == null){
            throw new RuntimeException("Cannot establish user session, null values provided.");
        }
        sessionUser = user;
        connection = conn;
    }

    public ERS_Users getSessionUser(){
        return sessionUser;
    }

    public void setSessionUser(ERS_Users sessionUser) {
        this.sessionUser = sessionUser;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Boolean isAdminOrManager(){
        ERS_User_Roles currentUserRole = this.getSessionUser().getRole();
        return currentUserRole.equals(ERS_User_Roles.FINANCE_MANAGER);
    }
}
