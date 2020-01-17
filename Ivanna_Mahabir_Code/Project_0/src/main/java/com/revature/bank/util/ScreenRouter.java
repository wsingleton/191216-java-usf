package com.revature.bank.util;

import com.revature.bank.exceptions.ScreenNotFoundException;
import com.revature.bank.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {
    private Set<Screen> screens = new HashSet<>();

    public Set<Screen> getScreens() {
        return screens;
    }

    public ScreenRouter addScreen(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route){
        screens.stream()
               .filter(screen -> screen.getRoute().equals(route))
               .findFirst().orElseThrow(ScreenNotFoundException::new)
               .render();
    }

}
