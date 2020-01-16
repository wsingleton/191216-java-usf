package com.revature.mockbank;

/*
Main method class to initiate the application
 */

import com.revature.mockbank.models.Account;
import com.revature.mockbank.models.TransactionHistory;
import com.revature.mockbank.models.User;
import com.revature.mockbank.repositories.AccountRepo;
import com.revature.mockbank.repositories.TransactionRepo;
import com.revature.mockbank.repositories.UserRepo;
import com.revature.mockbank.screens.*;
import com.revature.mockbank.services.AccountService;
import com.revature.mockbank.services.UserService;
import com.revature.mockbank.util.ConnectionFactory;
import com.revature.mockbank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class AppDriver {

    public static BufferedReader console;
    public static User currentUser;
    public int curentUserId;
    public static ArrayList<Integer> listOfAccounts = new ArrayList<>();
    public static Account currentAccount;
    public static Set<TransactionHistory> activityLog;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("Initializing application ........");
        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));
        final UserRepo userRepo = new UserRepo();

        final AccountRepo accountRepo = new AccountRepo();

        final UserService userService = new UserService(userRepo, accountRepo);
        final TransactionRepo transactionRepo = new TransactionRepo();

        final AccountService accountService = new AccountService(accountRepo, transactionRepo);

        router = new ScreenRouter();
        // screens will be added from here
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService)) // add user service as a parameter for register
                .addScreen(new LoginScreen(userService, accountService))
                .addScreen(new DashboardScreen())
                .addScreen(new CreateAccountScreen(accountService))
                .addScreen(new UserProfileScreen())
                .addScreen(new WithdrawScreen(accountService))
                .addScreen(new AccountHistoryScreen(accountService))
                .addScreen(new BalanceScreen(accountService))
                .addScreen(new DepositScreen(accountService));
    }

    public static void main (String[] args){
//
        while (appRunning) {
            router.navigate("/home");
        }
//        Connection con = ConnectionFactory.getInstance().getConnection();
//     if(con != null){
//         System.out.println("Connection established! You are good to go");
//     } else{
//         System.out.println("Ni za nduru! ");
//     }
    }
}
