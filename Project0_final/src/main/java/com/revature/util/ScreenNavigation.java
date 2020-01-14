package com.revature.util;

import com.revature.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenNavigation {

    private Set<Screen> screens = new HashSet<>();

    public Set<Screen> getScreen() {
        return screens;
    }

    public ScreenNavigation addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    public void navigate(String path) {
        screens.stream()
                .filter(screen -> screen.getPath().equals(path))
                .findFirst().orElseThrow(SecurityException::new).load();
    }
}
