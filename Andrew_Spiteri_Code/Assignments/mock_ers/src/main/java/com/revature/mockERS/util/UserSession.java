package com.revature.mockERS.util;

import com.revature.mockERS.models.ERS_User_Roles;
import com.revature.mockERS.models.ERS_Users;

import java.sql.Connection;

public class UserSession {
    private static ERS_Users sessionUser;
    private Connection connection;

    UserSession(){}

    public UserSession(ERS_Users user, Connection conn){
        if(user == null || conn == null){
            throw new RuntimeException("Cannot establish user session, null values provided.");
        }
        sessionUser = user;
        connection = conn;
    }

    public static ERS_Users getSessionUser(){
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

    public static Boolean isAdminOrManager(){
        ERS_User_Roles currentUserRole = getSessionUser().getRole();
        System.out.println(getSessionUser().toString());
        System.out.println(getSessionUser().getRole());
        return currentUserRole.equals("Finance_Manager");
    }
}
