package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;

import static com.revature.AppDriver.*;


public class WithdrawScreen extends Screen {

    private AccountService accountService;
    private AccountRepository accountRepository;

    public WithdrawScreen(AccountService accountService, AccountRepository accRep){
        super("WithdrawScreen", "/withdraw");
        System.out.println("[LOG] - Instantiating" + super.getName());
        this.accountService = accountService;
        this.accountRepository = accRep;
    }

    @Override
    public void render() {
        double withdrawal;
        double newBalance;
        double currentBalance;
        try {
            System.out.println("\n\n\n\n\n\n\n\n\n+-------------------------------+\n");
            System.out.println("The Balance on your "+ cuurentAccount.getAccountType()
                    + " is: \n"+ cuurentAccount.getBalance());

            System.out.println("Please enter a withdrawal amount: ");
            withdrawal = Double.parseDouble(console.readLine());

            currentBalance = cuurentAccount.getBalance();

            if(accountService.withdrawBalanceCheck(withdrawal,currentBalance)){
                newBalance = currentBalance - withdrawal;
//                newBalance = accountService.sanitizeValue(newbalance);
                cuurentAccount.setBalance(newBalance);
                //hmmmm weird
                if(accountRepository.update(cuurentAccount)){
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
            appRunning=false;
        }

    }
}
