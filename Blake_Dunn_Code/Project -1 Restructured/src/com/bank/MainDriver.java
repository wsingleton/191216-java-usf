package com.bank;

import static com.bank.ui.LoginScreen.login;
import static com.bank.ui.MainScreen.homeScreen;
import static com.bank.ui.RegisterScreen.register;

public class MainDriver {

    public static void main(String[] args) {


        homeScreen();

        if (homeScreen() == 0){
            login();
        }
        else if(homeScreen() == 1){
            register();
        }

    }
}
