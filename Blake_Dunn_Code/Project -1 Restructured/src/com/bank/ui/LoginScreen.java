package com.bank.ui;

import java.util.Scanner;

import static com.bank.dao.UserDao.checkLogin;

public class LoginScreen {

    public static void login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.print("Username: ");
        String un = scanner.next();
        System.out.println("");

        System.out.print("Password: ");
        String pw = scanner.next();

        checkLogin(un, pw);

    }
}
