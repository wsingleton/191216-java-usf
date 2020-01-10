package com.fauxnancials.util;

import java.util.HashSet;
import java.util.Set;
import com.fauxnancials.menus.Menu;

public class Nav {
    private Set<Nav> menus = new HashSet<>();
    public Set<Nav> getMenus() {
        return menus;
    }
    public Nav addMenus(Nav menu) {
        System.out.println("[LOG] - Loading " + menu.getName() + " into router.");
        menus.add(menu);
        return this;
    }
    public void navigate(String route) {
        menus.stream()
                .filter(screen -> menu.getRoute().equals(route))
                .findFirst().orElseThrow(MenuNotFoundException::new)
                .render();
    }
}
