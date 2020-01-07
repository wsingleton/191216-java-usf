package com.liberationbank.util;

import com.liberationbank.exceptions.ScreenNotFoundException;
import com.liberationbank.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {
    private Set<Screen> screens = new HashSet<>();

    public Set<Screen> getScreen(){
        return screens;
    }

    public ScreenRouter addScreen(Screen screen){
        System.out.println("[LOG] - Loading " + screen.getName() + " into router");
        screens.add(screen);
        return this;
    }

    public void navigate(String route){
// see logic below for functional implementation using java 8 stream API with lambdas
//        for(Screen screen : screens){
//            if(screen.getRoute().equals(route)){
//                screen.render();
//            }
//        }

        screens.stream().filter(screen -> screen.getRoute()
                .equals(route)).findFirst().orElseThrow(ScreenNotFoundException::new).render();


    }
}
