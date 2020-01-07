package com.liberationbank.screens;

import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.User;

import java.util.Scanner;

import static com.liberationbank.AppDriver.*;

public class DashboardScreen extends Screen {
    public DashboardScreen(){
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating "+ super.getName());
    }
    @Override
    public void render() {
        System.out.println("Welcome!");
        System.out.println("To view balance enter 1\n" +
                "To make a deposit enter 2\n" +
                "To make a withdrawal enter 3");
        System.out.println("To exit logout 0");
        try{
        String Input = console.readLine();
        switch (Input) {
            case "1":
                System.out.println("User can now view balance");
                router.navigate("/balance");

            case "2":
                System.out.println("User can make a deposit");
                router.navigate("/deposit");


            case "3":
                System.out.println("You can now make a withdrawal");
                router.navigate("/withdrawal");

            case "0":
                System.out.println("Logging out...");
                router.navigate("/home");

            default:
                System.out.println("Not a valid input");
        }}catch(InvalidRequestException | ResourcePersistenceException e){
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        }catch(Exception e){
            System.err.println("[ERROR] - An Unexpected exception occured");
            System.out.println("[LOG] - shutting down application");
            appRunning = false;
        }



        }

    }

