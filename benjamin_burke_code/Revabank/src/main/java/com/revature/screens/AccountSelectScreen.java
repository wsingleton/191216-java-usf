package com.revature.screens;

import java.util.Scanner;

import static com.revature.AppDriver.console;
import static com.revature.AppDriver.router;

public class AccountSelectScreen extends Screen {

    public AccountSelectScreen(){
        super("AccountSelectScreen", "/select");
    }

    @Override
    public void render(){
        try{

            String ip = " ";

            while(ip !="3"){
                System.out.println("Please choose your option");
                System.out.println("1--checking");
                System.out.println("2--savings");
                System.out.println("3--exit");
                System.out.println("What would you like to do?");
                ip = console.readLine();
                switch (ip){
                    case "1": router.navigate("/CheckingScreen"); break;
                    case "2": router.navigate("/SavingScreen"); break;
                    case "3":
                        System.out.println("Bye"); break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
