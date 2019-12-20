package com.bank.ui;

import java.util.Scanner;
import com.bank.ui.DepositScreen;
import com.bank.ui.BalanceScreen;
import com.bank.ui.WithdrawScreen;

public class HomeScreen {

   public void display() {

        DepositScreen d = new DepositScreen();
        WithdrawScreen w = new WithdrawScreen();
        BalanceScreen b = new BalanceScreen();

       Scanner input = new Scanner(System.in);

       System.out.println("Check Balance = 0");
       System.out.println("Deposit = 1");
       System.out.println("Withdraw = 2");
       System.out.print("Please choose an option: ");
       int number = input.nextInt();

       if (number == 0){

           b.checkBalance();
       }
       else if(number == 1){

           d.deposit();
       }
       else if(number == 2){

           w.withdraw();
       }
       else{

           System.out.println("Error: Please try again");
           System.out.println("");
           display();
       }

   }

}
