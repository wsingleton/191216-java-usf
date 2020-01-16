package com.revature.bankapp.screens;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.services.AccountService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

import static com.revature.bankapp.BankDriver.*;
import static java.lang.System.exit;

public class AccountScreen extends Screen {

    private AccountService accountService;

    public AccountScreen() {
        super("AccountScreen", "/accountscreen");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public AccountScreen(AccountService accountService) {
        super("AccountScreen", "/accountscreen");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
    }
    @Override
    public void render() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        boolean run = true;
        start:
        while(run) {
            System.out.print("1) View Accounts\n" +
                    "2) Create Account\n" +
                    "3) Delete Account\n" +
                    "4) Deposit\n" +
                    "5) Withdraw\n" +
                    "6) Transfer\n" +
                    "7) Manage Joint Accounts\n" +
                    "8) Back\n" +
                    "----------------\n" +
                    "> ");

            String userChoice = "";
            try {
                userChoice = console.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            switch(userChoice) {
                case "1":
                    Set<Account> actSet = null;
                    actSet = accountService.findAllByUser(userid);
                    if(actSet == null || actSet.size() == 0) System.out.println("No Accounts");
                    else System.out.println(actSet);
                    break;
                case "2":
                    router.navigate("/accountcreation");
                    break;
                case "3":
                    System.out.println("Choose ID of Account to delete");
                    String delID = "";
                    try {
                        delID = console.readLine();
                    } catch (IOException e) { e.printStackTrace(); }
                    int del = Integer.parseInt(delID);
                    if(accountService.owner(del))
                        accountService.deleteByID(del);
                    else System.out.println("You do not own this account");
                    break;
                case "4":
                    System.out.println("Choose ID of Account for deposit");
                    String depID = "";
                    try {
                        depID = console.readLine();
                    } catch (IOException e) {e.printStackTrace(); break start;}
                    int depositAccount = Integer.parseInt(depID);

                    if(accountService.owner(depositAccount))
                        accountService.deposit(depositAccount);
                    else System.out.println("You do not own this account.");
                    break;
                case "5":
                    System.out.println("Choose ID of Account for withdrawal");
                    String wID = "";
                    try {
                        wID = console.readLine();
                    } catch (IOException e) { e.printStackTrace(); }

                    int withdrawAccount = Integer.parseInt(wID);

                    System.out.println("Enter Withdrawal Amount: ");
                    String withdrawalString = "-1.00";
                    try {
                        withdrawalString = console.readLine();
                    } catch (IOException e) { e.printStackTrace(); }

                    Double withdrawalAmount = Double.parseDouble(withdrawalString);
                    BigDecimal screen = BigDecimal.valueOf(withdrawalAmount);
                    withdrawalAmount = screen.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();

                    if(accountService.owner(withdrawAccount))
                        accountService.withdrawal(withdrawAccount, withdrawalAmount);
                    else System.out.println("You do not own this account.");
                    break;
                case "6":
                    System.out.println("Choose ID of Account to transfer from");
                    String id1s = "";
                    String id2s = "";
                    try {
                        id1s = console.readLine();
                    } catch (IOException e) { e.printStackTrace(); }
                    int id1 = Integer.parseInt(id1s);

                    System.out.println("Choose ID of Account to transfer to");
                    try {
                        id2s = console.readLine();
                    } catch (IOException e) { e.printStackTrace(); }
                    int id2 = Integer.parseInt(id2s);

                    System.out.println("Enter Transfer Amount: ");
                    String transferString = "-1.00";
                    try {
                        transferString = console.readLine();
                    } catch (IOException e) { e.printStackTrace(); }

                    Double transferAmount = Double.parseDouble(transferString);
                    BigDecimal screen2 = BigDecimal.valueOf(transferAmount);
                    transferAmount = screen2.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                    accountService.transfer(id1, id2, transferAmount);
                    break;
                case "7":
                    router.navigate("/jacs");
                    break;
                case "8":
                    appRunning = false;
                    run = false;
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection!");
            }
        }

    }
}
