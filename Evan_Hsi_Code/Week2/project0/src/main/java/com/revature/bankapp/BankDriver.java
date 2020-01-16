package com.revature.bankapp;

import com.revature.bankapp.models.*;
import com.revature.bankapp.repositories.*;
import com.revature.bankapp.screens.*;
import com.revature.bankapp.services.*;
import com.revature.bankapp.util.*;
import java.io.*;

public class BankDriver {

    public static BufferedReader console;
    public static ScreenRouter router;
    public static boolean appRunning;
    public static User currentUser;
    public static int userid;

    static {
        System.out.println("[LOG] - Initializing application...");

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final UserService userService = new UserService(userRepo);

        final AccountRepository accountRepo = new AccountRepository();
        final AccountService accountService = new AccountService(accountRepo);

        final TransactionRepository transactionRepo = new TransactionRepository();
        final TransactionService transactionService = new TransactionService(transactionRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new LoginScreen(userService))
                .addScreen(new RegisterScreen(userService))
                .addScreen(new DashboardScreen(accountService))
                .addScreen(new TransactionScreen(transactionService, accountService))
                .addScreen(new AccountCreationScreen(accountService))
                .addScreen(new JointAccountCreationScreen(accountService))
                .addScreen(new AddUserScreen(accountService))
                .addScreen(new AccountScreen(accountService));

        for(Screen screen : router.getScreens())
            System.out.println(screen.getName());

        System.out.println("[LOG] - Application initialization complete.");
    }

    public static void main(String[] args) {
        System.out.println("password".hashCode());

        while(appRunning) {
            //userid = -1;
            //currentUser = null;
            router.navigate("/home");
        }
    }
}
