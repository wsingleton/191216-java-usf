package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;
import com.fauxnancials.models.Acct;
import com.fauxnancials.services.AcctService;

import java.util.Set;

import static com.fauxnancials.util.AnsiColours.*;
import static com.fauxnancials.util.AnsiColours.ANSI_RESET;

public class DepositsMenu extends Menu {
    private AcctService acctService;
    public DepositsMenu(AcctService acctService) {
        super("Deposits", "/deposits");
        this.acctService=acctService;
    }
    @Override
    public void render() {
        Set<Acct> accts = acctService.getUserAccts();
        if (accts.isEmpty()) {
            System.out.println("No accounts found for " + AppDriver.currentUser.getGivenName() + " " + AppDriver.currentUser.getFamilyName() + ".");
            System.out.println("Please consider opening an account with us to meet your banking needs.");
            System.out.println("Returning to user dashboard...");
            AppDriver.router.navigate("/dashboard");
        } else {
            int acct_id = 0;
            System.out.println(ANSI_BLUE + "Available accounts:" + ANSI_RESET);
            acctService.showBals();
            System.out.println("");
            System.out.println("Into which account would you like to deposit funds?  Please provide the account number.");
            try {
                System.out.print("> ");
                String userSelection = AppDriver.console.readLine();
                try {
                    acct_id = Integer.parseInt(userSelection);
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Unrecognized input.  Transaction cancelled." + ANSI_RESET);
                    System.out.println("Returning to dashboard...");
                    AppDriver.router.navigate("/dashboard");
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "An unexpected exception has occurred.");
                System.out.println("Please try again later." + ANSI_RESET);
                System.out.println("Closing application...");
                AppDriver.appRunning = false;
            }
            Acct tgt = acctService.pullAcct(acct_id);
            double dpstAmmt = 0.0;
            System.out.println("How much would you like to deposit?");
            try {
                System.out.print("> ");
                String userSelection = AppDriver.console.readLine();
                try {
                    dpstAmmt = Double.parseDouble(userSelection);
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Unrecognized input.  Transaction cancelled." + ANSI_RESET);
                    System.out.println("Returning to dashboard...");
                    AppDriver.router.navigate("/dashboard");
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "An unexpected exception has occurred.");
                System.out.println("Please try again later." + ANSI_RESET);
                System.out.println("Closing application...");
                AppDriver.appRunning = false;
            }
            double currentBal = tgt.getBalance();
            tgt = acctService.deposit(tgt, dpstAmmt);
            if (currentBal == tgt.getBalance()) {
                System.out.println(ANSI_RED + "An unexpected error has occurred.  Transaction failed." + ANSI_RESET);
                System.out.println("Returning to dashboard...");
                AppDriver.router.navigate("/dashboard");
            } else {
                System.out.println("Deposit complete.");
                System.out.println("Returning to dashboard...");
                AppDriver.router.navigate("/dashboard");
            }
        }
    }
}
