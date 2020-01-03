package com.revature.revabooks.screens;

public abstract class Screen {
    private String name;
    private String route;
    protected Screen(String name, String route) {
        this.name=name;
        this.route=route;
    }
    public String getRoute() {
        return route;
    }
    public String getName() {
        return name;
    }
    public abstract void render();
}
