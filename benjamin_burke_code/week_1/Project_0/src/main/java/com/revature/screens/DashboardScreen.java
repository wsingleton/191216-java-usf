package com.revature.screens;

import com.revature.AppDriver;

public class DashboardScreen extends Screen {

    public DashboardScreen(){
        super("DashBoardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating" + super.getName());
    }

    @Override
    public void render(){
        System.out.println("Dashboard Works");
        System.out.println(AppDriver.currentUser);
    }
}
