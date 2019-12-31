package com.revature;

import com.revature.models.Account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountServices {
    //create the array list to hold all the accounts to be added
    static ArrayList<Account>accounts;
    static {
        accounts = new ArrayList<Account>();
        accounts.add(new Account("Benji", "Bruce", 0));
    }

    ArrayList<Account> getAllAccounts() {


        DAO dao = new DAO();
        return dao.readAccounts();
    }

    public Account addAccount(String username, String password, Double balance){

        Account a = new Account(username, password, balance);
        //logic needds to in here
        DAO dao = new DAO();
        dao.addAccount(a);
        return a;
    }
    boolean userExists(String username){
        ArrayList<Account> accounts = getAllAccounts();
        return accounts.stream().anyMatch(s->s.getUsername().equalsIgnoreCase(username));
    }

    boolean exists(String username, String pass){
        List<Account> accountList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/revature/Accounts.txt"));
            String userLine = reader.readLine();

            while (userLine !=null && userLine!= " "){
                String[] userFields = userLine.split(":");
                Account a = new Account(userFields[0],userFields[1],(Double.parseDouble(userFields[2])));
                accountList.add(a);
                userLine = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected error occured");
        }

        boolean a= false;
        for (Account u : accountList){
            if(username.equals(u.getUsername()) && pass.equals(u.getPassword())){
                a=  true;
            }
            else {
                a= false;
            }
        }
        return a;
    }

    Account getByUsername(String username){
        return getAllAccounts().stream().filter(s->s.getUsername().equalsIgnoreCase(username)).findFirst().get();
    }

    void updateBalance(Account ac){
        DAO dao = new DAO();
        ArrayList<Account> temp = dao.readAccounts();

        for (Account a : temp){
            if(a.getUsername().equals(ac.getUsername())) {
                a.setBalance(a.getBalance());
            }
        }
        //dao needs update
        dao.updateAccount(temp);
    }


    public void deposit(String username, String pass){
        List<Account> accountList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/revature/Accounts.txt"));
            String userLine = reader.readLine();

            while (userLine !=null && userLine!= " "){
                String[] userFields = userLine.split(":");
                Account a = new Account(userFields[0],userFields[1],(Double.parseDouble(userFields[2])));
                accountList.add(a);
                userLine = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected error occured");
        }

        int  index = 0 ;
        for (Account u : accountList){
            if(username.equals(u.getUsername()) && pass.equals(u.getPassword())){
                System.out.println("your balance is : "+ u.getBalance());
                System.out.println(" choose deposit or withdraw  ");
                Scanner sc = new Scanner(System.in);
                String choose = sc.nextLine();
                switch (choose){
                    case "deposit":
                        Double amount = 0.0;
                        System.out.println("enter amount : ");
                        amount = sc.nextDouble();
                        Double newbalance = u.getBalance() + amount;
                        u.setBalance(newbalance);
                        System.out.println(" your new balance is :  "+ u.getBalance());
                        accountList.remove(index);
                        accountList.add(index,u);
                        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/revature/Accounts.txt"))){
                            for(Account k : accountList){
                                String add = k.getUsername()+":"+k.getPassword()+":"+k.getBalance();
                                writer.write(add);
                                writer.newLine();
                            }
                        } catch (Exception e){
                            e.printStackTrace();

                        }
                        break;
                }


            }
            else {

            }
            index = index + 1;
        }
    }

}
