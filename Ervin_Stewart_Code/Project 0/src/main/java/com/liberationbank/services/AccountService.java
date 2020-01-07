package com.liberationbank.services;

import com.liberationbank.models.Account;
import com.liberationbank.models.User;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AccountService {

    public boolean validateDeposit( double deposit){
        if(deposit<0){
            System.out.println("No negative deposits, try again.");
            return false;
        } else if(deposit>5000){
            System.out.println("Deposits cannot exceed 5000$");
            return false;
        }
        return true;
    }


    public boolean validateWithdrawBalance( double withdrawal, double balance){
        if(withdrawal> balance || withdrawal <0){
            System.out.println("Invalid withdrawal, try again.");
            return false;
        }
        return true;
    }


    public double sanitizeValue(double money){
        //if(money < 0){return new String("cannot be negative value");}
        BigDecimal bd = new BigDecimal(money).setScale(2, RoundingMode.DOWN);
        double formatedMoney = bd.doubleValue();
        return formatedMoney;
    }
}
