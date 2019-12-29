package com.revature;

import javax.net.ssl.SSLEngineResult;
import java.util.*;
import java.io.*;

public class Bank {
    private Hashtable<Integer, User> userBase = new Hashtable<Integer, User>();
    private Hashtable<Integer, Account> acctBase = new Hashtable<Integer, Account>();

    public Bank() {
    }

    public User userAt(int id) {
        return userBase.get(id);
    }

    public boolean userContains(String userName) {
        //System.out.println(Objects.hash(userName));
        return userBase.containsKey(Objects.hash(userName));
    }

    public Account accountAt(int id) {
        return acctBase.get(id);
    }

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
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("/Users/evanhsi/Documents" +
                    "/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/acctBase.txt");
        }
        catch (IOException a) { System.out.println(a.getMessage()); }

        PrintWriter printWriter = new PrintWriter(fileWriter);
        acctBase.forEach((Integer, Account) -> printWriter.println(Account.serialString()));
        printWriter.close();
    }

    public int makeAcct(Scanner scanner, User user, boolean file) {
        int acctId = 0;
        Account account = new Account();

        // acctid, balance, type, ownerId

        if(file) {
            acctId = scanner.nextInt();
            account.setActId(acctId);
        }
        if(file) {
            account.setBalance(scanner.nextDouble());
        }
        if(!file) { System.out.print("Select Account Type (CHECKING/SAVINGS)"); }
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
        if(file) {
            account.setOwnerID(scanner.nextInt());
        }
        else {
            account.setOwnerID(user.getId());
        }
        if(!file) {
            acctId = user.getUserName().hashCode()+user.getAccountsLength()+1;
            account.setActId(acctId);
        }
        acctBase.put(acctId, account);
        userBase.get(account.getOwnerID()).addAccount(account);

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
        boolean fn = false;
        while(!fn) {
            fn = user.setFirstName(scanner.next());
            if(!fn) System.out.println("First Name: ");
        }

        if(!file) { System.out.println("Last Name: "); }
        boolean ln = false;
        while(!ln) {
            ln = user.setLastName(scanner.next());
            if(!ln) System.out.println("Last Name: ");
        }

        if(!file) { System.out.println("Username: "); }
        boolean un = false;
        while(!un) {
            un = user.setUserName(scanner.next());
            if(!un) System.out.println("Username: ");
        }

        if(!file) { System.out.println("Password: "); }
        boolean pw = false;
        while(!pw) {
            pw = user.setPassword(scanner.next());
            if(!pw) System.out.println("Password: ");
        }

        if(file) {
            String roleString = scanner.next();
            switch (roleString) {
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
        }
        else { user.setRole(Role.MEMBER); }

        if(!file) {
            id = user.hashCode();
            user.setId(id);
        }

        if(userBase.contains(id)) {
            System.out.println("Username already exists");
            return -1;
        }

        userBase.put(id, user);
        return id;
    }

    public double makeDeposit(int accountId, double depositAmount) {
        if(depositAmount < 1) {
            System.out.println("Invalid deposit amount.");
            return 0;
        }
        acctBase.get(accountId).setBalance(acctBase.get(accountId).getBalance() + depositAmount);
        return acctBase.get(accountId).getBalance();
    }

    public double makeWithdrawal(int accountId, double withdrawalAmount) {
        if(withdrawalAmount < 1) {
            System.out.println("Invalid withdrawal amount.");
            return acctBase.get(accountId).getBalance();
        }
        if(withdrawalAmount > acctBase.get(accountId).getBalance()) {
            System.out.println("Insufficient Funds");
            return acctBase.get(accountId).getBalance();
        }
        acctBase.get(accountId).setBalance(acctBase.get(accountId).getBalance() - withdrawalAmount);
        return acctBase.get(accountId).getBalance();
    }

    public void listAccounts(int userId) {
        for( int i = 0; i < userBase.get(userId).getAccountsLength(); i++) {
            System.out.println("Account " + i + ": " + userBase.get(userId).getAccount(i).serialString());
        }
    }

    public void printAllUsers() {
        userBase.forEach((k,v) -> System.out.println(k + " / " + v.serialString()));
    }

    public void printAllAccounts() {
        acctBase.forEach((k,v) -> System.out.println(k + " / " + v.serialString()));
    }

}
