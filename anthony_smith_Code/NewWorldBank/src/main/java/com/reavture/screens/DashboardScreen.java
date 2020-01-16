package com.reavture.screens;



import com.reavture.dao.AccountsDao;
import com.reavture.pojo.Account;
import com.reavture.pojo.User;
import com.reavture.repos.BankRepo;
import com.reavture.repos.UserRepo;
import com.reavture.services.*;


import java.util.Scanner;

public class DashboardScreen {

    public static void dashboard(int id) {
        System.out.println(id);

        int option = 0;

        Scanner scanner = new Scanner(System.in);

        UserRepo userRepo = new UserRepo();
        User currentUser = userRepo.findUser(id);
        BankRepo bankrepo = new BankRepo();
        //AccountsDao accountsDao = new AccountsDao();
        Account account = bankrepo.findAccountBank(currentUser.getUser_id());


        System.out.println("Hello " + currentUser.getFirstname());
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View balance");
        System.out.println("4. Sign out");

        do{
            System.out.println("Enter an option");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1, 2, 3 or 4");
            }

            switch(option) {

                case 1:

                    Deposit.deposit(id);
                    break;
                case 2:

                    Withdraw.withdraw(id);
                    break;

                case 3:
                    ViewBalance.viewBalance(id);
                    break;

                case 4:
                    System.out.println("Thank you, Have a Great Day!");

                    break;

                default:

                    break;

            }

        }while(option != 4);
        System.exit(0);
    }
}