package com.revature.mockbank.screens;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.exceptions.ResourcePersistenceException;
import com.revature.mockbank.models.Account;
import com.revature.mockbank.models.AccountAccess;
import com.revature.mockbank.models.AccountType;
import com.revature.mockbank.models.User;
import com.revature.mockbank.repositories.AccountRepo;
import com.revature.mockbank.screens.Screen;
import com.revature.mockbank.services.AccountService;
import com.revature.mockbank.services.UserService;

import static com.revature.mockbank.AppDriver.*;
import static com.revature.mockbank.AppDriver.appRunning;
import static com.revature.mockbank.repositories.UserRepo.registeredUser;

public class CreateAccountScreen extends Screen {

    private AccountService accountService;


    public CreateAccountScreen(AccountService accountService) {
        super("CreateAccountScreen", "/createAccount");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        try {

            Account accData = new Account(0, AccountType.CHECKING, AccountAccess.PERSONAL, 3);
           accountService.createAccount(accData);

            // set the current user to the user who just registered.
            //currentUser = registeredUser;
            currentAccount = AccountRepo.newAccount;

            if (currentUser != null) {
                System.out.println("New Account created. Navigating you to your profile .... ");
                System.out.println(currentAccount);
                router.navigate("/dashboard");
            }

        } catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}
