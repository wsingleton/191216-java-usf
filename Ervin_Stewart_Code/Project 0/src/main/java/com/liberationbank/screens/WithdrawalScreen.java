package com.liberationbank.screens;

import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.repos.AccountRepository;
import com.liberationbank.services.AccountService;

import static com.liberationbank.AppDriver.*;

public class WithdrawalScreen extends Screen {

    private AccountRepository accountRepo;
    private AccountService accountService;

        public WithdrawalScreen(AccountService accountService, AccountRepository accountRepo){
        super("WithdrawalScreen", "/withdrawal");
        System.out.println("[LOG] - Instantiating "+ super.getName());
        this.accountService= accountService;
        this.accountRepo = accountRepo;
     }

        @Override
        public void render() {
            double withdrawal;
            double newbalance;
            double currentbalance;
        try {
            System.out.println("\n\n\n\n\n\n\n\n\n+-------------------------------+\n");
            System.out.println("The Balance on your "+ currentAccount.getAccountType()
                    + " is: \n"+ currentAccount.getBalance());

            System.out.println("Please enter a withdrawal amount: ");
            withdrawal = Double.parseDouble(console.readLine());

            currentbalance = currentAccount.getBalance();

            if(accountService.validateWithdrawalBalance(withdrawal,currentbalance)){
                newbalance = currentbalance - withdrawal;
                newbalance = accountService.sanitizeValue(newbalance);
                currentAccount.setBalance(newbalance);
                if(accountRepo.update(currentAccount)){
                    System.out.println("Transaction successful! Balance updated.");}
                else{ throw  new InvalidRequestException();}
            } else{throw new InvalidRequestException();}
            System.out.println("Press 1 to return to the main console");
            System.out.println("Press 2 to log out");

            String Input = console.readLine();
            switch (Input){
                case "1":
                    System.out.println("Returning to dashboard...");
                    router.navigate("/dashboard");
                case "2":
                    router.navigate("/home");
                default:
                    System.out.println("Not a valid input");
            }
        } catch(InvalidRequestException | ResourcePersistenceException e){
            System.err.println("Transaction unsuccessful, invalid values provided");
        }catch(Exception e){
            System.err.println("[ERROR] - An Unexpected exception occured");
            System.out.println("[LOG] - shutting down application");
            appRunning = false;
        }

        }
    }

