package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;
import com.fauxnancials.exceptions.AuthenticationException;
import com.fauxnancials.exceptions.InvalidRequestException;
import com.fauxnancials.services.UserService;

import static com.fauxnancials.util.AnsiColours.*;

public class LoginMenu extends Menu {
    private UserService userService;
    public LoginMenu(UserService userService) {
        super("Login", "/login");
        this.userService=userService;
    }
    @Override
    public void render() {
        String username;
        String password;
        int passHash;
        try {
            System.out.println("\n");
            System.out.println("Please provide your login credentials.");
            System.out.println("Username:");
            System.out.print("> ");
            username= AppDriver.console.readLine();
            username=username.toLowerCase();
            System.out.println("Password:");
            System.out.print("> ");
            password=AppDriver.console.readLine();
            passHash=password.hashCode();
            userService.authenticate(username,passHash);
            if (AppDriver.currentUser!=null) {
                System.out.println(ANSI_BLUE + "Login successful.  Proceeding to dashboard." + ANSI_RESET);
                AppDriver.router.navigate("/dashboard");
            }

        }
        catch (InvalidRequestException | AuthenticationException e) {
            System.out.println(ANSI_RED + "Invalid login credentials provided." + ANSI_RESET);
        }
        catch (Exception ex) {
            System.err.println(ANSI_RED + "An unexpected exception has occurred.");
            System.err.println("Exiting application." + ANSI_RESET);
            AppDriver.appRunning=false;
        }
    }
}
