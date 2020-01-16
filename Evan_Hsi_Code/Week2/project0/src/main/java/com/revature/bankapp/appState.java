package com.revature.bankapp;

import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ScreenRouter;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class appState {

    private BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    private ScreenRouter router;
    private boolean appRunning = true;
    private User currentUser;
    private int userid;



    public BufferedReader getConsole() {
        return console;
    }

    public void setConsole(BufferedReader console) {
        this.console = console;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public void setRouter(ScreenRouter router) {
        this.router = router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
