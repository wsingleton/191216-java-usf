package com.revature;

import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.UserService;
import com.revature.util.ScreenRouter;

import java.util.Scanner;

public class BankDriver {

    public static Scanner console;
    public static User currentUser = new User();
    public static ScreenRouter router;
    public static Boolean appRunning;

    static {
        appRunning = true;
        console = new Scanner(System.in);
        final UserRepository userRepo = new UserRepository();
        final UserService userService = new UserService(userRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new CustomerPortalScreen("Customer Portal", "/customer"))
                .addScreen(new BalanceScreen("Balance Screen", "/balance"))
                .addScreen(new DepositScreen("Deposit Screen", "/deposit"))
                .addScreen(new WithdrawScreen("Withdraw Screen", "/withdraw"));
    }
    public static void main(String[] args) {
        while (appRunning){
            try {
                router.navigate("/home");
            }
            catch (Exception e){

            }
        }
    }

    public static User user() {
        return currentUser;
    }
}
