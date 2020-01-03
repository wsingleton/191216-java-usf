package com.revature.revabooks.screens;

public class DashboardScreen extends Screen {
    public DashboardScreen(){
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("Dashboard works");

    }
}
