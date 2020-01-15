package com.revature.project_0.screens;

import com.revature.project_0.exceptions.InvalidRequestException;
import com.revature.project_0.exceptions.ResourcePersistentException;
import com.revature.project_0.models.Account;
import com.revature.project_0.models.User;
import com.revature.project_0.repos.UserAccountRepository;
import com.revature.project_0.services.AccountService;
import com.revature.project_0.services.UserAccountService;

import static com.revature.project_0.AppDriver.app;

public class DepositScreen extends Screen{

    private AccountService accountService;

    public DepositScreen(AccountService accountService) {
        super("DepositScreen", "/deposit");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;

    }

    @Override
    public void render() {
        double amount;
        double newAmount;
        String userSelection;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("How much would you like to deposit?");

        try {

            amount = Double.parseDouble(app().getConsole().readLine());
            newAmount = accountService.deposit(amount);
            System.out.println("Your new balance is $" + newAmount + "\n");
            System.out.println("Would you like to: \n1)Return to profile \n2)Logout");
            userSelection = app().getConsole().readLine();
            switch(userSelection) {
                case "1":
                    app().getRouter().navigate("/user");
                    break;
                case "2":
                    app().getRouter().navigate("/home");
                    break;
                default:
                    System.out.println("Invalid selection");
            }


        } catch (NumberFormatException | InvalidRequestException | ResourcePersistentException e) {
            System.err.println("invalid input");
            app().getRouter().navigate("/user");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
