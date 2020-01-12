package com.revature;

import com.revature.models.AccountUser;
import com.revature.repos.AccountUserRepository;
import com.revature.repos.BalanceRepository;
import com.revature.services.AccountTypeService;
import com.revature.services.AccountUsersService;
import com.revature.util.ScreenRouter;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    public static BufferedReader console;
    public static AccountUser currentUser;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("[LOG] - Initializing application...");

        appRunning=true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final AccountUserRepository userRepo = new AccountUserRepository();
        final BalanceRepository accRepo = new BalanceRepository();

        final AccountUsersService userService = new AccountUsersService(userRepo);
//        final AccountTypeService accTypeService = new AccountTypeService(accRepo);


    }
    public static void main(String[] args) {




    }
}
