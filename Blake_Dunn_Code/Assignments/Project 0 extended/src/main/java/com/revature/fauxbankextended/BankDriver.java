package com.revature.fauxbankextended;

import com.revature.fauxbankextended.models.*;
import com.revature.fauxbankextended.repos.*;
import com.revature.fauxbankextended.screens.*;
import com.revature.fauxbankextended.services.*;
import com.revature.fauxbankextended.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankDriver {

    public static BufferedReader console;
    public static User currentUser;
    public static Account currentAccount;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {

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
                .addScreen(new WithdrawScreen(accountService))
                .addScreen(new TransitionScreen())
                .addScreen(new AccountInfoScreen())
                .addScreen(new AddNewAccountScreen())
                .addScreen(new TransactionScreen())
                .addScreen(new TransferMoneyScreen());

    }

    public static void main(String[] args) {

        while (appRunning) {
            router.navigate("/home");
        }

    }
}
