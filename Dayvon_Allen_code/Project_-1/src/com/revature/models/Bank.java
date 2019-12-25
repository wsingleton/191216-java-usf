package com.revature.models;

import com.revature.MenuDriver;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;


public class Bank {
    private User u;
    private String input = "";
    private String loginInput = "";
    private String registerInput = "";
    private String mainInput = "";
    private String username;
    private String password;
    private String exitInput;
    private String withdrawAmount = "0";
    private String depositAmount = "0";

    public void start() {
        OUTER:
        while(input.intern() != "3") {
            //resets register input and login input, if not there will be a bug
            registerInput = "";
            loginInput = "";
            mainInput = "";
            //main menu
            MenuDriver.showMainMenu();
            //capture input for main menu
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            //checks if input is 1, if it is then it puts user into the login menu
            if( input.intern() == "1"){
                //loops to keep user in login menu
                while(loginInput.intern() != "q"){
                    loginInput = "";
                    //captures input for username
                    Scanner scanner1 = new Scanner(System.in);
                    MenuDriver.usernamePrompt();
                    loginInput = scanner1.nextLine();
                    username = loginInput.replaceAll("\\s", "").toLowerCase();
                    //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                    loginInput = loginInput.toLowerCase().replaceAll("\\s", "");;
                    if(username.equals("")) {
                        System.out.println("+----------------------------------+");
                        System.out.println("\n\nUsername is required!\n\n");
                    }
                    if( loginInput.length() > 0) {
                        //Checks if a username was input or if the user pressed "q" to quit
                        if (loginInput.intern() != "q") {
                            MenuDriver.passwordPrompt();
                            //captures input for password
                            loginInput = scanner1.nextLine();
                            password = loginInput.replaceAll("\\s", "");
                            //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                            loginInput = loginInput.toLowerCase();
                           //checks if there was input for the password
                            if(password.equals("")){
                                //Prints invalid credentials
                                MenuDriver.invalidCredential();
                                //continues to next iteration
                                continue;
                            }
                            if(loginInput.length() > 0) {
                                if (loginInput.intern() != "q") {
                                    //checks if the username and password matches
                                    if(MenuDriver.usernameExists(username) && MenuDriver.passwordMatches(password)) {
                                        //use conditional to check before you allow user to customer portal
                                        while (mainInput.intern() != "q") {
                                            exitInput = "";
                                            mainInput = "";
                                            MenuDriver.showCustomerPortal();
                                            Scanner scanner2 = new Scanner(System.in);
                                            System.out.print("Input: ");
                                            mainInput = scanner2.nextLine();
                                            if(mainInput.equals("3")){
                                                while (exitInput != "q") {
                                                    System.out.println("+----------------------------------+");
                                                    System.out.println("Type q or Q to return to customer portal(Press 3 to close the application)");
                                                    System.out.println("Your available balance is $" + MenuDriver.showBalance(username));
                                                    System.out.println("+----------------------------------+");
                                                    System.out.print("\nInput: ");
                                                    exitInput = scanner2.nextLine();
                                                    exitInput = exitInput.toLowerCase();
                                                    if(exitInput.equals("3")){
                                                        System.out.println(username + " has been logged out successfully!");
                                                        break OUTER;
                                                    }
                                                    else if(exitInput.equals("q")){
                                                        break;
                                                    }
                                                }
                                            }
                                            else if(mainInput.equals("2")){
                                                while (exitInput != "q"){
                                                    System.out.println("+----------------------------------+");
                                                    System.out.println("Please enter withdraw amount(Type q or Q to return to customer portal press 3 to close the application)");
                                                    System.out.print("Input: ");
                                                    exitInput = scanner2.nextLine();
                                                    exitInput = exitInput.toLowerCase();
                                                    withdrawAmount = exitInput;
                                                    System.out.println("+----------------------------------+");
                                                    if(exitInput.equals("3")){
                                                        System.out.println(username + " has been logged out successfully!");
                                                        break OUTER;
                                                    }
                                                    else if(exitInput.equals("q")){
                                                        break;
                                                    }
                                                    else if(Integer.parseInt(MenuDriver.showBalance(username)) < Integer.parseInt(withdrawAmount)){
                                                        System.out.println("Insufficient funds");
                                                        continue ;
                                                    }
                                                    else if(Integer.parseInt(MenuDriver.showBalance(username)) >= Integer.parseInt(withdrawAmount)){
                                                        int newBalanceCalcu = Integer.parseInt(MenuDriver.showBalance(username)) - Integer.parseInt(withdrawAmount);
                                                        String newBalance = Integer.toString(newBalanceCalcu);
                                                        MenuDriver.withdrawHelper(username,password,MenuDriver.showBalance(username),newBalance);
                                                        System.out.println("Your new balance is $" + MenuDriver.showBalance(username));
                                                    }
                                                }

                                            }
                                            else if(mainInput.equals("1")){
                                                while (exitInput != "q"){
                                                    System.out.println("+----------------------------------+");
                                                    System.out.println("Please enter withdraw amount(Type q or Q to return to customer portal press 3 to close the application)");
                                                    System.out.print("Input: ");
                                                    exitInput = scanner2.nextLine();
                                                    exitInput = exitInput.toLowerCase();
                                                    withdrawAmount = exitInput;
                                                    System.out.println("+----------------------------------+");
                                                    if(exitInput.equals("3")){
                                                        System.out.println(username + " has been logged out successfully!");
                                                        break OUTER;
                                                    }
                                                    else if(exitInput.equals("q")){
                                                        break;
                                                    }
                                                        int newBalanceCalcu = Integer.parseInt(MenuDriver.showBalance(username)) + Integer.parseInt(withdrawAmount);
                                                        String newBalance = Integer.toString(newBalanceCalcu);
                                                        MenuDriver.withdrawHelper(username,password,MenuDriver.showBalance(username),newBalance);
                                                        System.out.println("Your new balance is $" + MenuDriver.showBalance(username));

                                                }
                                        }}
                                    }
                                    else{
                                        //Prints invalid credentials
                                       MenuDriver.invalidCredential();
                                        //continues to next iteration
                                        continue;
                                    }
                                    break;
                                }
                            }

                        }
                    }
                }
            }
            //checks if input is 2 then it puts user into the register menu
            else if (input.intern() == "2") {
                //loops to keep user in login menu
                while(registerInput.intern() != "q"){
                    MenuDriver.usernamePrompt();
                    //captures input for username
                    Scanner scanner1 = new Scanner(System.in);
                    registerInput = scanner1.nextLine();
                    //strips whitespace
                    username = registerInput.replaceAll("//s", "").toLowerCase();;
                    //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                    registerInput = registerInput.toLowerCase();
                    if(registerInput.intern() != "q") {
                        MenuDriver.passwordPrompt();
                        //captures input for password
                        registerInput = scanner1.nextLine();
                        password = registerInput.replaceAll("//s", "");;
                        //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                        registerInput = registerInput.toLowerCase();
                    }
                    File writeFile = new File("src/com/revature/resources/users.txt");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))) {
                        String newUser = "\n" + username + " " + password + " " + "0";
                        writer.write(newUser);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }

        }
    }

    //boilerplate default stuff
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(u, bank.u);
    }

    @Override
    public int hashCode() {
        return Objects.hash(u);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "u=" + u +
                '}';
    }
}
