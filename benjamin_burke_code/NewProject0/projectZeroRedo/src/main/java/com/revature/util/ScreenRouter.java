package com.revature.util;

import com.revature.exceptions.ScreenNotFoundException;
import com.revature.screens.Screen;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Set<Screen> screens = new HashSet<>();

    public Set<Screen> getScreens() {
        return screens;
    }

    public ScreenRouter addScreen(Screen screen) {

        screens.add(screen);
        return this;
    }

    public void navigate(String route) throws IOException {

        // See logic below this for functional implementation using Java 8 Stream API (with lambdas)
//        for (Screen screen : screens) {
//            if (screen.getRoute().equals(route)) {
//                screen.render();
//            }
//        }

        screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst().orElseThrow(ScreenNotFoundException::new)
                .render();

    }

}