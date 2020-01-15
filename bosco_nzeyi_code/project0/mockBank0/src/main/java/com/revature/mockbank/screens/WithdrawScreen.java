package com.revature.mockbank.screens;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.exceptions.ResourcePersistenceException;
import com.revature.mockbank.services.AccountService;

import static com.revature.mockbank.AppDriver.*;

public class WithdrawScreen extends Screen {


    private AccountService accountService;

    public WithdrawScreen( AccountService accountService) {

        super("WithdrawScreen", "/withdraw");
        this.accountService = accountService;
    }

    @Override
    public void render() {
        try{
            System.out.println("How much do you want to withdraw?");
            String option = console.readLine();

            int accountId = currentAccount.getAccount_id();
            int userId = currentUser.getId();

            if(!(option.trim().equals("")) || !(new Integer(option)<1)){
                double amount = new Double(option);

                accountService.withdraw(accountId, userId, amount);

                System.out.println("Withdraw successful. ... Navigating back to the dashboard");
                // send the user back to the dashboard
                router.navigate("/dashboard");

            }
        }catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}
