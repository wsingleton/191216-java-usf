package com.revature.util;

import com.revature.exceptions.ScreenNotFoundException;
import com.revature.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Set<Screen> screens = new HashSet<>();

    public Set<Screen> getScreens(){
        return screens;
    }

    public ScreenRouter addScreen(Screen screen){
        System.out.println("[LOG] - Loading" + screen.getName() + " into router");
        screens.add(screen);
        return this;
    }

    public void navigate(String route){
        screens.stream().filter(screen -> screen.getRoute().equals(route))
                .findFirst().orElseThrow(ScreenNotFoundException::new)
                .render();
    }
}
