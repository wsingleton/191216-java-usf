package com.fauxnancials;

import com.fauxnancials.resources.User;
import com.fauxnancials.services.DocumentationDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InterfaceDriver {
    static ArrayList<User> userList = new ArrayList<>(DocumentationDriver.CollectUsers());
    static HashMap<String, Integer> accountList=new HashMap<>(DocumentationDriver.CollectAccounts());
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean valid;
        int choice;
        User currentUser;
        int currentUserBalance;
        System.out.println("WARNING: Improperly exiting program may cause a loss of data.");
        System.out.println("Always exit the program properly to avoid data loss.");
        System.out.println("");
        do {
            System.out.print("Are you using a screen reader (y/n)? ");
            String ans=scanner.next();
            char first=ans.charAt(0);
            first=Character.toLowerCase(first);
            if (first=='y') {
                valid=true;
                showPlainTextGreeting();
            }
            else if (first=='n') {
                valid=true;
                showASCIIGreeting();
            }
            else {
                valid=false;
                System.out.println("I didn't catch that.  Please answer y or n.");
            }
        } while (!valid);
        mainMenu(scanner);
    }

    public static void mainMenu(Scanner scanner) {
        int choice;
        User currentUser;
        int currentUserBalance;
            choice = Menus.showLoginScreen();
            switch (choice) {
                case 1: {
                    User newUser = (Menus.registerNew(userList));
                    userList.add(newUser);
                    accountList.put(newUser.getUsername(), 0);
                    updateAll(userList, accountList);
                    mainMenu(scanner);
                    break;
                }
                case 2: {
                    System.out.println("Please enter your username.  Note that usernames are not case sensitive.");
                    String user = scanner.next();
                    user = user.toLowerCase();
                    System.out.println("Please enter your password.  Note that passwords ARE case sensitive.");
                    String pass = scanner.next();
                    currentUser = Menus.loginScreen(userList, user, pass);
                    if (currentUser == null) {
                        System.out.println("Please try again later.");
                        System.exit(0);
                    } else {
                        currentUserBalance = accountList.get(currentUser.getUsername());
                        browseAccount(currentUser, currentUserBalance);
                        break;
                    }
                }
                case 3: {
                    System.out.println("Goodbye!");
                    updateAll(userList, accountList);
                    System.exit(0);
                }
            }
    }

    public static void browseAccount(User current, int balance) {
        Scanner scanner=new Scanner(System.in);
        Boolean valid;
        System.out.println("Welcome back, " + current.getUsername() + "!");
        System.out.println("Your current account balance is $" + balance + ".00.");
        System.out.println("");
        do {
            System.out.println("What would you like to do?");
            System.out.println("a. Deposit funds");
            System.out.println("b. Make a withdrawal");
            System.out.println("c. Exit");
            String ans = scanner.next();
            char first = ans.charAt(0);
            first = Character.toLowerCase(first);
            switch (first) {
                case 'a': {
                    balance= Menus.makeDeposit(balance);
                    valid = true;
                    accountList.put(current.getUsername(),balance);
                    break;
                }
                case 'b': {
                    balance=Menus.makeWithdrawal(balance);
                    valid = true;
                    accountList.put(current.getUsername(),balance);
                    break;
                }
                case 'c': {
                    System.out.println("Goodbye!");
                    valid = true;
                    updateAll(userList,accountList);
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("I didn't catch that.  Please select a, b, or c.");
                    valid = false;
                }
            }
        } while (!valid);
        browseAccount(current, balance);
    }
    public static void updateAll(ArrayList<User> userList, HashMap<String, Integer> accountList) {
        DocumentationDriver.updateUsers(userList);
        DocumentationDriver.updateAccts(accountList);
    }
    public static void showPlainTextGreeting() {
        System.out.println("Welcome to Fauxnancials Bank!");
        System.out.println("");
    }
    public static void showASCIIGreeting() {
        System.out.println("#######                                                                            ######                       ");
        System.out.println("#         ##   #    # #    # #    #   ##   #    #  ####  #   ##   #       ####     #     #   ##   #    # #    # ");
        System.out.println("#        #  #  #    #  #  #  ##   #  #  #  ##   # #    # #  #  #  #      #         #     #  #  #  ##   # #   #  ");
        System.out.println("#####   #    # #    #   ##   # #  # #    # # #  # #      # #    # #       ####     ######  #    # # #  # ####   ");
        System.out.println("#       ###### #    #   ##   #  # # ###### #  # # #      # ###### #           #    #     # ###### #  # # #  #   ");
        System.out.println("#       #    # #    #  #  #  #   ## #    # #   ## #    # # #    # #      #    #    #     # #    # #   ## #   #  ");
        System.out.println("#       #    #  ####  #    # #    # #    # #    #  ####  # #    # ######  ####     ######  #    # #    # #    # ");
        System.out.println("");
    }
}
