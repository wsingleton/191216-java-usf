package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;
import com.fauxnancials.models.Acct;
import com.fauxnancials.services.AcctService;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Optional;
import java.util.Set;

import static com.fauxnancials.util.AnsiColours.*;

public class TransfersMenu extends Menu {
    private AcctService acctService;

    public TransfersMenu(AcctService acctService) {
        super("Transfers", "/transfers");
        this.acctService = acctService;
    }

    @Override
    public void render() {
        Set<Acct> accts = acctService.getUserAccts();
        if (accts.isEmpty() || accts.size() < 2) {
            System.out.println("Transfers can only be completed by users with two or more accounts.");
            System.out.println("Please consider opening another account with us to meet your banking needs.");
            System.out.println("Returning to user dashboard...");
            AppDriver.router.navigate("/dashboard");
        } else {
            int srcAcct=0;
            int tgtAcct=0;
            System.out.println(ANSI_BLUE + "Available accounts:" + ANSI_RESET);
            acctService.showBals();
            System.out.println("");
            System.out.println("From which account would you like to transfer funds?  Please provide the account number.");
            try {
                System.out.print("> ");
                String userSelection = AppDriver.console.readLine();
                try {
                    srcAcct = Integer.parseInt(userSelection);
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
            System.out.println("Into which account would you like to transfer funds?  Please provide the account number.");
            try {
                System.out.print("> ");
                String userSelection = AppDriver.console.readLine();
                try {
                    tgtAcct = Integer.parseInt(userSelection);
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
            Acct src=acctService.pullAcct(srcAcct);
            Acct tgt=acctService.pullAcct(tgtAcct);
            double tsfrAmmt=0.0;
            System.out.println("How much would you like to transfer?");
            try {
                System.out.print("> ");
                String userSelection = AppDriver.console.readLine();
                try {
                    tsfrAmmt = Double.parseDouble(userSelection);
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
            double currentBal=src.getBalance();
            src=acctService.withdrawal(src,tsfrAmmt);
            if (currentBal==src.getBalance()) {
                System.out.println(ANSI_RED + "An unexpected error has occurred.  Transaction failed." + ANSI_RESET);
                System.out.println("Returning to dashboard...");
                AppDriver.router.navigate("/dashboard");
            }
            else {
                currentBal=tgt.getBalance();
                tgt=acctService.deposit(tgt, tsfrAmmt);
                if (currentBal==tgt.getBalance()) {
                    System.out.println(ANSI_RED + "An unexpected error has occurred.  Transaction failed.");
                    System.out.println("Please contact your local branch office to correct this issue." + ANSI_RESET);
                    System.out.println("Closing application...");
                    AppDriver.appRunning = false;
                }
                else {
                    System.out.println("Transaction complete.");
                    System.out.println("Returning to dashboard...");
                    AppDriver.router.navigate("/dashboard");
                }
            }
        }
    }
}