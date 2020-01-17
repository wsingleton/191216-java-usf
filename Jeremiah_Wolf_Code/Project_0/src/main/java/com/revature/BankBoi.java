package com.revature;


import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class BankBoi {

    Bank myBank = new Bank();
    public int testint = 0;

    HashMap< String, BankAccount > acctInfo = new HashMap<>();
    String token = "";

    public void readFile() {
        String file_name = "C:\\Users\\Jeremaih PC\\repos\\191216-java-usf\\Jeremiah_Wolf_Code\\untitled\\src\\com\\bankboi\\Users";
        File file = new File(file_name);
        //Scanner s = new Scanner(System.in);
        Scanner scanner = null;
        Double balance;
        String un;
        String pw;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNext()) {

                un = scanner.next();
                pw = scanner.next();
                balance = scanner.nextDouble();

                BankAccount act = new BankAccount(un, pw);

                acctInfo.put(un, act);
                BankAccount.deposit(balance, acctInfo, un);
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //
    // WRITE TO A FILE
    //
    public void writeFile() {
        String file_name = "C:\\Users\\Jeremaih PC\\repos\\191216-java-usf\\Jeremiah_Wolf_Code\\untitled\\src\\com\\bankboi\\Users";
        FileWriter fwriter = null;

        try {
            fwriter = new FileWriter(file_name);
            //System.out.println("Text file written to");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PrintWriter pWriter = new PrintWriter(fwriter);
        acctInfo.forEach((k, v) -> pWriter.println(v.getUsername() + " " + v.getPassword() + " " + v.getBalance()) );
        pWriter.close();
    }
    public void menu() {
        String choice = "";
        String decide = "";
        Scanner s = new Scanner(System.in);
        boolean success = false;
        do {
            System.out.println();
            System.out.println("1. Open a new bank account");
            System.out.println("2. Log into existing account");
            System.out.println();
            System.out.print("Type your selection 1 or 2: ");
            String pw;
            String un;
            decide = s.next();
            switch (decide) {
                case "1":
                    System.out.println("Set Username");
                    un = s.next();
                    System.out.println("Set Password");
                    pw = s.next();
                    System.out.println("Enter a opening balance");
                    double d = s.nextDouble();
                    if (!acctInfo.containsKey(un)) {
                        acctInfo.put(un, new BankAccount(un, pw));
                        BankAccount.deposit(d, acctInfo, un);
                        token = un;
                        success = true;
                    }

                    break;
                case "2":
                    System.out.println("Enter Username");
                    un = s.next();
                    System.out.println("Enter Password");
                    pw = s.next();

                    if (acctInfo.containsKey(un) && acctInfo.get(un).getPassword().equals(pw)) {
                        success = true;
                        token = un;
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");

            }

        }
        while (!success);
        boolean success2 = false;
        do {

            System.out.println();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Type your selection 1-4: ");
            choice = s.next();
            switch (choice) {

                case "1":
                    System.out.println("Enter a deposit amount");
                    double da = s.nextDouble();
                    BankAccount.deposit(da, acctInfo, token);
                    break;
                case "2":
                    System.out.println("Enter a withdraw amount");
                    double wa = s.nextDouble();
                    BankAccount.withdraw(wa, acctInfo, token);
                    break;
                case "3":
                    System.out.println("Balance: " + acctInfo.get(token).getBalance());
                    break;
                case "4":
                    System.out.println("Exiting Program");
                    success2 = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        while(!success2);
    }
}

class Bank {
    private BankAccount[] accounts;
    private int numOfAccounts;
    private String pw;


    public Bank() {
        accounts = new BankAccount[100];
        numOfAccounts = 0;
    }


    public int openNewAccount(String anum, double openingBalance) {

        BankAccount b = new BankAccount(anum, openingBalance);
        accounts[numOfAccounts] = b;
        numOfAccounts++;
        return b.getAccountNum();
    }

    public void withdrawFrom(int anum, double amount) {
        for (int i =0; i<numOfAccounts; i++) {
            if (anum == accounts[i].getAccountNum()  ) {
                // accounts[i].withdraw(amount);
                System.out.println("Amount withdrawn successfully");
                return;
            }
        }
        System.out.println("Account number not found.");
    }

    public void depositTo(int anum, double amount) {
        for (int i =0; i<numOfAccounts; i++) {
            if (anum == accounts[i].getAccountNum()  ) {
                //accounts[i].deposit(amount);
                System.out.println("Amount deposited successfully");
                return;
            }
        }
        System.out.println("Account number not found.");
    }

    public void printAccountInfo(int anum) {
        for (int i =0; i<numOfAccounts; i++) {
            if (anum == accounts[i].getAccountNum()  ) {
                System.out.println(accounts[i].getAccountInfo());
                return;
            }
        }
        System.out.println("Account number not found.");
    }

    public void printTransactionInfo(int anum) {
        for (int i =0; i<numOfAccounts; i++) {
            if (anum == accounts[i].getAccountNum()  ) {
                System.out.println(accounts[i].getAccountInfo());
                System.out.println("Last transaction: " + accounts[i].getTransactionInfo(accounts[i].getNumberOfTransactions()-1));
                return;
            }
        }
        System.out.println("Account number not found.");
    }



    public void printAccountInfo(int anum, int n) {
        for (int i =0; i<numOfAccounts; i++) {
            if (anum == accounts[i].getAccountNum()) {
                System.out.println(accounts[i].getAccountInfo());
                System.out.println(accounts[i].getTransactionInfo(n));
                return;
            }
        }
        System.out.println("Account number not found.");
    }

}
class BankAccount{

    private int anum;
    private String password;
    private String username;
    private String customerName;
    private double balance;
    private double[] transactions;
    private String[] transactionsSummary;
    private int numOfTransactions;
    private int noOfAccounts=0;

    public String getAccountInfo(){
        return "Account number: " + anum + "\nCustomer Name: " + customerName + "\nBalance:" + balance +"\n";
    }

    public String getTransactionInfo(int n)
    {
        String transaction = transactionsSummary[n];
        if (transaction == null) {
            return "No transaction exists with that number.";
        }
        else {
            return transaction;
        }
    }

    public BankAccount(String un, String pw) {
        this.username = un;
        this.password = pw;
        this.balance = 0;
    }

    public BankAccount(String abc, double xyz){
        customerName = abc;
        balance = xyz;
        noOfAccounts ++;
        anum = noOfAccounts;
        transactions = new double[100];
        transactionsSummary = new String[100];
        transactions[0] = balance;
        transactionsSummary[0] = "A balance of : $" + Double.toString(balance) + " was deposited.";
        numOfTransactions = 1;
    }

    public int getAccountNum(){
        return anum;
    }

    public int getNumberOfTransactions() {
        return numOfTransactions;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return this.balance;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public static void deposit(double amount, HashMap<String, BankAccount> bm, String username){

        if (amount<=0) {
            System.out.println("Amount to be deposited should be positive");
        } else {

            bm.get(username).setBalance(bm.get(username).getBalance() + amount);
        }
    }

    public static void withdraw(double amount, HashMap<String, BankAccount> bm, String username){
        if (amount<=0){
            System.out.println("Amount to be withdrawn should be positive");
        }
        else
        {
            bm.get(username).setBalance(bm.get(username).getBalance() - amount);
        }
    }

}
class test {
    static void printInt(int test) {
        System.out.println(test);
    }
}