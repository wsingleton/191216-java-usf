package com.revature.screens;

import com.revature.repos.AccountRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.revature.BankMain.*;
import static com.revature.BankMain.navigation;

public class Withdraw extends Screen {

    private AccountRepository accRepo;

    public Withdraw(AccountRepository accRepo) {
        super("WithdrawScreen", "/withdraw");
        this.accRepo = accRepo;
    }

    @Override
    public void load() {
        double moneysub; double amount;

        System.out.println("Your current balance is " + currentUser.getBalance());
        System.out.println("How much would you like to withdraw?");

        try {

            moneysub = Double.parseDouble(userInputs.readLine());
            BigDecimal bd = new BigDecimal(moneysub).setScale(2, RoundingMode.HALF_UP);
            amount = bd.doubleValue();

            if (amount < 0 || amount > currentUser.getBalance()) {
                System.err.println("Invalid Input");
            } else {
                currentUser.setBalance(currentUser.getBalance() - amount);
                accRepo.save(currentUser);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Would you like to perform another transaction?  (Yes/No)");

        try { String path = userInputs.readLine();

            switch (path) {

                case "Yes":
                    navigation.navigate("/account");
                    break;

                case "No":
                    System.out.println("Your current balance is " + currentUser.getBalance());
                    System.out.println("Have a good day!");
                    navigation.navigate("/home");
                    break;

                default:
                    System.err.println("Unrecognized entry...secure logout commencing");
                    navigation.navigate("/home");
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
