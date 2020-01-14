package com.revature.fauxbankextended.util;

import com.revature.fauxbankextended.repos.AccountRepository;
import com.revature.fauxbankextended.repos.UserRepository;
import com.revature.fauxbankextended.screens.*;
import com.revature.fauxbankextended.services.AccountService;
import com.revature.fauxbankextended.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private ScreenRouter router;
    private UserSession currentSession;
    private boolean appRunning;


    public AppState() {

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
                .addScreen(new TransactionHistoryScreen())
                .addScreen(new TransferMoneyScreen())
                .addScreen(new SwitchAccountsScreen());
    }

    public BufferedReader getConsole() {
        return console;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

    public UserSession getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(UserSession currentSession) {
        this.currentSession = currentSession;
    }

    public void invalidateCurrentSession() {
        this.currentSession = null;
    }

    public boolean isSessionValid() {
        return (this.currentSession != null);
    }
}