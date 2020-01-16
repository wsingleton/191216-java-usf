package com.revature.screens;

import java.io.IOException;

import static com.revature.BankMain.*;

public class HomeScreen extends Screen {
    public HomeScreen() {
        super("HomeScreen", "/home");
    }

    @Override
    public void load() {
        System.out.println("Press 1 to register");
        System.out.println("Press 2 to login");
        System.out.println("Press 3 to exit");

        try {

            String path = userInputs.readLine();

            switch (path) {
                case "1" :
                    navigation.navigate("/register"); break;
                case "2" :
                    navigation.navigate("/login"); break;
                case "3" :
                    System.out.println("Have a good day");
                    appLaunched = false; break;
                default:
                    System.out.println("Invalid entry");
            }

        } catch (IOException e ) {
            System.err.println("An unexpected problem occurred...proceeding to shutdown");
            appLaunched = false;
        }
    }

}
