package com.revature.revbooks.util;

import com.revature.revbooks.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Set<Screen> screens = new HashSet<>();

    private Set<Screen> getScreens () {
        return screens;
    }

    public ScreenRouter addScreen(Screen screen) {
        System.out.println("[LOG] - Loading " + screen.getName() + "into router");
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {

        /*
        See logic below this for functional implementation using Java 8 Stream API (with lambdas)

        for (Screen screen: screen) {
            if (screen.getRoute.equals(route)) {
                screen.render();
         */

        screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst().orElseThrow(SecurityException::new).render();
    }
}
