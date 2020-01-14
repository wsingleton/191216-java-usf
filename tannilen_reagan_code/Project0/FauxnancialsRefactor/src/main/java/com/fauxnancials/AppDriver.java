package com.fauxnancials;

import com.fauxnancials.menus.*;
import com.fauxnancials.models.User;
import com.fauxnancials.repos.AccountRepository;
import com.fauxnancials.repos.TransactionRepository;
import com.fauxnancials.repos.UserRepository;
import com.fauxnancials.services.AcctService;
import com.fauxnancials.services.UserService;
import com.fauxnancials.util.NavRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.fauxnancials.util.AnsiColours.ANSI_RED;
import static com.fauxnancials.util.AnsiColours.ANSI_RESET;

public class AppDriver {
    public static BufferedReader console;
    public static User currentUser;
    public static NavRouter router;
    public static boolean appRunning;
    public static boolean screenreader;
    static {
        appRunning=true;
        console=new BufferedReader(new InputStreamReader(System.in));
        final UserRepository userRepo=new UserRepository();
        final AccountRepository acctRepo=new AccountRepository();
        final TransactionRepository transRepo=new TransactionRepository();
        final UserService userService=new UserService(userRepo);
        final AcctService acctService=new AcctService(acctRepo);
        router=new NavRouter();
        router.addMenu(new HomeMenu())
                .addMenu(new LoginMenu(userService))
                .addMenu(new RegisterMenu(userService))
                .addMenu(new DashMenu(acctService))
                .addMenu(new AccountsMenu(acctService))
                .addMenu(new DepositsMenu(acctService))
                .addMenu(new WithdrawalsMenu(acctService))
                .addMenu(new TransfersMenu(acctService))
                .addMenu(new AcctServicesMenu(acctService));
    }
    public static void main(String[] args) {
        boolean shown=false;
        while(appRunning) {
            while (!shown) {
                System.out.println("WARNING: Improperly exiting program may cause a loss of data.");
                System.out.println("Always exit the program properly to avoid data loss.");
                System.out.println("");
                System.out.println("Are you using a screenreader? (y/n)");
                try {
                    System.out.print("> ");
                    String ans = AppDriver.console.readLine();
                    char first = ans.charAt(0);
                    first = Character.toLowerCase(first);
                    if (first == 'y') {
                        AppDriver.screenreader = true;
                    } else if (first == 'n') {
                        AppDriver.screenreader = false;
                    } else {
                        System.out.println("I didn't catch that.  Please answer y or n.");
                    }
                    AppDriver.router.navigate("/home");
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "An unexpected exception has occurred.");
                    System.out.println("Please try again later." + ANSI_RESET);
                    System.out.println("Closing application...");
                    AppDriver.appRunning = false;
                }
                shown = true;
            }
            while (shown && appRunning) {
                AppDriver.router.navigate("/home");
            }
        }
    }
}