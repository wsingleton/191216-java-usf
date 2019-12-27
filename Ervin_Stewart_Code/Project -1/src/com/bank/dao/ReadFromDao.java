package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.bank.ui.UI.accountLoginScreen;

public class ReadFromDao {

    public static User isUser(String password, String username){
    File users = new File("src/resources/user.txt");
    User u = new User();
    List<User> userList = new ArrayList<>();


        try{
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String userLine = reader.readLine();

        while (userLine != null) {
            String[] userFields = userLine.split(":");
            u = new User(Integer.parseInt(userFields[0]), userFields[1], userFields[2], userFields[3], userFields[4]);
            userList.add(u);
            userLine = reader.readLine();
            if(u.getPassword().equals(password) && u.getUserName().equals(username)){
                System.out.println("Successful login!");
                break;
            }

        }
           if(!u.getPassword().equals(password) && !u.getUserName().equals(username)){
               System.out.println("Invalid username and password input. \n Try again.");
                accountLoginScreen();
           }

        }catch(Exception e){
        e.printStackTrace();
        System.err.println("Unexpected Exception occurred.");
        }
        return u;
    }

public static Account getUserAccount(User currentUser){
       // Account currentUserAccount = new Account();
    File accounts = new File("src/resources/account.txt");
    Account currentUserAccount = new Account();
    List<Account> accountList = new ArrayList<>();
int id = currentUser.getId();

    try{
        BufferedReader reader = new BufferedReader(new FileReader(accounts));
        String accountLine = reader.readLine();

        while (accountLine != null) {
            accountLine = reader.readLine();
            String[] accountFields = accountLine.split(":");
            currentUserAccount = new Account(Integer.parseInt(accountFields[0]), Double.parseDouble(accountFields[1]));
            accountList.add(currentUserAccount);
           // System.out.println(currentUserAccount.getAccountId());
//            System.out.println(currentUser.getId());
//            System.out.println(currentUserAccount.getAccountId());
            if(id == currentUser.getId()){
              //  System.out.println(currentUserAccount.getAccountId());
                //System.out.println(currentUserAccount.getBalance());
                break;
            }
        }


    }catch(Exception e){
        e.printStackTrace();
        System.err.println("Unexpected Exception occurred.");
    }
        return currentUserAccount;
}


}
