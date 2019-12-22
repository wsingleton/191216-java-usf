package com.revature;

import javax.net.ssl.SSLEngineResult;
import java.util.*;
import java.io.*;

public class Bank {
    public Hashtable<Integer, User> userBase = new Hashtable<Integer, User>();
    public Hashtable<Integer, Account> acctBase = new Hashtable<Integer, Account>();

    public void serializeUser() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("/Users/evanhsi/Documents" +
                    "/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/userBase.txt");
        }
        catch (IOException a) { System.out.println(a.getMessage()); }

        PrintWriter printWriter = new PrintWriter(fileWriter);
        userBase.forEach((Integer, User) -> printWriter.println(User.serialString()));
        printWriter.close();
    }

    public void serializeAcct() {

    }

    public int makeAcct(InputStream inputStream, User user) {
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

        return acctId;
    }

    public int makeUser(Scanner scanner, boolean file) {
        User user = new User();
        int id = 0;

        if(file) {
            id = scanner.nextInt();
            user.setId(id);
        }
        if(!file) { System.out.println("First Name: "); }
        user.setFirstName(scanner.next());

        if(!file) { System.out.println("Last Name: "); }
        user.setLastName(scanner.next());

        if(!file) { System.out.println("Username: "); }
        user.setUserName(scanner.next());

        if(!file) { System.out.println("Password: "); }
        user.setPassword(scanner.next());

        if(!file) { System.out.println("Role: "); }
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

        if(!file) {
            id = user.hashCode();
            user.setId(id);
        }

        userBase.put(id, user);
        return id;
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
