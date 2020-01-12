package com.revature.revabank.screens;

public abstract class Screen {

    private String name;
    private String route;

    protected Screen(String name, String route) {
        this.name = name;
        this.route = name;
    }

    public String getName(){return name;}

    public String getRoute() {return route;}

    public abstract void render();
}
