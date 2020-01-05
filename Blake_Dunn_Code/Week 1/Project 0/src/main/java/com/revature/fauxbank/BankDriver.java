package com.revature.fauxbank;

import com.revature.fauxbank.models.Account;
import com.revature.fauxbank.models.User;
import com.revature.fauxbank.repos.AccountRepository;
import com.revature.fauxbank.repos.UserRepository;
import com.revature.fauxbank.services.AccountService;
import com.revature.fauxbank.services.UserService;
import com.revature.fauxbank.util.ScreenRouter;
import com.revature.fauxbank.screens.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankDriver {

    public static BufferedReader console;
    public static User currentUser;
    public static Account currentAccount;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("[LOG] - Initializing application...");

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final AccountRepository acctRepo = new AccountRepository();

        final UserService userService = new UserService(userRepo, acctRepo);
        final AccountService accountService = new AccountService(acctRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashboardScreen())
                .addScreen(new BalanceScreen(accountService))
                .addScreen(new DepositScreen(accountService))
                .addScreen(new WithdrawScreen(accountService));


        System.out.println("[LOG] - Application intializing complete.");
    }

    public static void main(String[] args) {

        while (appRunning) {
            router.navigate("/home");
        }

    }
}
