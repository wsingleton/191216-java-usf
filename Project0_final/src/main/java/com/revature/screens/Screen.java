package com.revature.screens;

public abstract class Screen {
    private String name;
    private String path;

    public Screen(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;

    }

    public abstract void load ();

}
