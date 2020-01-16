package com.revature.bankapp.screens;

import com.revature.bankapp.exceptions.InvalidRequestException;
import com.revature.bankapp.exceptions.ResourcePersistenceException;
import com.revature.bankapp.models.User;
import com.revature.bankapp.services.UserService;
import static com.revature.bankapp.BankDriver.*;

public class RegisterScreen extends Screen {

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
            if(firstName == null || firstName.trim().equals("")) throw new InvalidRequestException();
            for(int i = 0; i < firstName.length(); i++) {
                if(!Character.isAlphabetic(firstName.charAt(i))) throw new InvalidRequestException();
            }
            System.out.print("Last name: ");
            lastName = console.readLine();
            if(lastName == null || lastName.trim().equals("")) throw new InvalidRequestException();
            for(int i = 0; i < lastName.length(); i++) {
                if(!Character.isAlphabetic(lastName.charAt(i))) throw new InvalidRequestException();
            }
            System.out.print("Username: ");
            username = console.readLine();
            if(username == null || username.trim().equals("")) throw new InvalidRequestException();
            for(int i = 0; i < username.length(); i++) {
                if(!Character.isAlphabetic(username.charAt(i)) && !(username.charAt(i) == '#')
                        && !(username.charAt(i) == '$') && !(username.charAt(i) == '%')
                        && !(username.charAt(i) == '@')) throw new InvalidRequestException();
            }
            System.out.print("Password: ");
            password = console.readLine();
            if(password == null || password.trim().equals("")) throw new InvalidRequestException();
            for(int i = 0; i < password.length(); i++) {
                if(!Character.isLetterOrDigit(password.charAt(i)) && !(password.charAt(i) == '#')
                        && !(password.charAt(i) == '$') && !(password.charAt(i) == '%')
                        && !(password.charAt(i) == '@')) throw new InvalidRequestException();
            }

            User newUser = new User(firstName, lastName, username, password);
            userService.register(newUser);

            if (currentUser != null) {
                System.out.println("[LOG] - New user created! Navigating to dashboard...");
                router.navigate("/dashboard");
            }

        } catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            //System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}
