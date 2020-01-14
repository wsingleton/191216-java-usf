package com.revature.bank2.util;
import com.revature.bank2.exceptions.ScreenNotFoundException;
import com.revature.bank2.screens.Screen;

import java.util.HashSet;
import java.util.Set;


public class ScreenRouter {

    private Set<Screen> screens = new HashSet<>();

    public Set<Screen> getScreens(){
        return screens;
    }


    public ScreenRouter addScreen(Screen screen){
        System.out.println("[LOG] - loading " + screen.getName() + "" +
                " into router ");
        return this;
    }

    public void navigate(String route){

        screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst().orElseThrow(ScreenNotFoundException::new)
                .render();
    }


}
