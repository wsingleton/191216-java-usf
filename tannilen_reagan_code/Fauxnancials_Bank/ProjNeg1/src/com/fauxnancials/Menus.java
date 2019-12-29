package com.fauxnancials;

import com.fauxnancials.resources.User;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
    static Boolean valid;
    static int selection = 0;
    static Scanner scanner = new Scanner(System.in);

    public static int showLoginScreen() {
        do {
            System.out.println("Are you a new or returning user?");
            System.out.println("1. New");
            System.out.println("2. Existing");
            System.out.println("3. Cancel");
            try {
                selection = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("System exception: invalid input.");
                scanner.next();
            }
            if (selection != 1 && selection != 2 && selection != 3) {
                valid = false;
                System.out.println("I'm sorry, I didn't catch that.  Please select 1, 2, or 3.");
                System.out.println("");
            } else {
                valid = true;
            }
        } while (!valid);
        return selection;
    }

    public static User registerNew(ArrayList<User> knownAccts) {
        String username;
        String password;
        ArrayList<String> usernames = new ArrayList<>();
        for (User u : knownAccts) {
            usernames.add(u.getUsername());
        }
        System.out.println("Thank you for choosing Fauxnancials for your banking needs.");
        do {
            System.out.print("Please select a username for this account: ");
            username = scanner.next();
            if (username == null || username == "") {
                System.out.println("I'm sorry, but username may not be blank.");
                valid = false;
            } else {
                if (usernames.contains(username)) {
                    System.out.println("I'm sorry, but that username is taken.  Please choose another.");
                    valid = false;
                } else {
                    System.out.println("Thank you.  Your username is " + username);
                    valid = true;
                }
            }
        } while (!valid);
        do {
            System.out.println("Passwords must be at least 8 characters in length.");
            System.out.print("Please select a password: ");
            password = scanner.next();
            if (password == null || password == "") {
                System.out.println("I'm sorry, but a password is required.");
                valid = false;
            } else if (password.length() < 8) {
                System.out.println("That password is not long enough.  Please try again.");
                valid = false;
            } else {
                System.out.println("Please confirm your password.");
                String temp = scanner.next();
                if (!password.equals(temp)) {
                    System.out.println("I'm sorry, but your passwords do not match.");
                    valid = false;
                } else {
                    System.out.println("Thank you.  Your password has been set.");
                    System.out.println("For security reasons, please do not share your password.");
                    valid = true;
                }
            }
        } while (!valid);

        User u = new User(username, password);
        return u;
    }

    public static User loginScreen(ArrayList<User> userAccts, String username, String password) {
        int passHash;
        passHash = password.hashCode();
        User u = new User(username, passHash);
        if (userAccts.contains(u)) {
            System.out.println("Valid user ID.");
            return u;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    public static void browseAccount(User current, int balance) {
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
                    balance=makeDeposit(balance);
                    valid = true;
                    break;
                }
                case 'b': {
                    balance=makeWithdrawal(balance);
                    valid = true;
                    break;
                }
                case 'c': {
                    System.out.println("Goodbye!");
                    valid = true;
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
    private static int makeDeposit(int balance) {
        System.out.println("Your current account balance is $" + balance + ".00.");
        System.out.println("Deposits may be made in whole dollar increments and should not exceed $2000.00.");
        System.out.println("For deposits larger than $2000.00, please visit your local branch office.");
        do {
            System.out.println("How much will you be depositing today? (or input X to go back to the previous menu)");
            System.out.print("$");
            String depAmt = scanner.next();
            depAmt = depAmt.toLowerCase();
            if (depAmt.charAt(0) == 'x') {
                return balance;
            }
            if (depAmt.contains(".")){
                int i = depAmt.indexOf(".");
                depAmt=depAmt.substring(0,i);
            }
            try {
                int deposit=Integer.parseInt(depAmt);
                if (deposit<0) {
                    System.out.println("Negative values cannot be deposited.  Deposit not completed.");
                    valid=false;
                }
                else if (deposit>2000) {
                    System.out.println("Deposits of greater than $2000.00 must be handled by your local branch office.");
                    System.out.println("Deposit not completed.");
                    valid=false;
                }
                else {
                    balance+=deposit;
                    System.out.println("Thank you.  Your deposit of $"+deposit+".00 has been completed.");
                    System.out.println("Your new balance is $"+balance+".00.");
                    valid=true;
                    return balance;
                }

            } catch (Exception e) {
                System.out.println("I'm sorry, but that is not a valid input.");
                System.out.println(e.getMessage());
                valid=false;
            }
        } while (!valid);
        return balance;
    }
    private static int makeWithdrawal(int balance) {
        System.out.println("Your current account balance is $" + balance + ".00.");
        System.out.println("Withdrawals may be made in whole dollar increments.");
        do {
            System.out.println("How much will you be depositing today? (or input X to go back to the previous menu)");
            System.out.print("$");
            String wdAmt = scanner.next();
            wdAmt = wdAmt.toLowerCase();
            if (wdAmt.charAt(0) == 'x') {
                return balance;
            }
            if (wdAmt.contains(".")){
                int i = wdAmt.indexOf(".");
                wdAmt=wdAmt.substring(0,i);
            }
            try {
                int withdrawal=Integer.parseInt(wdAmt);
                if (withdrawal<0) {
                    System.out.println("Negative values cannot be withdrawn.  Withdrawal not completed.");
                    valid=false;
                }
                else if (withdrawal>balance) {
                    System.out.println("Accounts may not be overdrafted.");
                    System.out.println("Withdrawal not completed.");
                    valid=false;
                }
                else {
                    balance-=withdrawal;
                    System.out.println("Thank you.  Your withdrawal of $"+withdrawal+".00 has been completed.");
                    System.out.println("Your new balance is $"+balance+".00.");
                    valid=true;
                    return balance;
                }

            } catch (Exception e) {
                System.out.println("I'm sorry, but that is not a valid input.");
                System.out.println(e.getMessage());
                valid=false;
            }
        } while (!valid);
        return balance;
    }
}
