package com.revature.screens;

import com.revature.services.AccountService;

import static com.revature.AppDriver.*;


public class UserSelectionScreen extends Screen {
private AccountService accountService;
    public UserSelectionScreen(AccountService accountService) {
        super("UserSelectionScreen", "/select");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
    }


    @Override
    public void render() {

        accountService.retrieveUserAccount(currentUser);
        System.out.println("Welcome " + currentUser.getFirstName());
        String userInput;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("1) to deposit");
        System.out.println("2) to withdraw");
        System.out.println("3) to logout");

        try {
            userInput = console.readLine();

            switch(userInput) {

                case "1":
                    router.navigate("/deposit");
                    break;
                case "2":
                   router.navigate("/withdraw");
                    break;
                case "3":
                    router.navigate("/home");
                    break;
                default:
                    System.out.println("invalid selection");

            }
        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("Shutting down application");
            appRunning =false;
        }

    }
}
