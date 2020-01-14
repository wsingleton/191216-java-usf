package com.revature.screens;

public class HomeScreen extends Screen {
    public HomeScreen(String name, String path) {
        super(name, path);
    }

    @Override
    public void load() {
        System.out.println("Press 1 to register");
        System.out.println("Press 2 to login");
        System.out.println("Press 3 to exit");
    }

}
