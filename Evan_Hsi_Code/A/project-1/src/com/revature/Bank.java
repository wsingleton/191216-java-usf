package com.revature;

import java.util.*;
import java.io.*;

public class Bank {
    private Hashtable<Integer, User> userBase;
    private Hashtable<Integer, Account> acctBase;

    public void serializeUser() {
        userBase.get("username");
    }

    public void serializeAcct() {

    }

    public void makeAcct(InputStream inputStream, User user) {
        Account account = new Account();
        Scanner scanner = new Scanner(inputStream);
        int acctId = 0;

        // acctid, balance, type, ownerId

        if(!inputStream.equals(System.in)) {
            acctId = scanner.nextInt();
            account.setActId(acctId);
        }
        account.setBalance(scanner.nextInt());
        String typeString = scanner.next();
        switch (typeString) {
            case "CHECKING":
                account.setType(Type.CHECKING);
                break;
            case "SAVINGS":
                account.setType(Type.SAVINGS);
                break;
            default:
                break;
        }
        account.setOwnerID(user.getId());
        if(inputStream.equals(System.in)) {
            acctId = user.getUserName().hashCode()+user.getAccountsLength()+1;
            account.setActId(acctId);
        }
        acctBase.put(acctId, account);

    }

    public void makeUser(InputStream inputStream) {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        if(!inputStream.equals(System.in)) {
            id = scanner.nextInt();
            user.setId(id);
        }
        user.setFirstName(scanner.next());
        user.setLastName(scanner.next());
        user.setUserName(scanner.next());
        user.setPassword(scanner.next());
        String roleString = scanner.next();
        switch(roleString) {
            case "ADMIN":
                user.setRole(Role.ADMIN);
                break;
            case "DEV":
                user.setRole(Role.DEV);
                break;
            case "TESTER":
                user.setRole(Role.TESTER);
                break;
            case "MEMBER":
                user.setRole(Role.MEMBER);
                break;
            default:
                break;
        }
        if(inputStream.equals(System.in)) {
            id = user.getUserName().hashCode();
            user.setId(id);
        }

        userBase.put(id, user);
    }

    public int makeDeposit(int accountId, int depositAmount) {
        if(depositAmount < 1) {
            System.out.print("Invalid deposit amount.");
            return 0;
        }
        acctBase.get(accountId).setBalance(acctBase.get(accountId).getBalance() + depositAmount);
        return acctBase.get(accountId).getBalance();
    }

    public int makeWithdrawal(int accountId, int withdrawalAmount) {
        if(withdrawalAmount < 1) {
            System.out.print("Invalid withdrawal amount.");
            return 0;
        }
        acctBase.get(accountId).setBalance(acctBase.get(accountId).getBalance() - withdrawalAmount);
        return acctBase.get(accountId).getBalance();
    }

}
