package com.revature.screens;

import com.revature.services.AccountService;

import static com.revature.AppDriver.*;

public class Dashboard extends  Screen {

    private AccountService accountService;

    public Dashboard(AccountService accountService) {
        super("Dashboard", "/dashboard");
        System.out.println("Instantiating" + super.getName());
        this.accountService = accountService;
    }

    @Override
    public void render() {

        System.out.println(app().getCurrentSession().getSessionUser().getUsername());
        System.out.println("Transactions");
        System.out.println("1) Balance Inquiry");
        System.out.println("2) Deposit");
        System.out.println("3) Withdrawal");
        System.out.println("4) Log Out");

        try {
            System.out.println("> ");
            String userSelection = app().getConsole().readLine();
            switch (userSelection) {
                case "1":

                    System.out.println("Balance Inquiry");
                    //get account username
                    String tempUsername = app().getCurrentSession().getSessionUser().getUsername();

                    System.out.println("Your Current Balance: $" + accountService.getAccByAccUsername().getBalance() + "\n\n");
                    app().getRouter().navigate("/dashboard");
                    break;

                case "2":
                    //deposit
                    System.out.println("Deposit");
                    accountService.getAccByAccUsername().getBalance();
                    //
                    Double balance = accountService.getAccByAccUsername().getBalance();
                    System.out.println("Your Current Balance: " + balance);

                    System.out.println("Enter Amount to Deposit: ");
                    Double deposit = Double.parseDouble(app().getConsole().readLine());

                    System.out.println("Your New Balance: " + accountService.Deposit(deposit) + "\n\n");
                    app().getRouter().navigate("/dashboard");
                    break;

                case "3":
                    //withdrawal
                    System.out.println("Withdrawal");
                    //check this
                    accountService.getAccByAccUsername();
                    balance = accountService.getAccByAccUsername().getBalance();
                    System.out.println("Your Current Balance: $" + balance);

                    System.out.println("Enter Amount to Withdraw: $");
                    Double withdraw = Double.parseDouble(app().getConsole().readLine());

                    System.out.println("Your New Balance: $" +accountService.Withdraw(withdraw) + "\n\n");
                    app().getRouter().navigate("/dashboard");
                    break;

                case "4":
                    System.out.println("Logging Out...\n\n");
                    app().getRouter().navigate("/home");
                    break;

                default:
                    System.out.println("[LOG] - Invalid selection\n");
                    app().getRouter().navigate("/dashboard");
            }
        } catch (Exception e) {
            System.err.println("[Error] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            app().setAppRunning(false);
        }
    }
}
