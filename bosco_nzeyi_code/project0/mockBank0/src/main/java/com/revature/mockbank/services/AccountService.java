package com.revature.mockbank.services;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.models.Account;
import com.revature.mockbank.models.TransactionHistory;
import com.revature.mockbank.repositories.AccountRepo;
import com.revature.mockbank.repositories.TransactionRepo;
import static com.revature.mockbank.repositories.TransactionRepo.*;

import  static com.revature.mockbank.repositories.AccountRepo.*;
import static com.revature.mockbank.AppDriver.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AccountService {

   private AccountRepo accountRepo;
   private TransactionRepo transactionRepo;

    public AccountService(AccountRepo accountRepo, TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public AccountService() {
        super();
    }


    // method to create account
    public void createAccount(Account data){
        accountRepo.save(data);

        currentAccount = AccountRepo.newAccount;
    }

    // method to deposit
    public void deposit(int accountId, int userId, double amountToDeposit){

        double amount = validatedAmount(amountToDeposit);

        if(negativeValuesChecker(amount)){
            System.out.println("Negative amount not allowed.");
        } else {
            accountRepo.deposit(accountId, userId, amount);
        }
    }

//    // method to withdraw
    public void withdraw(int accountId, int userId, double amountToWithdraw){
        double amount = validatedAmount(amountToWithdraw);

        if(negativeValuesChecker(amount)){
            System.out.println("Negative amount not allowed.");
        } else {

            // check if the current balance is sufficient
            double currentBal = currentAccount.getBalance();
            if (currentBal < amount) {
                System.out.println("Insufficient balance");
            } else {
                accountRepo.withdraw(accountId, userId, amount);
            }
        }
    }

    // activity log
    public void activityHistory (int userId){
        transactionRepo.findActivityById(userId);
        activityLog = log;
       // return activityLog;
    }

    // check accounts of the users
    public void allAccounts (int userId){
        accountRepo.findAllAccounts(userId);
        listOfAccounts = usersAccounts;
    }

    // set the account in use
    public void setCurrentAccountInUse(int accountId){
        currentAccount = accountRepo.findAccountById(accountId);
    }

    // validate integer input
    public boolean isNumeric(String strNum) {
        if (strNum == null || strNum.trim().equals("")) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // method to validate and format amount deposited or withdrawn
    public Double validatedAmount (Double amount){
        if(amount.isNaN() || amount < 0) return 0.0;
//            throw new InvalidRequestException(
//        Double validAmount = null;
        try{
                // limit decimal points to 2.
                BigDecimal toTwoDecimal = BigDecimal.valueOf(amount);
                amount = toTwoDecimal.setScale(2, RoundingMode.DOWN).doubleValue();
//                validAmount = amount;
        } catch (Exception e){
            throw new InvalidRequestException();
        }
        return amount;
    }

    public boolean negativeValuesChecker(Double amount){
        if(amount <= 0){
            return true;
        }
        return false;
    }


}
