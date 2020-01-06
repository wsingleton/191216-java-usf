package com.revature.revabooks.util;

import com.revature.revabooks.exceptions.ScreenNotFoundException;
import com.revature.revabooks.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Set<Screen> screens = new HashSet<>();

    public  Set<Screen> getScreens() {
        return screens;
    }

    public  ScreenRouter addScreen(Screen screen){
        System.out.println("[LOG] loading screen " + screen.getName() + " into router");
        screens.add(screen);
        // this keyword allows chaining of add method
        return this;
    }

    public void navigate(String route){
        //stream present on all collections(and is necessary for lambda method introduced in java 8
        screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst()
                .orElseThrow(ScreenNotFoundException::new)
                .render();
    }

}
