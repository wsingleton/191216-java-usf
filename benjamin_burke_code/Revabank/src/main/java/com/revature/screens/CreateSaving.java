package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Account;
import com.revature.services.AccountService;

import static com.revature.AppDriver.*;

public class CreateSaving extends Screen {
    public CreateSaving(){super("CreateSaving", "/createSaving");}

    @Override
    public void render(){

        Double balance = 0.0;
        try {
            String accountType = "saving";
            String inp = "0.0";
            System.out.println("Enter the amount you'd like to deposit?");

            inp = console.readLine();
            try{
                balance = Double.parseDouble(inp);
            } catch (Exception e){
                System.out.println("Please enter a number");
            } if (balance<=0){
                System.err.println("Please enter a positive number");
            }
            else {
                int newId = currentUser.getId();

                Account newAcc = new Account(accountType, balance);

                AccountService accountService = new AccountService();
                accountService.register(newAcc, newId);

                if(currentUser !=null){
                    System.out.println("[LOG]-new saving account created!");
                    router.navigate("/select");
                }
            }
        } catch (InvalidRequestException | ResourcePersistenceException e){
            System.out.println("Registration failed, invalid input provided!");
        } catch (Exception e){
            System.err.println("[Error] - An unexpected exception occurred");
            System.out.println("[Log]- shutting down application");
            appRunning=false;
        }
    }
}
