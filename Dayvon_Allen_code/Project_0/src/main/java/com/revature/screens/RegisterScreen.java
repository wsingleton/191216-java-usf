package com.revature.screens;
import com.revature.BankDriver;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.User;
import com.revature.services.UserService;
import static com.revature.BankDriver.*;

public class RegisterScreen extends Screen {
    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;
        int accountID;

        try{
            System.out.println("\n\n\n\n\n\n\n\n\n\n+------------------------------------+");
            System.out.println("Sign up for a new account");
            System.out.print("Username (all spaces will be stripped): ");
            username = console.nextLine();
            System.out.print("Password (Cannot use semicolons and all spaces will be stripped): ");
            password = console.nextLine();
            accountID = username.toLowerCase().hashCode();

            User newUser = new User(username.toLowerCase().replaceAll(" ", ""),password.replaceAll(" ", ""),accountID);
            userService.register(newUser);

            if (currentUser != null) {
                router.navigate("/customer");
            }
        } catch (InvalidRequestException | ResourcePersistentException E){
            System.out.println("-------------------------------");
            System.out.println("Invalid data or username is taken!");
            System.out.println("-------------------------------\n\n");
            router.navigate("/home");
        }
        catch (Exception e){
            System.err.println("Shutting down application...");
            BankDriver.appRunning = false;
        }    }
}
