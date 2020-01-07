package com.revature;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.UserRepository;
import com.revature.screens.*;
import com.revature.services.AccountService;
import com.revature.services.UserService;
import com.revature.util.ScreenRouter;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;


public class MockBankDriver {
    public static Scanner console;
    public  static ScreenRouter router;
    public static Boolean appRunning;
    public  static User currentUser;
    public static Set<Account> accountSet;

    static {
        System.out.println("[LOG] - Initializing application...");
        appRunning = true;
        console = new Scanner(System.in);

        final UserRepository userRepo = new UserRepository();
        final AccountRepository accountRepo = new AccountRepository();

        final UserService userService = new UserService(userRepo);
        final AccountService accountService = new AccountService(accountRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new AccountScreen(userService))
        .addScreen(new AdminScreen(userService));


        System.out.println("[LOG] - Application initializing complete.");
    }

    public static void main(String... args) throws IOException {
        router.navigate("/home");
    }
}
