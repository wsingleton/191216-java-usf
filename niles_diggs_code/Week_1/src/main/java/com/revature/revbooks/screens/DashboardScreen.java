package com.revature.revbooks.screens;

import com.revature.revbooks.AppDriver;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("dashboard works!");
        System.out.println(AppDriver.currentUser);
    }
}
