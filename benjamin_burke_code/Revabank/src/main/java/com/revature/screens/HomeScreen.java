package com.revature.screens;

import static com.revature.AppDriver.*;

public class HomeScreen extends Screen {

    public HomeScreen(){
        super("HomeScreen","/home");
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
            String ui = console.readLine();
            switch (ui){

                case "1":
                    router.navigate("/login"); break;
                case "2":
                    router.navigate("/register"); break;
                case "3":{
                    System.out.println("Exiting...goodbye");
                    appRunning=false;
                    break;}
                default: {
                    System.out.println("Please pick another selection!");}
            }

        } catch (Exception e){
            System.err.println("[ERROR] -" + e.getMessage());
            System.out.println("[LOG]-GoodyBye!");
            appRunning = false;
        }
    }

}
