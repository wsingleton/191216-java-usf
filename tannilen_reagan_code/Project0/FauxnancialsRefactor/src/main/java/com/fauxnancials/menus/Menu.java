package com.fauxnancials.menus;

public abstract class Menu {
    private String menuName;
    private String menuRoute;
    protected Menu(String name, String route) {
        this.menuName=name;
        this.menuRoute=route;
    }
    public String getName(){
        return menuName;
    }
    public String getRoute(){
        return menuRoute;
    }
    public abstract void render();
}
