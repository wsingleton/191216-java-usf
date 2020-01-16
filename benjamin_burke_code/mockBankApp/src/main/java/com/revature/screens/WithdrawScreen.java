package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.services.AccountService;

import static com.revature.AppDriver.app;

public class WithdrawScreen extends Screen {

    private AccountService accountService;

    public WithdrawScreen(AccountService accountService){
        super("WithdrawScreen", "/withdraw");
        System.out.println("[LOG] - Instantiating" + super.getName());
        this.accountService = accountService;
    }

    @Override
    public void render(){
        double oldAmount;
        double newAmount;
        String userInput;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("How much do you want to withdraw?");

        try {
            oldAmount = Double.parseDouble(app().getConsole().readLine());
            newAmount = accountService.withdraw(oldAmount);
            System.out.println("Balance is " + newAmount);
            userInput = app().getConsole().readLine();

            switch (userInput){
                case "1":
                    app().getRouter().navigate("select");break;
                case "2":
                    app().getRouter().navigate("/home");break;
                default:
                    System.out.println("Invalid Selection");
            }
        }catch (ResourcePersistentException | NumberFormatException | InvalidRequestException e){
            System.out.println("You are broke or invalid input!");
            app().getRouter().navigate("/select");
        }catch (Exception e){
            e.printStackTrace();


        }
    }
}
