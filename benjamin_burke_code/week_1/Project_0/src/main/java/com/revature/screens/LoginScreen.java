package com.revature.screens;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AccountUser;
import com.revature.services.AccountUsersService;
import static com.revature.AppDriver.

public class LoginScreen extends Screen {

    private AccountUsersService userService;

    public LoginScreen(AccountUsersService userService){
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating" + super.getName());
        this.userService = userService;
    }

    @Override
    public void render(){

        String username;
        String password;

        try {
            System.out.println("\n\n\n\n\n\n\n\n\n+-----------------------+\n");
            System.out.println("Give your login credentials");
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            AccountUsersService.authenticate(username, password);
        if (){
            System.out.println("[LOG] - Login successful, navigating to dashboard...");
            router.navigate("/dashboard");
        }

        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("[LOG] - Invalid login credentials provided!");
        } catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;

        }
    }

}
