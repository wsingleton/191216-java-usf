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

        final UserRepository userRepo = null;
        final AccountRepository accountRepo = null;
        final TransactionRepository transactionRepo = null;

        final UserService userService = null;
        final AccountService accountService = null;
        final TransactionService transactionService = null;

        router = new ScreenRouter();
        router.addScreen(new HomeScreen());

        for(Screen screen : router.getScreens())
            System.out.println(screen.getName());

        System.out.println("[LOG] - Application initialization complete.");
    }

    public static void main(String[] args) {

        while(appRunning) {
            router.navigate("/home");
        }
    }
}
