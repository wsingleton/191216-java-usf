package com.fauxnancials;

import com.fauxnancials.menus.Home;
import com.fauxnancials.menus.ScreenReader;
import com.fauxnancials.repos.AccountRepository;
import com.fauxnancials.repos.UserRepository;
import com.fauxnancials.util.Nav;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppMain {
    public static BufferedReader console;
    public static User currentUser;
    public static Nav router;
    public static boolean appRunning;
    static {
        System.out.println("[LOG] - Initializing application...");
        appRunning=true;
        console=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[LOG] - Generating repositories.");
        final UserRepository userRepo=new UserRepository();
        final AccountRepository acctRepo=new AccountRepository();
        System.out.println("[LOG] - Preparing application com.fauxnancials.services.");
        final UserServices userServices=new UserServices(userRepo);
        final AcctServices acctServices=new AcctServices(acctRepo);
        router=new Nav();
        router.addMenus(new ScreenReader()
                .new Home()
                .new Login()
                .new Register()
                .new Dashboard()
                .new Deposit()
                .new Withdraw());
        System.out.println("[LOG] - Initialization complete.");
    }
    public static void main(String[] args) {
        while (appRunning) {
            router.navigate("/main");
        }
    }
}
