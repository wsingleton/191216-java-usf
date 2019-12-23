package com.revature;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Scanner;

public class BankDriver {

    public static void main(String[] args) {

        Bank bank = new Bank();

        //Testing reading from file to makeUser();
/*
        String path = "/Users/evanhsi/Documents/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/userBase.txt";
        File file = new File(path);
        Scanner scanner = null;
        try {scanner = new Scanner(file); } catch (FileNotFoundException fnf) { System.out.println("File not Found"); }

        while(scanner.hasNext()) {
            bank.makeUser(scanner, true);
        }

        bank.userBase.forEach((k,v)->System.out.println(v.serialString()));
*/
        //Testing output format to console
/*
        System.out.println("Testing serialString() method: ");
        User user = new User("Evan", "Hsi", "evanhsi", "12345", Role.ADMIN);
        bank.userBase.put(user.getId(), user);
        System.out.println(user.serialString());
 */

        //Testing reading in a user from console + lookup in the database
        /*
        int testId1;
        testId1 = bank.makeUser(new Scanner(System.in), false);
        //System.out.println("Exited makeUser()");

        User user1 = bank.userBase.get(testId1);
        System.out.println(user1.serialString());

        //testing writing users to file
        bank.serializeUser();

         */


        String path = "/Users/evanhsi/Documents/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/acctBase.txt";
        File file = new File(path);
        Scanner acctScan = null;
        try {acctScan = new Scanner(file); } catch (FileNotFoundException fnf) { System.out.println("File not Found"); }

        String path2 = "/Users/evanhsi/Documents/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/userBase.txt";
        File file2 = new File(path2);
        Scanner userScan = null;
        try {userScan = new Scanner(file2); } catch (FileNotFoundException fnf) { System.out.println("File not Found"); }

        int acctTest = bank.makeUser(userScan, true);
        int acctId = bank.makeAcct(acctScan, bank.userBase.get(acctTest), true);
        bank.acctBase.get(acctId).setBalance(0);
        System.out.println(bank.makeDeposit(acctId, 100.00));
        System.out.println(bank.makeWithdrawal(acctId, 30.00));
        System.out.println(bank.makeWithdrawal(acctId, 90));
        System.out.println("The account stored in acctBase");
        System.out.println(bank.acctBase.get(acctId).serialString());
        System.out.println("The user this account belongs to");
        System.out.println(bank.userBase.get(bank.acctBase.get(acctId).getOwnerID()).serialString());
        System.out.println("The account inside the user's account List");
        for(int i = 0; i < bank.userBase.get(bank.acctBase.get(acctId).getOwnerID()).getAccountsLength(); i++) {
            System.out.println(bank.userBase.get(bank.acctBase.get(acctId).getOwnerID()).getAccount(i).serialString());
        }

        bank.serializeUser();
        bank.serializeAcct();
    }
}
