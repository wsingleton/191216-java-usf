package com.revature.models;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;


public class Bank {
    //fields that are needed for the bank app
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
            Helper.showMainMenu();
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
                    Helper.usernamePrompt();
                    loginInput = scanner1.nextLine();
                    username = loginInput.replaceAll("\\s", "").toLowerCase();
                    //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                    loginInput = loginInput.toLowerCase().replaceAll("\\s", "");;
                    if(username.equals("")) {
                        System.out.println("+----------------------------------+");
                        System.out.println("\n\nUsername is required!\n\n");
                    }
                    if(loginInput.length() > 0) {
                        //Checks if a username was input or if the user pressed "q" to quit
                        if (loginInput.intern() != "q") {
                            Helper.passwordPrompt();
                            //captures input for password
                            loginInput = scanner1.nextLine();
                            password = loginInput.replaceAll("\\s", "");
                            //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                            loginInput = loginInput.toLowerCase();
                           //checks if there was input for the password
                            if(password.equals("")){
                                //Prints invalid credentials
                                Helper.invalidCredential();
                                //continues to next iteration
                                continue;
                            }
                            if(loginInput.length() > 0) {
                                if (loginInput.intern() != "q") {
                                    //checks if the username and password matches
                                    if(Helper.usernameExists(username) && Helper.passwordMatches(password)) {
                                        //use conditional to check before you allow user to customer portal
                                        while (mainInput.intern() != "q") {
                                            //Getting rid of past user input(can cause bugs if you don't empty out the fields)
                                            exitInput = "";
                                            mainInput = "";
                                            //show customer portals
                                            Helper.showCustomerPortal();
                                            Scanner scanner2 = new Scanner(System.in);
                                            System.out.print("Input: ");
                                            mainInput = scanner2.nextLine();
                                            //checks if the user is trying to check their balance
                                            if(mainInput.equals("3")){
                                                //checks if the user is trying to exit to the portal
                                                while (exitInput != "q") {
                                                    System.out.println("+----------------------------------+");
                                                    System.out.println("Type q or Q to return to customer portal(Press 3 to close the application)");
                                                    System.out.println("Your available balance is $" + Helper.showBalance(username));
                                                    System.out.println("+----------------------------------+");
                                                    System.out.print("\nInput: ");
                                                    exitInput = scanner2.nextLine();
                                                    //makes string lowercase to check whether user wants to exit or not.
                                                    exitInput = exitInput.toLowerCase();
                                                    if(exitInput.equals("3")){
                                                        System.out.println(username + " has been logged out successfully!");
                                                        //breaks from the highest while loop
                                                        break OUTER;
                                                    }
                                                    //checks if user is trying to exit.
                                                    else if(exitInput.equals("q")){
                                                        break;
                                                    }
                                                }
                                            }
                                            //checks to see if the user wants to deposit money
                                            else if(mainInput.equals("2")){
                                                while (exitInput != "q"){
                                                    System.out.println("+----------------------------------+");
                                                    System.out.println("Please enter withdraw amount(Type q or Q to return to customer portal press 3 to close the application)");
                                                    System.out.print("Input: ");
                                                    exitInput = scanner2.nextLine();
                                                    exitInput = exitInput.toLowerCase();
                                                    withdrawAmount = exitInput;
                                                    System.out.println("+----------------------------------+");
                                                    //breaks out the whole loop
                                                    if(exitInput.equals("3")){
                                                        System.out.println(username + " has been logged out successfully!");
                                                        break OUTER;
                                                    }
                                                    else if(exitInput.equals("q")){
                                                        break;
                                                    }
                                                    //makes sure that the input can only be numbers
                                                    else if(!exitInput.matches("^[1-9]\\d*(\\.\\d+)?$")){
                                                        System.out.println("Must contain only digits and decimals!");
                                                        continue ;
                                                    }
                                                    //Checks if you have enough money to withdraw
                                                    else if(Double.parseDouble(Helper.showBalance(username)) < Double.parseDouble(withdrawAmount)){
                                                        System.out.println("Insufficient funds");
                                                        continue ;
                                                    }
                                                    //subtract the withdraw amount from your balance
                                                    else if(Double.parseDouble(Helper.showBalance(username)) >= Double.parseDouble(withdrawAmount)){
                                                        double newBalanceCalcu = Double.parseDouble(Helper.showBalance(username)) - Double.parseDouble(withdrawAmount);
                                                        String newBalance = Double.toString(newBalanceCalcu);
                                                        Helper.transactionHelper(username,password, Helper.showBalance(username),newBalance);
                                                        //prints new balance
                                                        System.out.println("Your new balance is $" + Helper.showBalance(username));
                                                    }
                                                }
                                            }
                                            //checks if the user wants to deposit
                                            else if(mainInput.equals("1")){
                                                while (exitInput != "q"){
                                                    System.out.println("+----------------------------------+");
                                                    System.out.println("Please enter deposit amount(Type q or Q to return to customer portal press 3 to close the application)");
                                                    System.out.print("Input: ");
                                                    exitInput = scanner2.nextLine();
                                                    exitInput = exitInput.toLowerCase();
                                                    //uses user input for the deposit amount
                                                    depositAmount = exitInput;
                                                    System.out.println("+----------------------------------+");
                                                    //Logs user out and closes the whole app
                                                    if(exitInput.equals("3")){
                                                        System.out.println(username + " has been logged out successfully!");
                                                        break OUTER;
                                                    }
                                                    else if(exitInput.equals("q")){
                                                        break;
                                                    }
                                                    //makes sure only digits can be input
                                                    else if(!exitInput.matches("^[1-9]\\d*(\\.\\d+)?$")){
                                                        System.out.println("Must contain only digits and decimals!");
                                                        //continues to the next iteration
                                                        continue ;
                                                    }
                                                    //adds the deposit amount to the balance
                                                        double newBalanceCalcu = Double.parseDouble(Helper.showBalance(username)) + Double.parseDouble(depositAmount);
                                                        String newBalance = Double.toString(newBalanceCalcu);
                                                        Helper.transactionHelper(username,password, Helper.showBalance(username),newBalance);
                                                        //prints the new balance
                                                        System.out.println("Your new balance is $" + Helper.showBalance(username));
                                                }
                                        }}
                                    }
                                    else{
                                        //Prints invalid credentials
                                       Helper.invalidCredential();
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
                    Helper.usernamePrompt();
                    //captures input for username
                    Scanner scanner1 = new Scanner(System.in);
                    registerInput = scanner1.nextLine();
                    //strips whitespace
                    username = registerInput.replaceAll("//s", "").toLowerCase();
                    if(username.equals("")){
                        System.out.println("---------------------------------");
                        System.out.println("Please enter a valid username!");
                        System.out.println("---------------------------------\n\n\n");
                        continue ;
                    }
                    //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                    registerInput = registerInput.toLowerCase();
                    if(registerInput.intern() != "q") {
                        Helper.passwordPrompt();
                        //captures input for password
                        registerInput = scanner1.nextLine();
                        password = registerInput.replaceAll("//s", "");;
                        if(password.equals("")){
                            System.out.println("---------------------------------");
                            System.out.println("Please enter a valid password!");
                            System.out.println("---------------------------------\n\n\n");
                            continue ;
                        }
                        //converts input to lowercase to check if the user wants to quit(user might type Q instead of q)
                        registerInput = registerInput.toLowerCase();
                    }
                    if (Helper.usernameExists(username)){
                        System.out.println("Username is taken");
                        continue ;
                    }
                    //writes the users info to the users file
                    File writeFile = new File("src/com/revature/resources/users.txt");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))) {
                        String newUser =  username + " " + password + " " + "0" + "\n";
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
        return Objects.equals(input, bank.input) &&
                Objects.equals(loginInput, bank.loginInput) &&
                Objects.equals(registerInput, bank.registerInput) &&
                Objects.equals(mainInput, bank.mainInput) &&
                Objects.equals(username, bank.username) &&
                Objects.equals(password, bank.password) &&
                Objects.equals(exitInput, bank.exitInput) &&
                Objects.equals(withdrawAmount, bank.withdrawAmount) &&
                Objects.equals(depositAmount, bank.depositAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, loginInput, registerInput, mainInput, username, password, exitInput, withdrawAmount, depositAmount);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "input='" + input + '\'' +
                ", loginInput='" + loginInput + '\'' +
                ", registerInput='" + registerInput + '\'' +
                ", mainInput='" + mainInput + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", exitInput='" + exitInput + '\'' +
                ", withdrawAmount='" + withdrawAmount + '\'' +
                ", depositAmount='" + depositAmount + '\'' +
                '}';
    }
}
