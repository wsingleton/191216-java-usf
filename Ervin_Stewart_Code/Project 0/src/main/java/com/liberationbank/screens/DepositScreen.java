package com.liberationbank.screens;

import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.Account;
import com.liberationbank.models.User;
import com.liberationbank.repos.AccountRepository;
import com.liberationbank.services.AccountService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.liberationbank.AppDriver.*;

public class DepositScreen extends Screen {
    private AccountRepository accountRepo;
    private AccountService accountService;
    public DepositScreen(AccountService accountService, AccountRepository accountRepo){
        super("DepositScreen", "/deposit");
        System.out.println("[LOG] - Instantiating "+ super.getName());
        this.accountService = accountService;
        this.accountRepo = accountRepo;
    }

    @Override
    public void render() {
        double deposit = 0;
        double newbalance;
        double currentbalance;
        System.out.println("How much would you like to deposit today? " +
                "NOTE: Deposits cannot exceed $5000 in one transaction.");
        try{
            deposit = Double.parseDouble(console.readLine());
            currentbalance = currentAccount.getBalance();

            if(accountService.validateDeposit(deposit)){
                newbalance = currentbalance + deposit;
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
                    router.navigate("/dashboard");
            }
        } catch(InvalidRequestException | ResourcePersistenceException e){
            System.err.println("Transaction unsuccessful, invalid values provided");
            router.navigate("/dashboard");

        }catch(Exception e){
        System.err.println("[ERROR] - An Unexpected exception occured");
        System.out.println("[LOG] - shutting down application");
            router.navigate("/dashboard");
    }
    }
}
