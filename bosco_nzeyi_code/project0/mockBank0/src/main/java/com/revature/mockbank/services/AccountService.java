package com.revature.mockbank.services;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.models.Account;
import com.revature.mockbank.models.User;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AccountService {
    /*
This class will be used to perform all account related transactions such as:
- Deposit
- Withdrawal
- check balance
- log transactions history
- transfer funds from one account to another, etc...
 */

    public User currentUser; // this will be created as a static instance of the login screen to get the current user.
    public Account account;
    DecimalFormat df = new DecimalFormat("##0.00");
    public String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));


    // method to deposit
    public void deposit(Double amount){

        Double amountToDeposit = validatedAmount(amount);
        account.setBalance(amountToDeposit, "deposit");
        account.setAccountHistory(date + "Deposit " + "$" + amountToDeposit + "Balance: " + "$" + account.getBalance());

    }

    // method to withdraw
    public void withdraw(Double amount){

        Double amountToWithdraw = validatedAmount(amount);
        account.setBalance(amountToWithdraw, "withdraw");
        account.setAccountHistory(date + "Withdrawal " + "$" + amountToWithdraw + "Balance: " + "$" + account.getBalance());

    }

    // method to validate and format amount deposited or withdrawn
    public Double validatedAmount (Double amount){
        Double validAmount = null;
        try{

            if(!amount.isNaN() && !(amount < 0)){
                // limit decimal points to 2.
//                validAmount = df.format(amount);
                validAmount = amount;
            }
        } catch (Exception e){
            throw new InvalidRequestException();
        }
        return validAmount;
    }


}
