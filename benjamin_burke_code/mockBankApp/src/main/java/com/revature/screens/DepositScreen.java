package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.AccountUser;
import com.revature.services.AccountService;


import static com.revature.AppDriver.app;

public class DepositScreen extends Screen{

    private AccountService accountService;

    public DepositScreen(AccountService accountService){
        super("DepositScreen","/deposit");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
    }

    @Override
    public void render(){
        double oldAmount;
        double newAmount;
        String userInput;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("How much to deposit?");
        try {


        oldAmount = Double.parseDouble(app().getConsole().readLine());
        newAmount = accountService.deposit(oldAmount);
        System.out.println("Your balance is " + newAmount);
        System.out.println("What would you like to do 1)Another Transaction \n2)Logout");
        userInput = app().getConsole().readLine();
        switch (userInput){
            case "1":
                app().getRouter().navigate("/select"); break;
            case "2":
                app().getRouter().navigate("/home"); break;
            default:
                System.out.println("Invalid Selection");
        }
    } catch (InvalidRequestException| NumberFormatException| ResourcePersistentException e){
            System.out.println("invalid input");
            app().getRouter().navigate("/select");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
