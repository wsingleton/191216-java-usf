package com.revature.revabooks.screens;

public class DashboardScreen extends Screen {

    private String name = "DashboardScreen";
    private String route = "/dashboard";

    public DashboardScreen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public void render() {

    }

}
