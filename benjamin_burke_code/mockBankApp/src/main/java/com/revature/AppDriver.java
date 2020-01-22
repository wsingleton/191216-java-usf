package com.revature;

import com.revature.models.Account;
import com.revature.models.AccountUser;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.AccountService;

import com.revature.services.UserService;
import com.revature.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    public static BufferedReader console;
    public static Account cuurentAccount;
    public static User currentUser;

    public static ScreenRouter router;
    public static boolean appRunning;
    public static AccountUser currentAccountUser;

   static{
       System.out.println("[LOG] - initializing application...");

       appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final AccountRepository accRepo = new AccountRepository();
//        final AccountUserRepository auRepo = new AccountUserRepository();

//        final AccountUserService accountUserService = new AccountUserService(auRepo);
        final AccountService accountService = new AccountService(accRepo);
        final UserService userService = new UserService(userRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService, accountService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new UserSelectionScreen(accountService))
                .addScreen(new WithdrawScreen(accountService, accRepo))
                .addScreen(new DepositScreen(accountService, accRepo))
                .addScreen(new BalanceScreen());
    }



    public static void main(String[] args) {
       while (appRunning){router.navigate("/home");}

    }

}
