package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.bank.ui.UI.accountLoginScreen;
import static com.bank.ui.UI.createUserName;

public class ReadFromDao {

    public static User isUser(String password, String username){
    File users = new File("src/resources/user.txt");
    User u = new User();
    List<User> userList = new ArrayList<>();
    int id;
    String firstname;

        try{
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String userLine = reader.readLine();

        while (userLine != null) {
            String[] userFields = userLine.split(":");
            u = new User(Integer.parseInt(userFields[0]), userFields[1], userFields[2], userFields[3], userFields[4]);
            id =Integer.parseInt(userFields[0]);
            firstname =userFields[1];
//            System.out.println(id);
//            System.out.println(username);
//            System.out.println(password);
//            System.out.println(u);
            //System.out.println(userFields[4].equals(password));
           userList.add(u);
            userLine = reader.readLine();
            if(userFields[4].equals(password) && userFields[3].equals(username)){
               // System.out.println(id);
                u.setId(id);
               // System.out.println(u);
                System.out.println("Successful login!");
                break;
            }

        }
           if(!u.getPassword().equals(password) && !u.getUserName().equals(username)){
               System.out.println("Invalid username and password input. \n Try again.");
                accountLoginScreen();
           }if(u.getPassword().equals(password) && !u.getUserName().equals(username)){
                System.out.println("Invalid username and password input. \n Try again.");
                accountLoginScreen();
            }if(!u.getPassword().equals(password) && u.getUserName().equals(username)){
                System.out.println("Invalid username and password input. \n Try again.");
                accountLoginScreen();
            }

        }catch(Exception e){
        e.printStackTrace();
        System.err.println("Unexpected Exception occurred.");
        }
        return u;
    }

    public static void isUsernameTaken(String Username, User myUser){
        File users = new File("src/resources/user.txt");
        User u = new User();
        List<User> userList = new ArrayList<>();


        try{
            BufferedReader reader = new BufferedReader(new FileReader(users));
            String userLine = reader.readLine();

            while (userLine != null) {
                String[] userFields = userLine.split(":");
                u = new User( userFields[3]);
                userList.add(u);
                userLine = reader.readLine();
                if( u.getUserName().equals(Username)){
                    System.out.println("This username is taken please try another.");
                    createUserName(Username,myUser);
                }

            }

        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Unexpected Exception occurred.");
        }


    }


public static Account getUserAccount(User currentUser){
       // Account currentUserAccount = new Account();
    File accounts = new File("src/resources/account.txt");
    Account currentUserAccount = new Account();
    //List<Account> accountList = new ArrayList<>();
int id = currentUser.getId();
    //System.out.println(id);
    try{
        BufferedReader reader = new BufferedReader(new FileReader(accounts));
        String accountLine = reader.readLine();

        while (accountLine != null) {
            //System.out.println("inside while loop");
            accountLine = reader.readLine();
            if(accountLine.isEmpty()){accountLine.trim();continue;}

                String[] accountFields = accountLine.split(":");
               // currentUserAccount = new Account(Integer.parseInt(accountFields[0]), Double.parseDouble(accountFields[1]));
              //  accountList.add(currentUserAccount);
                // System.out.println(currentUserAccount.getAccountId());
               // System.out.println(Integer.parseInt(accountFields[0]));

               //   System.out.println(Double.parseDouble(accountFields[1]));
                //System.out.println(accountLine);
                if(id == Integer.parseInt(accountFields[0])){
                  currentUserAccount= new Account(Integer.parseInt(accountFields[0]), Double.parseDouble(accountFields[1]));
                    break;
                }
            }



    }catch(NumberFormatException j){}
    catch(Exception e){
        //e.printStackTrace();
        //System.err.println("Unexpected Exception occurred.");
    }
        return currentUserAccount;
}

    public static double getUserAccountBalance(User currentUser){
        // Account currentUserAccount = new Account();
        File accounts = new File("src/resources/account.txt");
        Account currentUserAccount = new Account();
        List<Account> accountList = new ArrayList<>();
        int id = currentUser.getId();
        double newbalance =0;
       // System.out.println(id);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(accounts));
            String accountLine = reader.readLine();

            while (accountLine != null) {
                accountLine = reader.readLine();
                String[] accountFields = accountLine.split(":");
                currentUserAccount = new Account(Integer.parseInt(accountFields[0]), Double.parseDouble(accountFields[1]));
                accountList.add(currentUserAccount);
                // System.out.println(currentUserAccount.getAccountId());
                System.out.println(Integer.parseInt(accountFields[0]));
                System.out.println(Double.parseDouble(accountFields[1]));
                if(id == currentUserAccount.getAccountId()){
                    newbalance = currentUserAccount.getBalance();
                    break;
                }
            }


        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Unexpected Exception occurred.");
        }
        return newbalance;
    }
}
