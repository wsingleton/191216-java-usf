package com.revature.fauxbankextended.util;

import com.revature.fauxbankextended.repos.AccountRepository;
import com.revature.fauxbankextended.repos.TransactionRepository;
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
        final TransactionRepository transRepo = new TransactionRepository();

        final UserService userService = new UserService(userRepo, acctRepo, transRepo);
        final AccountService accountService = new AccountService(acctRepo, transRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService, accountService))
                .addScreen(new DashboardScreen())
                .addScreen(new BalanceScreen(accountService))
                .addScreen(new DepositScreen(accountService))
                .addScreen(new WithdrawScreen(accountService))
                .addScreen(new TransitionScreen())
                .addScreen(new UserProfileScreen())
                .addScreen(new AddNewAccountScreen(userService))
                .addScreen(new TransactionHistoryScreen(userService))
                .addScreen(new TransferMoneyScreen(accountService))
                .addScreen(new SwitchAccountsScreen(accountService))
                .addScreen(new JointAccountScreen(userService));
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
