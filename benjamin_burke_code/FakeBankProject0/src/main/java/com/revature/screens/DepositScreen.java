package com.revature.screens;

import com.revature.AppDriver;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Account;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import javax.sound.midi.Soundbank;
import java.io.IOException;

import static com.revature.AppDriver.*;
import static com.revature.util.AppState.router;

//import static com.revature.AppDriver.*;

public class DepositScreen extends Screen{
    private UserService userService;
    private AccountService accountService;

    public DepositScreen(AccountService accountService){
        super("DepositScreen", "/deposit");
        this.accountService = accountService;
    }

    @Override
    public void render() throws IOException {
        double amount;
        double newBalance;
        String userInput;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("How much do you want to deposit?");

        try {

            amount = Double.parseDouble(app().getConsole().readLine());
            newBalance = accountService.deposit(amount);
            System.out.println("Balance is: " + newBalance);
            System.out.println("What would you like to do: 1)Profile \n2)Logout");
            userInput=app().getConsole().readLine();
            switch (userInput){
                case "1":
                    router.navigate("/select"); break;
                case "2":
                    router.navigate("/home"); break;
                    //turn off app

                default:
                    System.out.println("please pick an option");
            }

        } catch (NumberFormatException | InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("invalid input");
            router.navigate("/deposit");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
