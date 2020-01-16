package com.revature.screens;

import com.revature.exceptions.InsufficientFundsException;
import com.revature.exceptions.InvalidEntryException;
import com.revature.repos.AccountRepository;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static com.revature.BankMain.*;

public class AccountScreen extends Screen {

    private AccountRepository accRepo;

    public AccountScreen(AccountRepository accRepo) {
        super("AccountScreen", "/account");
        this.accRepo = accRepo;
    }

    @Override
    public void load() {

        double moneyadd; double moneysub; double amount;

        System.out.println("Your current balance is " + currentUser.getBalance());
        System.out.println("Press 1) to make a deposit or 2) to make a withdraw");
        System.out.println("Press 3 to log out");

        try {

            String path = userInputs.readLine();

            switch (path) {
                case "1":

                    System.out.println("How much would you like to deposit?");
                    moneyadd = Double.parseDouble(userInputs.readLine());
                    BigDecimal bd = new BigDecimal(moneyadd).setScale(2, RoundingMode.HALF_UP);
                    amount = bd.doubleValue();
                    
                    if (amount < 0) {
                        System.err.println("Invalid Input");
                    } else {
                        currentUser.setBalance(amount + currentUser.getBalance());
                        accRepo.save(currentUser);
                    }

                    navigation.navigate("/account");
                    break;

                case "2":

                    System.out.println("How much would you like to withdraw");
                    moneysub = Double.parseDouble(userInputs.readLine());
                    BigDecimal dp = new BigDecimal(moneysub).setScale(2, RoundingMode.HALF_UP);
                    amount = dp.doubleValue();
                    if (amount > currentUser.getBalance() || amount < 0) {
                        System.err.println("Insufficient funds");
                    } else {
                        currentUser.setBalance(currentUser.getBalance() - amount);
                        accRepo.save(currentUser);

                    }
                    navigation.navigate("/account");
                    break;

                case "3":
                    System.out.println("Have a good day");
                    navigation.navigate("/home");
                default:
                    throw new InvalidEntryException();
            }
        } catch (InvalidEntryException | InsufficientFundsException e) {
            System.out.println("Your entry is invalid");

        } catch (IOException e ) {
            System.err.println("An unexpected problem occurred...proceeding to shutdown");
            appLaunched = false;
        }
    }
}
