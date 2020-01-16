package com.revature.bankapp.services;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.Type;
import com.revature.bankapp.repositories.AccountRepository;
import static com.revature.bankapp.BankDriver.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService() {
    }

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Type type) {
        Account account = new Account();
        account.setType(type);
        accountRepository.save(account);
    }

    public Set<Account> findAllJoint() {
        return accountRepository.findAllJoint();
    }

    public void addUserToAccount(int id) {
        String un = "";
        String pw = "";
        try {
            System.out.print("Enter Username of Member to be added to account: ");
            un = console.readLine();
            System.out.print("Enter Password of Member to be added to account: ");
            pw = console.readLine();

            accountRepository.addUserToAccount(un, pw, id);
        } catch (IOException e) {e.printStackTrace();}
    }

    public void createJoint(Type type) {

    }

    public void deleteByID(int id) {
        accountRepository.deleteById(id);
    }

    public boolean owner(int id) {
        return accountRepository.owner(id);
    }

    public Set<Account> findAllByUser(int userID) {
        return accountRepository.findByUser(userID);
    }

    public void deposit(int id) {
        System.out.print("Enter Deposit Amount: ");
        String depositString = "-1.00";
        try {
            depositString = console.readLine();
        } catch (IOException e) { e.printStackTrace(); }

        Double depositAmount = Double.parseDouble(depositString);
        BigDecimal screen = BigDecimal.valueOf(depositAmount);
        depositAmount = screen.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();

        if(depositAmount < 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        else accountRepository.deposit(id, depositAmount);
    }

    public boolean withdrawal(int id, double amount) {
        if(amount < 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        else return accountRepository.withdraw(id, amount);
    }

    public void transfer(int id, int id2, double amount) {
       if(withdrawal(id, amount)) {
           accountRepository.deposit(id2, amount);
       }
       else System.out.println("Transfer Failed");
    }
}

