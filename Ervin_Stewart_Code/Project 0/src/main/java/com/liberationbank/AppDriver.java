package com.liberationbank;

import com.liberationbank.models.Account;
import com.liberationbank.models.User;
import com.liberationbank.models.UserAccount;
import com.liberationbank.repos.AccountRepository;
import com.liberationbank.repos.UserRepository;
import com.liberationbank.screens.*;
import com.liberationbank.services.AccountService;
import com.liberationbank.services.UserService;
import com.liberationbank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {
    public static BufferedReader console;
    public static User currentUser;
    public static Account currentAccount;
    public static ScreenRouter router;
    public static boolean appRunning;
    public static UserAccount currentUserAccount;


    static{
        System.out.println("[LOG] - initializing application...");
        appRunning=true;
        console = new BufferedReader(new InputStreamReader(System.in));
        final UserRepository userRepo = new UserRepository();
        final AccountRepository accountRepo = new AccountRepository();

        final UserService userService = new UserService(userRepo);
        final AccountService accountService = new AccountService(accountRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService, accountService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashboardScreen(accountService))
                .addScreen(new UserProfileScreen())
                .addScreen(new WithdrawalScreen(accountService, accountRepo))
                .addScreen(new DepositScreen(accountService, accountRepo))
                .addScreen(new BalanceScreen());


        System.out.println("[LOG] - initializing complete");
    }


    public static void main(String[] args) {

        while(appRunning) {router.navigate("/home");}
    }
}
