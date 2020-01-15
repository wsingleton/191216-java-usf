package com.revature.fauxbankextended;

import com.revature.fauxbankextended.util.AppState;

public class BankDriver {

    private static AppState app = new AppState();

    public static void main(String[] args) {

        while (app.isAppRunning()) {
            app.getRouter().navigate("/home");
        }
    }

    public static AppState app() {
        return app;
    }
}
