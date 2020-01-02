package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class RegisterScreen extends Screen {

    private String name = "RegisterScreen";
    private String route = "/register";
    private UserService userService;

    public RegisterScreen(String name, String route, UserService userService) {
        this.name = name;
        this.route = route;
        this.userService = userService;
    }

    public RegisterScreen(String name, String route, String name1, String route1) {
        super(name, route);
        this.name = name1;
        this.route = route1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRoute() {
        return route;
    }

    @Override
    public void setRoute(String route) {
        this.route = route;
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
