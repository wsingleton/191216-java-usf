package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.AccountUser;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;

import static com.revature.AppDriver.*;


public class DepositScreen extends Screen{

    private AccountRepository accRep;
    private AccountService accountService;

    public DepositScreen(AccountService accountService, AccountRepository accRep){
        super("DepositScreen","/deposit");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
        this.accRep = accRep;
    }

    @Override
    public void render(){
        double newBalance;
        double deposit;
        double currentBalance;
        String userInput;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("How much to deposit?");
        try {


        deposit = Double.parseDouble(console.readLine());
        currentBalance = cuurentAccount.getBalance();
            if(accountService.depositCheck(deposit)){
                newBalance = currentBalance + deposit;
//                newBalance = accountService.sanitizeValue(newbalance);
                cuurentAccount.setBalance(newBalance);
                if(accRep.update(cuurentAccount)){
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
        } catch(InvalidRequestException | ResourcePersistentException e){
            System.err.println("Transaction unsuccessful, invalid values provided");
        }catch(Exception e){
            System.err.println("[ERROR] - An Unexpected exception occured");
            System.out.println("[LOG] - shutting down application");
            appRunning = false;
        }
    }
}
