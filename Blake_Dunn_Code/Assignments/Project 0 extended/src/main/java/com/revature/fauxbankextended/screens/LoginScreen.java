package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.exceptions.AuthenticationException;
import com.revature.fauxbankextended.exceptions.InvalidRequestException;
import com.revature.fauxbankextended.models.User;
import com.revature.fauxbankextended.services.AccountService;
import com.revature.fauxbankextended.services.UserService;

import static com.revature.fauxbankextended.BankDriver.*;

public class LoginScreen extends Screen {

    private UserService userService;
    private AccountService accountService;

    public LoginScreen(UserService userService, AccountService accountService) {
        super("LoginScreen", "/login");
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void render() {

        String username;
        String password;

        try {
            System.out.println("\n\n");
            System.out.println("+-------  Sign-in  ------- +\n");
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();

            User user = userService.authenticate(username, password);
            accountService.chooseAccount(user);

            if (app().isSessionValid()) {
                System.out.println("Success!");
                app().getRouter().navigate("/dashboard");
            }

        }catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("Invalid login credentials provided!");
        }
        catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("Shutting down application");
            app().setAppRunning(false);
        }
    }
}