package com.revature.screens;

import com.revature.AppDriver;

public class DashboardScreen extends Screen {

    public DashboardScreen(){
        super("DashboardScreen", "/dashboard");
    }

    @Override
    public void render(){
        System.out.println("dashboard works!");
        System.out.println(AppDriver.currentUser);
    }
}
