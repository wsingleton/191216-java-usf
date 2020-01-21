package com.revature.util;

import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.AccountUserRepository;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    public static BufferedReader console;
    private UserSession currentSession;
    public static ScreenRouter router;
    public static boolean appRunning;

    public AppState() {

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final AccountRepository accRepo = new AccountRepository();
        final AccountUserRepository auRepo = new AccountUserRepository();

        final AccountService accountService = new AccountService(accRepo, auRepo);
        final UserService userService = new UserService(userRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new LoginScreen(userService))
                .addScreen(new RegisterScreen(userService))
                .addScreen(new UserSelectionScreen("userSelection", "/select"))
                .addScreen(new DepositScreen(accountService));
//                .addScreen(new WithdrawScreen("withdrawScreen","/withdraw"));
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


