package com.revature.ers;

import com.revature.ers.util.AppState;

public class AppDriver {

    private static AppState app = new AppState();

    public static void main(String[] args) {

        while (app.isAppRunning()) {

        }

    }

    public static AppState app() {
        return app;
    }
}

