package com.fauxnancials.menus;

public abstract class Menu {
    private String name;
    private String route;
    protected Menu(String name, String route) {
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