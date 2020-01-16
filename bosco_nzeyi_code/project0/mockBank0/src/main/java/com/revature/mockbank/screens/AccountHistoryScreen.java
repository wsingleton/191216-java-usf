package com.revature.mockbank.screens;

import com.revature.mockbank.models.TransactionHistory;
import com.revature.mockbank.repositories.AccountRepo;
import com.revature.mockbank.repositories.TransactionRepo;
import com.revature.mockbank.services.AccountService;
import static com.revature.mockbank.AppDriver.*;
import static com.revature.mockbank.services.AccountService.*;

import java.util.Set;

public class AccountHistoryScreen extends Screen {

    AccountService accountService;
    AccountRepo accountRepo;

    public AccountHistoryScreen (AccountService accountService) {
        super("TransactionHistoryScreen", "/accountHistory");
        this.accountService = accountService;
    }

    @Override
    public void render() {
        try {
//            if(currentUser == null){
//                System.out.println("Current User could not be detected");
//            } else {
//                accountService.activityHistory(currentUser.getId());
//                System.out.println("Activities request sent");
//                System.out.println("tHE CURRENT USER ID IS " + currentUser.getId());
//            }

            accountService.activityHistory(currentUser.getId());

            if (activityLog.size() != 0) {
                System.out.println("\n-----------------------------------------------------------------------\n");
                System.out.println("ACTIVITY ID           USER ID             ACCOUNT NUMBER            ACTIVITY DATE" +
                        "               TRANSACTION DETAILS          AMOUNT");
                //System.out.println(activityLog.toString());
                for (TransactionHistory act : activityLog) {
                    System.out.println(act);
                }
                router.navigate("/dashboard");
            } else {
                System.out.println("No activities found. Make a deposit or a withdraw to be able to log activities");
                router.navigate("/dashboard");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("AN ERROR OCCURRED WHILE LOADING ACTIVITIES");
        }

    }
}
