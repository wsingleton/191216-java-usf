package mockBank;

import java.util.ArrayList;

public class Account {
    //name of account holder
    private String name;
    //account number
    private String accountID;
    //current account balance
    private double balance;
    //user object who owns the account
    private User holder;
    //transactions
    private ArrayList<Transaction> transactions;



}
