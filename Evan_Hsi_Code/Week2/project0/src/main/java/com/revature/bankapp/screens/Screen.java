package com.revature.bankapp.screens;

public abstract class Screen {

    private String name;
    private String route;

    public Screen() {
    }

    public Screen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getRoute() {
        return this.route;
    }

    public String getName() {
        return this.name;
    }

    public abstract void render();
}
