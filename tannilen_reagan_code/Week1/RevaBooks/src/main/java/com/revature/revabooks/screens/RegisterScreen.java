package com.revature.revabooks.screens;


import com.revature.revabooks.AppDriver;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.User;
import com.revature.revabooks.services.UserService;

public class RegisterScreen extends Screen {
    private UserService userService;
    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + this.getName());
        this.userService=userService;
    }
    public void render() {
        String given;
        String family;
        String user;
        String pass;
        try {
            System.out.println("Thank you for choosing RevaBooks for your book-shopping needs.");
            System.out.println("Please input your given name.");
            System.out.print("> ");
            given=AppDriver.console.readLine();
            System.out.println("Please input your family name.");
            System.out.print("> ");
            family=AppDriver.console.readLine();
            System.out.println("Please select a username.");
            System.out.print("> ");
            user=AppDriver.console.readLine();
            System.out.println("Please input a secure password.");
            System.out.print("> ");
            pass=AppDriver.console.readLine();
            User tempUser=new User(given, family, user, pass);
            userService.register(tempUser);
            if (AppDriver.currentUser!=null) {
                System.out.println("[LOG] - Registration successful.  Redirecting to dahsboard.");
                AppDriver.router.navigate("/dashboard");
            }
        }
        catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful.");
            System.err.println("Invalid credentials provided or username unavailable.");
        }
        catch (Exception ex) {
            System.err.println("[ERROR] - An unexpected exception has occurred.");
            System.err.println("[LOG] - Exiting application.");
            AppDriver.appRunning=false;
        }
    }
}
