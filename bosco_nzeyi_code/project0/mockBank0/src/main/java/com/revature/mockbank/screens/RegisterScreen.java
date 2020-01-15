package com.revature.mockbank.screens;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.exceptions.ResourcePersistenceException;
import com.revature.mockbank.models.User;
import com.revature.mockbank.services.UserService;
import static com.revature.mockbank.AppDriver.*;
import static com.revature.mockbank.repositories.UserRepo.*;
public class RegisterScreen extends Screen{



    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String username;
        String password;

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n+-----------------------+\n");
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = console.readLine();
            System.out.println("Last name: ");
            lastName = console.readLine();
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            User newUser = new User(0, firstName, lastName, username, password);
            userService.register(newUser);

            // set the current user to the user who just registered.
            currentUser = registeredUser;

            if (currentUser != null) {
                System.out.println("[LOG] - New user created. Login to continue...");
                System.out.println(currentUser.toString());
                router.navigate("/login");
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
