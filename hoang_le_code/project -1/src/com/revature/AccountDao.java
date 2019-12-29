package com.revature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDao {
    public Account myAccount;
    public List<Account> accountList = new ArrayList<>();

    public AccountDao(){

    }

    public AccountDao(Account myAccount){
        this.myAccount = myAccount;

    }

    public void workOnAccount(String userName){

        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/com/revature/resources/account.txt"));
            String accountLine = reader.readLine();
            while(accountLine != null){
                String[] accountFiles= accountLine.split(":");
                Account u = new Account(accountFiles[0], Double.parseDouble(accountFiles[1]));
                accountList.add(u);
                accountLine = reader.readLine();
            }
        }
        catch(Exception e){
            System.err.println("an unexcpected exception occurred");
        }

        for(int i = 0 ; i < accountList.size();i++){
            Account account = accountList.get(i);
            if(userName.equals(account.getUserName())){
                System.out.println(" your account balance is : " + account.getBalance());
                Scanner sn = new Scanner(System.in);

                String input = "";

                while( input != "3"){
                    System.out.println("please chose one of the option below ");
                    System.out.println("1---deposit---");
                    System.out.println("2---withdraw---");
                    System.out.println("3---Quit---");
                    System.out.println("enter your choise");
                    input = sn.nextLine();
                    switch (input) {
                        case "1":{
                            String inp = "0.0";
                            Double amount =0.0;
                            System.out.println(" enter amount you want to deposit");

                            inp = sn.nextLine();
                            try{
                                amount = Double.parseDouble(inp);
                            }
                            catch(Exception e){
                                System.err.println("an unexcpected exception occurred");

                            }
                            double a = account.getBalance() + amount;

                            account.setBalance(a);
                            accountList.remove(i);
                            accountList.add(i,account);
                            System.out.println(" you deposited : " + amount);
                            saveBalance(accountList);
                            System.out.println("your balance right now is : " + accountList.get(i).getBalance());
                            break;
                        }
                        case "2":{
                            String inp = "0.0";
                            Double amount =0.0;
                            System.out.println(" enter amount you want to withdraw");

                            inp = sn.nextLine();
                            try{
                                amount = Double.parseDouble(inp);
                            }
                            catch(Exception e){
                                System.err.println("an unexcpected exception occurred");

                            }
                            if(account.getBalance() < amount){
                                System.out.println("you dont have enough to withdraw  ");
                            }
                            else {
                                double a = account.getBalance() - amount;

                                account.setBalance(a);
                                accountList.remove(i);
                                accountList.add(i,account);
                                System.out.println(" you withdraw : " + amount);
                                saveBalance(accountList);
                                System.out.println("your balance right now is : " + accountList.get(i).getBalance());
                            }


                            break;
                        }
                        case "3":
                            System.out.println("good bye");
                            input = "3";
                            break;
                        default:
                            System.out.println("you choosed wrong option");
                            break;
                    }


                }



            }

        }



    }

    public void saveBalance(List<Account> list){
        try {


            BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/revature/resources/account.txt")  );

            for(Account account : accountList){
                writer.write(account.saveString());
                writer.newLine();
            }

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
