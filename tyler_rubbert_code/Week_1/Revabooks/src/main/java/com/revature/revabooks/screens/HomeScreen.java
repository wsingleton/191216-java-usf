package com.revature.revabooks.screens;

import java.util.Objects;

public class HomeScreen extends Screen {

    private String name = "HomeScreen";
    private String route = "/home";

    public HomeScreen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public HomeScreen(String name, String route, String name1, String route1) {
        super(name, route);
        this.name = name1;
        this.route = route1;
    }

    @Override
    public void render() {
        super.render();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HomeScreen that = (HomeScreen) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(route, that.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, route);
    }

    @Override
    public String toString() {
        return "HomeScreen{" +
                "name='" + name + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
