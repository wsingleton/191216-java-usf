package com.revature.screens;

import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.io.IOException;
import java.util.Scanner;

import static com.revature.MockBankDriver.router;

public class RegisterScreen extends Screen {
    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        //System.out.println("[LOG] + Instantiating "+ super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        System.out.println("Welcome to the Registration Screen");
        System.out.println("Are you creating a joint account (0) for yes and (1) for no?");
        Scanner sc = new Scanner(System.in);
        String holder = sc.next();
        if(holder.equals("0")){
            try {
                System.out.print("User 1 First name: ");
                String firstname = sc.next();
                System.out.print("User 1 Last name: ");
                String lastname = sc.next();
                System.out.print(" User 1 Username: ");
                String username = sc.next();
                System.out.print("User 1 Password: ");
                String password = sc.next();

                Boolean createUser = UserService.registerUser(firstname, lastname, username, password, true);

                if (!createUser){
                    System.out.println("Error creating accounts!");
                    AccountService.checkingAccount = null;
                    AccountService.savingsAccount = null;
                    router.navigate("/home");
                }
                System.out.print("User 2 First name: ");
                firstname = sc.next();
                System.out.print("User 2 Last name: ");
                lastname = sc.next();
                System.out.print(" User 2 Username: ");
                username = sc.next();
                System.out.print("User 2 Password: ");
                password = sc.next();

                UserService.registerUser(firstname, lastname, username, password, false);
            }catch (Exception e){
                System.out.println("Invalid input.");
                AccountService.checkingAccount = null;
                AccountService.savingsAccount = null;
                router.navigate("/home");
            }
        }else if(holder.equals("1")) {
            try {
                System.out.print("First name: ");
                String firstname = sc.next();
                System.out.print("Last name: ");
                String lastname = sc.next();
                System.out.print("Username: ");
                String username = sc.next();
                System.out.print("Password: ");
                String password = sc.next();

                UserService.registerUser(firstname, lastname, username, password, false);
            } catch (Exception e) {
                System.out.println("Invalid input.");
                AccountService.checkingAccount = null;
                AccountService.savingsAccount = null;
                router.navigate("/home");
            }
        }else{
            System.out.println("Invalid input.");
            router.navigate("/home");
        }





    }
}
