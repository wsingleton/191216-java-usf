/*
We will use this class to interact with the user's account.
It will have methods to query account balances, deposit, withdraw, etc.
 */

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class AccountManager {

    private int id; // matching with the user id
    private int balance; // to show the account balance
    private ArrayList<String> activities = new ArrayList<String>(); // an arrayList that record account activities.
    Date now = new Date();


    public void deposit (int amount){
        // get the balance buy picking the last balance
        RecordKeeper records = new RecordKeeper();
        ArrayList<String> history = records.data;
        // calculate the new balance
        // write the current transaction to the record keeper class


        balance += amount;
        activities.add("Deposited $" + amount + " on " + now.toString());
        System.out.println("Success depositing $" + amount);
        System.out.println("Your new account balance is $" + balance);
    }

    public void withdraw (int amount) {
        balance -= amount;
        activities.add("Withdraw $" + amount + " on " + now.toString());
        System.out.println("Success withdrawing $" + amount);
        System.out.println("Your new account balance is $" + balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void activityLog(){

        for(String activity: activities){
            System.out.println(activity);
        }
    }

}
