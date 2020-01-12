package com.revature.util;

import com.revature.exceptions.ScreenNotFoundException;
import com.revature.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {
    private Set<Screen> screens = new HashSet<>();

    public  ScreenRouter addScreen(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route) throws ScreenNotFoundException {
        screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst()
                .orElseThrow(ScreenNotFoundException::new)
                .render();
    }
}
