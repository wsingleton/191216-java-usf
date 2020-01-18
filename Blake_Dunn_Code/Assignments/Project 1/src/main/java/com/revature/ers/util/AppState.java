package com.revature.ers.util;

import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private UserSession currentSession;
    private boolean appRunning;

    public AppState() {

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final ReimbursementRepository reimbRepo = new ReimbursementRepository();

        final UserService userService= new UserService();
        final ReimbursementService reimbursementService = new ReimbursementService();

    }

    public BufferedReader getConsole() {
        return console;
    }

    public UserSession getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(UserSession currentSession) {
        this.currentSession = currentSession;
    }

    public void invalidateCurrentSession() {
        this.currentSession = null;
    }

    public boolean isSessionValid() {
        return (this.currentSession != null);
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }
}

