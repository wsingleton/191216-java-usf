package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Account;
import com.revature.services.AccountService;

import java.io.IOException;

import static com.revature.AppDriver.*;

public class CreateChecking extends Screen {
    public CreateChecking(){
        super("CreateChecking", "/createChecking");
    }

    @Override
    public void render(){
        Double balance = 0.0;
        try {

            String accountType = "checking";
            String inp = "0.0";
            System.out.println(" enter amount you want to deposit");

            inp = console.readLine();
            try {
                balance = Double.parseDouble(inp);

            } catch (Exception e) {
                System.err.println("enter number only");
            } if (balance<=0){
                System.err.println("Please enter a positive number");
            }
            else {
                int newId = currentUser.getId();

                Account newAcc = new Account(accountType, balance);

                AccountService accountService = new AccountService();
                accountService.register(newAcc, newId);

                if(currentUser !=null){
                    System.out.println("[LOG] - new Checking account is created!");
                    router.navigate("/select");
                }
            }


        } catch(InvalidRequestException | ResourcePersistenceException e){
            System.out.println("Registration fail, invalid values provided");
        } catch (Exception e){
            System.err.println("[Error] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning=false;
        }
    }
}
