package com.revature.mockbank.services;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.models.Account;
import com.revature.mockbank.models.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
//    DecimalFormat df = new DecimalFormat("##0.00");
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
        account.setAccountHistory( "UserId="+ currentUser.getId() + " " + date + "Withdrawal " + "$" +
                amountToWithdraw + "Balance: " + "$" + account.getBalance());
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


}
