package com.revature.project_0.util;

import com.revature.project_0.repos.AccountRepository;
import com.revature.project_0.repos.UserRepository;
import com.revature.project_0.screens.*;
import com.revature.project_0.services.AccountService;
import com.revature.project_0.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private UserSession currentSession;
    private ScreenRouter router;
    private boolean appRunning;

    public AppState() {

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final AccountRepository accRepo = new AccountRepository();

        final UserService userService = new UserService(userRepo);
        final AccountService accountService = new AccountService(accRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen())
                .addScreen(new LoginScreen())
                .addScreen(new UserProfileScreen())
                .addScreen(new DepositScreen())
                .addScreen(new WithdrawScreen());

    }

    public BufferedReader getConsole() {
        return console;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public UserSession getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(UserSession currentSession) {
        this.currentSession = currentSession;
    }

    public boolean isSessionValid() {
        return (this.currentSession != null);
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

}
