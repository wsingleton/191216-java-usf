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
        String username = currentUser.getUsrName();

        Account newAcct = acctService.getAcctByUsername(username);

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
                    System.out.println("Your Current Balance: $" + newAcct.getBalance());
                    router.navigate("/profile");
                    break;

                case "2":
                    //deposit
                    System.out.println("Deposit");
                    System.out.println("Enter Amount to Deposit: $");
                    newAcct =

                    break;

                case "3":
                    //withdrawal
                    break;

                case "4":
                    System.out.println("Logging Out...");
                    router.navigate("/home");

                default:
                    System.out.println("[LOG] - Invalid selection");
            }
        }
        catch (Exception e){
            System.err.println("[Error] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}
