package com.revature.bank2;

public class BankDriver {

    public static BankDriver app = new BankDriver();

    public static void main(String[] args) {
        while (app.isAppRunning()){
            app.getRouter().navigate("/home");
        }
    }

    public static BankDriver app() {
        return app;
    }
}
