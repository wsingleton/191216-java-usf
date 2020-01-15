package com.liberationbank.screens;

import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.User;
import com.liberationbank.services.AccountService;

import java.util.Scanner;

import static com.liberationbank.AppDriver.*;

public class DashboardScreen extends Screen {
    private AccountService accountService;
    public DashboardScreen(AccountService accountService){
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating "+ super.getName());
        this.accountService = accountService;
    }
    @Override
    public void render() {

        accountService.retrieveUserAccount(currentUser);
        System.out.println("Welcome, " + currentUser.getFirstName()+ "!");
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
            System.err.println("Invalid values provided");
        }catch(Exception e){
            e.printStackTrace();

            System.err.println("[ERROR] - An Unexpected exception occurred");
            System.out.println("[LOG] - shutting down application");
            appRunning = false;
        }



        }

    }

