package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;
import com.fauxnancials.exceptions.InvalidRequestException;
import com.fauxnancials.exceptions.ResourcePersistenceException;
import com.fauxnancials.models.User;
import com.fauxnancials.services.UserService;

import static com.fauxnancials.util.AnsiColours.*;

public class RegisterMenu extends Menu {
    private UserService userService;
    public RegisterMenu(UserService userService) {
        super("Register", "/register");
        this.userService=userService;
    }
    @Override
    public void render() {
        String given;
        String family;
        String user;
        String pass;
        int passHash;
        try {
            System.out.println("Thank you for choosing Fauxnancials Bank for all your banking needs.");
            System.out.println("Please input your given name.");
            System.out.print("> ");
            given=AppDriver.console.readLine();
            System.out.println("Please input your family name.");
            System.out.print("> ");
            family=AppDriver.console.readLine();
            System.out.println("Please select a username.");
            System.out.print("> ");
            user=AppDriver.console.readLine();
            user=user.toLowerCase();
            System.out.println("Please input a secure password.");
            System.out.print("> ");
            pass=AppDriver.console.readLine();
            passHash=pass.hashCode();
            User tempUser=new User(user, passHash, given, family);
            userService.register(tempUser);
            if (AppDriver.currentUser!=null) {
                System.out.println(ANSI_BLUE + "Registration successful.  Redirecting to dahsboard." + ANSI_RESET);
                AppDriver.router.navigate("/dashboard");
            }
        }
        catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println(ANSI_RED+"Registration unsuccessful."+ANSI_RESET);
            System.err.println("Invalid credentials provided or username unavailable.");
        }
        catch (Exception ex) {
            System.err.println("[ERROR] - An unexpected exception has occurred.");
            System.err.println("[LOG] - Exiting application.");
            AppDriver.appRunning=false;
        }
    }
}
