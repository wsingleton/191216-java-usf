package com.revature.bank.screens;

import com.revature.bank.models.Account;
import com.revature.bank.services.AcctService;

import static com.revature.bank.AppDriver.*;

public class ProfileScreen extends Screen {

    private AcctService acctService;

    public ProfileScreen(AcctService acctService){
        super("ProfileScreen", "/profile");
        System.out.println("Instantiating " + super.getName());
        this.acctService = acctService;
    }



    @Override
    public void render() {

        System.out.println("Transactions");
        System.out.println("1) Balance Inquiry");
        System.out.println("2) Deposit");
        System.out.println("3) Withdrawal");
        System.out.println("4) Log Out");

        try{
            System.out.println("> ");
            String userSelection = console.readLine();
            switch (userSelection){
                case "1":
                    //getbalance
                    System.out.println("Balance Inquiry");
                    acctService.getAcctByUsername(currentUser.getUsrName());

                    System.out.println("Your Current Balance: $" + currentAcct.getBalance() + "\n\n");
                    router.navigate("/profile");
                    break;

                case "2":
                    //deposit
                    System.out.println("Deposit");
                    acctService.getAcctByUsername(currentUser.getUsrName());
                    Double curBal = currentAcct.getBalance();
                    System.out.println("Your Current Balance: $" + curBal);

                    System.out.println("Enter Amount to Deposit: $");
                    Double deposit = Double.parseDouble(console.readLine());

                    System.out.println("Your New Balance: $" + acctService.validateDeposit(curBal, deposit) + "\n\n");
                    router.navigate("/profile");
                    break;

                case "3":
                    //withdrawal
                    System.out.println("Withdrawal");
                    acctService.getAcctByUsername(currentUser.getUsrName());
                    curBal = currentAcct.getBalance();
                    System.out.println("Your Current Balance: $" + curBal);

                    System.out.println("Enter Amount to Withdraw: $");
                    Double withdraw = Double.parseDouble(console.readLine());

                    System.out.println("Your New Balance: $" + acctService.validateWith(curBal, withdraw) + "\n\n");
                    router.navigate("/profile");
                    break;

                case "4":
                    System.out.println("Logging Out...\n\n");
                    router.navigate("/home");
                    break;

                default:
                    System.out.println("[LOG] - Invalid selection\n");
                    router.navigate("/profile");
            }
        }
        catch (Exception e){
            System.err.println("[Error] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}
