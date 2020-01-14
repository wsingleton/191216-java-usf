package com.revature.bank2;

public class BankDriver {

    public static AppState app = new AppState();

    public static void main(String[] args) {
        while (app.isAppRunning()){
            app.getRouter().navigate("/home");
        }
    }
}
