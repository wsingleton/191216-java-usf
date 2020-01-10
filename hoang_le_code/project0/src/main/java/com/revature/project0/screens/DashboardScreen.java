package com.revature.project0.screens;

import com.revature.project0.AppDriver;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");

    }

    @Override
    public void render() {
        System.out.println("dashboard works!");
        System.out.println(AppDriver.currentUser);
    }

}