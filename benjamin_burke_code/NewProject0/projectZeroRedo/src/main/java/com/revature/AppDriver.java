package com.revature;

import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.AccountService;
import com.revature.services.UserService;
import com.revature.util.AppState;
import com.revature.util.ScreenRouter;
import com.revature.models.Accounts;
import com.revature.models.UserAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class AppDriver {

    private static AppState app = new AppState();

    public static void main(String[] args) throws IOException {

        while (app.isAppRunning()) {
            app.getRouter().navigate("/home");
        }

    }

    public static AppState app() {
        return app;
    }
}
