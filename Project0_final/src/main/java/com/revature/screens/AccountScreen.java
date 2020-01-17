package com.revature.screens;

import com.revature.exceptions.InsufficientFundsException;
import com.revature.exceptions.InvalidEntryException;
import com.revature.repos.AccountRepository;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.revature.BankMain.*;

public class AccountScreen extends Screen {

    private AccountRepository accRepo;

    public AccountScreen(AccountRepository accRepo) {
        super("AccountScreen", "/account");
        this.accRepo = accRepo;
    }

    @Override
    public void load() {

        double moneysub; double amount;

        System.out.println("Your current balance is " + currentUser.getBalance());
        System.out.println("Press 1) to make a deposit or 2) to make a withdraw");
        System.out.println("Press 3 to log out");

        try {

            String path = userInputs.readLine();

            switch (path) {
                case "1":
                    navigation.navigate("/deposit");
                    break;

                case "2":
                    navigation.navigate("/withdraw");
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
