package com.revature.revabooks.screens;

import java.util.Objects;

public abstract class Screen {

    private String name;
    private String Route;

    public Screen() {

    }

    public Screen(String name, String route) {
        this.name = name;
        Route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    public void render() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screen screen = (Screen) o;
        return Objects.equals(name, screen.name) &&
                Objects.equals(Route, screen.Route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Route);
    }

    @Override
    public String toString() {
        return "Screen{" +
                "name='" + name + '\'' +
                ", Route='" + Route + '\'' +
                '}';
    }
}
