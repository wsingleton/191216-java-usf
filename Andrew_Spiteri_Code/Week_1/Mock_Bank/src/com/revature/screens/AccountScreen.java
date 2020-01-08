package com.revature.screens;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import static com.revature.MockBankDriver.*;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class AccountScreen extends Screen {
    private UserService userService;

    public AccountScreen(UserService userService) {
        super("AccountScreen", "/account");
        System.out.println("[LOG] - Instantiating "+super.getName());
        this.userService = userService;
    }

    //TODO instantiate account within account screen
    @Override
    public void render(){
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner scanner = new Scanner(System.in);
        UserRepository ur = new UserRepository();
        UserService us = new UserService(ur);
        AccountRepository ar = new AccountRepository();
        AccountService as = new AccountService(ar);
        Random rand = new Random();
        Set<Account> accountSet = as.getAccAmount(currentUser.getID());
        Account savingsAccount = new Account(0, AccountType.TEMP);
        Account checkingAccount = new Account(0, AccountType.TEMP);
        Account autoAccount = new Account(0, AccountType.TEMP);
        Account mortgageAccount = new Account(0, AccountType.TEMP);
        Double checkingAmount = 0.0, savingsAmount = 0.0, autoAmount = 0.0, mortgageAmount = 0.0;
        for (Account a:
             accountSet) {
            if(a.getAccountType().equals(AccountType.CHECKING)){
                checkingAccount = a;
                checkingAmount = a.getAccAmount();
            }else if (a.getAccountType().equals(AccountType.SAVINGS)){
                savingsAccount = a;
                savingsAmount = a.getAccAmount();
            }else if(a.getAccountType().equals(AccountType.AUTOLOAN)){
                autoAccount = a;
                autoAmount = a.getAccAmount();
            }else if (a.getAccountType().equals(AccountType.MORTGAGE)){
                mortgageAccount = a;
                mortgageAmount = a.getAccAmount();
            }
        }
        if(autoAccount.getAccountType().equals(AccountType.TEMP) && mortgageAccount.getAccountType().equals(AccountType.TEMP)) {
            System.out.println("Savings Account: " + df.format(savingsAmount));
            System.out.println("Checking Account: " + df.format(checkingAmount));
            System.out.println("Which account would you like to access?");

            System.out.println("Savings (1), Checking (2), Take out Auto Loan! (3), Take out a Mortgage! (4), or Exit (5)");
            String holder = scanner.next();
            if (holder.equals("1")) {
                System.out.println("The amount you have deposited in savings is: " + df.format(savingsAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(savingsAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(savingsAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            } else if (holder.equals("2")) {
                System.out.println("The amount you have deposited in checking is: " + df.format(checkingAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(checkingAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(checkingAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            }else if(holder.equals("3")){
                System.out.println("Wait while we check your credit score!");
                Integer creditScore =  UserService.checkCreditScore(currentUser.getID());
                System.out.println("Your credit score is: " + creditScore);
                try {
                    if(creditScore >= 650){
                        System.out.println("You are approved!");
                        System.out.print("How much would you like to borrow: ");
                        Double borrowAmount = scanner.nextDouble();
                        autoAccount.setAccountType(AccountType.AUTOLOAN);
                        if(as.createAccount(autoAccount, borrowAmount)){
                            System.out.println("You have successfully taken out your loan!");
                        }else{
                            System.out.println("Error processing transaction! Try again later.");
                            router.navigate("/account");
                        }
                    }else{
                        System.out.println("Your credit score isn't good enough to take out a loan.");
                    }
                    router.navigate("/account");
                } catch (Exception e) {
                    System.err.println("Invalid value!");
                    router.navigate("/account");
                }
            }else if(holder.equals("4")){
                System.out.println("Wait while we check your credit score!");
                Integer creditScore =  UserService.checkCreditScore(currentUser.getID());
                System.out.println("Your credit score is: " + creditScore);
                try {
                    if(creditScore >= 650){
                        System.out.println("You are approved!");
                        System.out.print("How much would you like to borrow: ");
                        Double borrowAmount = scanner.nextDouble();
                        mortgageAccount.setAccountType(AccountType.MORTGAGE);
                        if(as.createAccount(mortgageAccount, borrowAmount)){
                            System.out.println("You have successfully taken out your loan!");
                            router.navigate("/account");
                        }else{
                            System.out.println("Error processing transaction! Try again later.");
                            router.navigate("/account");
                        }
                    }else{
                        System.out.println("Your credit score isn't good enough to take out a loan.");
                    }
                    router.navigate("/account");
                } catch (Exception e) {
                    System.err.println("Invalid value!");
                    router.navigate("/account");
                }
            }else if(holder.equals("5")){
                System.exit(0);
            }else{
                System.out.println("Invalid input!");
                router.navigate("/account");
            }
        }else if(autoAccount.getAccountType().equals(AccountType.AUTOLOAN) && mortgageAccount.getAccountType().equals(AccountType.TEMP)){
            System.out.println("Savings Account: " + df.format(savingsAmount));
            System.out.println("Checking Account: " + df.format(checkingAmount));
            System.out.println("Auto Loan: " + df.format(autoAmount));
            System.out.println("Which account would you like to access?");

            System.out.println("Savings (1), Checking (2), Auto Loan (3), Take out a Mortgage! (4), or Exit (5)");
            String holder = scanner.next();
            if (holder.equals("1")) {
                System.out.println("The amount you have deposited in savings is: " + df.format(savingsAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(savingsAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(savingsAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            } else if (holder.equals("2")) {
                System.out.println("The amount you have deposited in savings is: " + df.format(checkingAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(checkingAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(checkingAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            }else if(holder.equals("3")){
                System.out.println("The amount of your auto loan is " + df.format(autoAmount));
                System.out.println("Would you like to make a payment?");
                System.out.println("Payment (1), Account Screen (2)");
                switch (scanner.next()){
                    case "1":
                        try {
                            System.out.println("How much would you like to pay?");
                            Double payment = scanner.nextDouble();
                            if(as.makePayment(autoAccount, payment)){
                                System.out.println("Payment successfully made!");
                                router.navigate("/account");
                            }else{
                                System.out.println("Error making payment!");
                                router.navigate("/account");
                            }
                        }catch (Exception e){
                            System.out.println("Invalid input!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        router.navigate("/account");
                        break;
                    default:
                        System.out.println("Invalid input!");
                        router.navigate("/account");
                        break;
                }
            }else if(holder.equals("4")){
                System.out.println("Wait while we check your credit score!");
                Integer creditScore =  UserService.checkCreditScore(currentUser.getID());
                System.out.println("Your credit score is: " + creditScore);
                try {
                    if(creditScore >= 650){
                        System.out.println("You are approved!");
                        System.out.print("How much would you like to borrow: ");
                        Double borrowAmount = scanner.nextDouble();
                        mortgageAccount.setAccountType(AccountType.MORTGAGE);
                        if(as.createAccount(mortgageAccount, borrowAmount)){
                            System.out.println("You have successfully taken out your loan!");
                            router.navigate("/account");
                        }else{
                            System.out.println("Error processing transaction! Try again later.");
                            router.navigate("/account");
                        }
                    }else{
                        System.out.println("Your credit score isn't good enough to take out a loan.");
                    }
                    router.navigate("/account");
                } catch (Exception e) {
                    System.err.println("Invalid value!");
                    router.navigate("/account");
                }
            }else if (holder.equals("5")){
                System.exit(0);
            }else{
                System.out.println("Invalid input!");
                router.navigate("/account");
            }
        }else if(autoAccount.getAccountType().equals(AccountType.TEMP) && mortgageAccount.getAccountType().equals(AccountType.MORTGAGE)){
            System.out.println("Savings Account: " + df.format(savingsAmount));
            System.out.println("Checking Account: " + df.format(checkingAmount));
            System.out.println("Mortgage: " + df.format(mortgageAmount));
            System.out.println("Which account would you like to access?");

            System.out.println("Savings (1), Checking (2), Mortgage (3), Take out an Auto Loan! (4), or Exit (5)");
            String holder = scanner.next();
            if (holder.equals("1")) {
                System.out.println("The amount you have deposited in savings is: " + df.format(savingsAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(savingsAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(savingsAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            } else if (holder.equals("2")) {
                System.out.println("The amount you have deposited in savings is: " + df.format(checkingAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(checkingAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(checkingAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            }else if(holder.equals("3")){
                System.out.println("The amount of your mortgage is " + df.format(mortgageAmount));
                System.out.println("Would you like to make a payment?");
                System.out.println("Payment (1), Account Screen (2)");
                switch (scanner.next()){
                    case "1":
                        try {
                            System.out.println("How much would you like to pay?");
                            Double payment = scanner.nextDouble();
                            if(as.makePayment(mortgageAccount, payment)){
                                System.out.println("Payment successfully made!");
                                router.navigate("/account");
                            }else{
                                System.out.println("Error making payment!");
                                router.navigate("/account");
                            }
                        }catch (Exception e){
                            System.out.println("Invalid Input!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        router.navigate("/account");
                        break;
                    default:
                        System.out.println("Invalid input!");
                        router.navigate("/account");
                        break;
                }
            }else if(holder.equals("4")){
                System.out.println("Wait while we check your credit score!");
                Integer creditScore =  UserService.checkCreditScore(currentUser.getID());
                System.out.println("Your credit score is: " + creditScore);
                try {
                    if(creditScore >= 650){
                        System.out.println("You are approved!");
                        System.out.print("How much would you like to borrow: ");
                        Double borrowAmount = scanner.nextDouble();
                        autoAccount.setAccountType(AccountType.AUTOLOAN);
                        if(as.createAccount(autoAccount, borrowAmount)){
                            System.out.println("You have successfully taken out your loan!");
                        }else{
                            System.out.println("Error processing transaction! Try again later.");
                            router.navigate("/account");
                        }
                    }else{
                        System.out.println("Your credit score isn't good enough to take out a loan.");
                    }
                    router.navigate("/account");
                } catch (Exception e) {
                    System.err.println("Invalid value!");
                    router.navigate("/account");
                }
            }else if (holder.equals("5")){
                System.exit(0);
            }else{
                System.out.println("Invalid input!");
                router.navigate("/account");
            }
        }else if(autoAccount.getAccountType().equals(AccountType.AUTOLOAN) && mortgageAccount.getAccountType().equals(AccountType.MORTGAGE)){
            System.out.println("Savings Account: " + df.format(savingsAmount));
            System.out.println("Checking Account: " + df.format(checkingAmount));
            System.out.println("Auto Loan: " + df.format(autoAmount));
            System.out.println("Mortgage: " + df.format(mortgageAmount));
            System.out.println("Which account would you like to access?");

            System.out.println("Savings (1), Checking (2), Mortgage (3), Auto Loan (4), or Exit (5)");
            String holder = scanner.next();
            if (holder.equals("1")) {
                System.out.println("The amount you have deposited in savings is: " + df.format(savingsAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(savingsAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(savingsAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            } else if (holder.equals("2")) {
                System.out.println("The amount you have deposited in savings is: " + df.format(checkingAmount));
                System.out.println("Would you like deposit (1), withdraw (2), or go to you account page (3)");
                switch (scanner.next()) {
                    case "1":
                        System.out.println("How much would you like to deposit?");
                        try {
                            Double deposit = scanner.nextDouble();
                            as.deposit(checkingAccount, deposit);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        System.out.println("How much would you like to withdraw?");
                        try {
                            Double withdrawal = scanner.nextDouble();
                            as.withdrawal(checkingAccount, withdrawal);
                            router.navigate("/account");
                        } catch (Exception e) {
                            System.err.println("Invalid value!");
                            router.navigate("/account");
                        }
                        break;
                    case "3":
                        router.navigate("/account");
                        break;
                    default:
                        System.err.println("Invalid input.");
                        router.navigate("/account");
                        break;
                }
            }else if(holder.equals("3")){
                System.out.println("The amount of your mortgage is " + df.format(mortgageAmount));
                System.out.println("Would you like to make a payment?");
                System.out.println("Payment (1), Account Screen (2)");
                switch (scanner.next()){
                    case "1":
                        try {
                            System.out.println("How much would you like to pay?");
                            Double payment = scanner.nextDouble();
                            if(as.makePayment(mortgageAccount, payment)){
                                System.out.println("Payment successfully made!");
                                router.navigate("/account");
                            }else{
                                System.out.println("Error making payment!");
                                router.navigate("/account");
                            }
                        }catch (Exception e){
                            System.out.println("Invalid Input!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        router.navigate("/account");
                        break;
                    default:
                        System.out.println("Invalid input!");
                        router.navigate("/account");
                        break;
                }
            }else if(holder.equals("4")){
                System.out.println("The amount of your auto loan is " + df.format(autoAmount));
                System.out.println("Would you like to make a payment?");
                System.out.println("Payment (1), Account Screen (2)");
                switch (scanner.next()){
                    case "1":
                        try {
                            System.out.println("How much would you like to pay?");
                            Double payment = scanner.nextDouble();
                            if(as.makePayment(autoAccount, payment)){
                                System.out.println("Payment successfully made!");
                                router.navigate("/account");
                            }else{
                                System.out.println("Error making payment!");
                                router.navigate("/account");
                            }
                        }catch (Exception e){
                            System.out.println("Invalid input!");
                            router.navigate("/account");
                        }
                        break;
                    case "2":
                        router.navigate("/account");
                        break;
                    default:
                        System.out.println("Invalid input!");
                        router.navigate("/account");
                        break;
                }
            }else if (holder.equals("5")){
                System.exit(0);
            }else{
                System.out.println("Invalid input!");
                router.navigate("/account");
            }
        }
    }
}
