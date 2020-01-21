package com.revature.util;

import com.revature.models.Accounts;
import com.revature.models.User;
import com.revature.models.UserAccount;
import com.revature.repos.AccountRepository;
import com.revature.repos.UserRepository;
import com.revature.screens.Dashboard;
import com.revature.screens.HomeScreen;
import com.revature.screens.LoginScreen;
import com.revature.screens.RegisterScreen;
import com.revature.services.AccountService;
import com.revature.services.UserService;

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
        final AccountRepository acctRepo = new AccountRepository();
        final UserService userService = new UserService(userRepo);
        final AccountService accountService = new AccountService(acctRepo);


        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService, accountService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new Dashboard(accountService));

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
