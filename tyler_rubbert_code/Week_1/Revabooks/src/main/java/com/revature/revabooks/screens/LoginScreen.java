package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class LoginScreen extends Screen{

    private String name = "LoginScreen";
    private String route = "/login";
    private UserService userService;

    public LoginScreen() {
        super();
    }

    public LoginScreen(String name, String route, UserService userService) {
        super(name, route);
        this.userService = userService;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getRoute() {
        return super.getRoute();
    }

    @Override
    public void setRoute(String route) {
        super.setRoute(route);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
