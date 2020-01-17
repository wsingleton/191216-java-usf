package com.revature.screens;

import com.revature.repos.AccountRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.revature.BankMain.*;

public class Deposit extends Screen{

    private AccountRepository accRepo;

    public Deposit(AccountRepository accRepo) {
        super("DepositScreen", "/deposit");
        this.accRepo = accRepo;
    }

    @Override
    public void load() {

        double moneyadd; double amount;

        System.out.println("Your current balance is " + currentUser.getBalance());
        System.out.println("How much would you like to deposit?");

        try {

            moneyadd = Double.parseDouble(userInputs.readLine());
            BigDecimal bd = new BigDecimal(moneyadd).setScale(2, RoundingMode.HALF_UP);
            amount = bd.doubleValue();

            if (amount < 0) {
                System.err.println("Invalid Input");
            } else {
                currentUser.setBalance(amount + currentUser.getBalance());
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
