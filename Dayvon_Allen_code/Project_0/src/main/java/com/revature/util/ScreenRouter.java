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
//navigates to the route that is inserted into the router
    public void navigate(String route) throws ScreenNotFoundException {
        //a lambda that looks for a screen with the same route now as the one that was input(throws ScreenNotFoundException if not found)
        screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst()
                .orElseThrow(ScreenNotFoundException::new)
                .render();
    }
}
