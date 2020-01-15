package com.revature.util;

import com.revature.exceptcions.ScreenNotFoundException;
import com.revature.screens.Screen;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {
    private Set<Screen> screens = new HashSet<>();

    public Set<Screen>getScreens(){
        return screens;
    }

    public ScreenRouter addScreen(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route) throws IOException {
        screens.stream()
                .filter(screen ->screen.getRoute().equals(route))
                .findFirst().orElseThrow(ScreenNotFoundException::new)
                .render();
    }
}
