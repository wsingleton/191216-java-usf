package com.fauxnancials.util;

import com.fauxnancials.exceptions.MenuNotFoundException;
import com.fauxnancials.menus.Menu;

import java.util.HashSet;
import java.util.Set;

public class NavRouter {
    private Set<Menu> menus = new HashSet<>();
    public NavRouter addMenu(Menu menu){
        menus.add(menu);
        return this;
    }
    public void navigate(String route){
        menus.stream()
                .filter(menu -> menu.getRoute().equals(route))
                .findFirst().orElseThrow(MenuNotFoundException::new)
                .render();
    }
}
