package com.revature.bank.screens;

import com.revature.bank.services.AcctService;

import static com.revature.bank.AppDriver.*;

public class ProfileScreen extends Screen {

    private AcctService acctService;

    public ProfileScreen(AcctService acctService){
        super("ProfileScreen", "/profile");
        this.acctService = acctService;
    }


    @Override
    public void render() {
        acctService.register(currentUser.getUsrName());

        System.out.println("\nTransactions");
        System.out.println("1) Balance Inquiry");
        System.out.println("2) Deposit");
        System.out.println("3) Withdrawal");
        System.out.println("4) Log Out");

        try{
            acctService.getAcctByUsername(currentUser.getUsrName());

            System.out.println("> ");
            String userSelection = console.readLine();
            switch (userSelection){
                case "1":
                    //getbalance
                    System.out.println("Balance Inquiry");
                    System.out.println("Your Current Balance: $" + currentAcct.getBalance() + "\n\n");
                    router.navigate("/profile");
                    break;

                case "2":
                    //deposit
                    System.out.println("Deposit");
                    Double curBal = currentAcct.getBalance();
                    System.out.println("Your Current Balance: $" + curBal);
                    System.out.println("Enter Amount to Deposit: $");
                    Double deposit = valid(console.readLine());
                    System.out.println("Your New Balance: $" + acctService.validateDeposit(curBal, deposit) + "\n\n");
                    router.navigate("/profile");
                    break;

                case "3":
                    //withdrawal
                    System.out.println("Withdrawal");
                    curBal = currentAcct.getBalance();
                    System.out.println("Your Current Balance: $" + curBal);

                    System.out.println("Enter Amount to Withdraw: $");
                    Double withdraw = valid(console.readLine());

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

    public Double valid(String input){
        Double inputVal = 0.0;
        try{
            inputVal = Double.parseDouble(input);
        }
        catch(Exception e){
            System.err.println("Please Enter A Valid Amount\n\n");
        }
        return inputVal;
    }
}
