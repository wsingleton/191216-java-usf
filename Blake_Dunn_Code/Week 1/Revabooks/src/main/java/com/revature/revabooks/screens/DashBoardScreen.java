package com.revature.revabooks.screens;

public class DashBoardScreen extends Screen {

    private String name = "DashboardScreen";
    private String route = "/dashboard";

    public DashBoardScreen() {
        super("DashBoardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("Dashboard works!");

    }
}
