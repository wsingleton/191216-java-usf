package com.liberationbank.screens;

public abstract class Screen {
    private String name;
    private String route;

    protected Screen (String Name, String Route){
        this.name = Name;
        this.route = Route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();


}


