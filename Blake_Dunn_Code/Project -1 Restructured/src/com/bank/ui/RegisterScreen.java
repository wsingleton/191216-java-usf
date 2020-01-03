package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;

import java.util.Scanner;

import static com.bank.dao.AccountDao.writeToAccount;
import static com.bank.dao.UserDao.checkRegister;
import static com.bank.dao.UserDao.writeToUser;
import static com.bank.models.User.createId;
import static com.bank.service.AccountService.*;
import static com.bank.service.UserService.*;
import static com.bank.ui.MainScreen.display;


public class RegisterScreen {

    public static void register() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username (Must be at least 8 characters and no more than 14: " );
        String un = scanner.next();
        validateUserName(un);
        System.out.println("");
        System.out.print("Password (must contain a special character): " );
        String pw = scanner.next();
        validatePassword(pw);
        System.out.println("");
        System.out.print("First name: " );
        String fn = scanner.next();
        validateNames(fn);
        System.out.println("");
        System.out.print("Last name: " );
        String ln = scanner.next();
        validateNames(ln);
        System.out.println("");
        checkRegister(un);

        int newId = createId();

        User newUser = new User(newId, un, pw, fn, ln);
        System.out.println(newUser);

        writeToUser(newUser);

        System.out.println("Thank you!");
        System.out.print("Please enter the amount you'd like to deposit: ");
        double bal = scanner.nextDouble();
        bal = validateAmount(bal);

        Account newAcct = new Account(newId, bal);
        writeToAccount(newAcct);

        display(newAcct);

    }
}
