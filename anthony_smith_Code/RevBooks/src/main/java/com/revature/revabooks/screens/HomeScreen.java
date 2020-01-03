package com.revature.revabooks.screens;

import java.security.PublicKey;

public class HomeScreen extends Screen {

    public HomeScreen(){
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating" + super.getName());
    }


    @Override
    public void reander(){
        System.out.println("Welcome to RevaBooks!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");
    }

}
