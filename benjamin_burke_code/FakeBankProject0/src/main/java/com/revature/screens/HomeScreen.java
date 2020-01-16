package com.revature.screens;

import static com.revature.AppDriver.*;
//import static com.revature.AppDriver.appRunning;
import static com.revature.util.AppState.router;

public class HomeScreen extends Screen {

    public HomeScreen(){
        super("HomeScreen","/home");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render(){
        System.out.println("Welcome to Ben's Bank!");
        System.out.println("Please select your option!");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("3: Exit");

        try {

            System.out.println("> ");
            String ui = app().getConsole().readLine();
            switch (ui){

                case "1":
                    router.navigate("/login"); break;
                case "2":
                    router.navigate("/register"); break;
                case "3":
                    System.out.println("Exiting...goodbye");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Please pick another selection!");
            }


        } catch (Exception e){
            System.err.println("[ERROR] -" + e.getMessage());
            System.out.println("[LOG]-GoodyBye!");
            app().setAppRunning(false);
        }
    }
}
