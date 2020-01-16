package com.revature.fauxbankextended.services;

import com.revature.fauxbankextended.exceptions.InvalidRequestException;
import com.revature.fauxbankextended.exceptions.ResourceNotFoundException;
import com.revature.fauxbankextended.models.Account;
import com.revature.fauxbankextended.models.Transaction;
import com.revature.fauxbankextended.models.TransactionType;
import com.revature.fauxbankextended.models.User;
import com.revature.fauxbankextended.repos.AccountRepository;
import com.revature.fauxbankextended.repos.TransactionRepository;
import com.revature.fauxbankextended.util.ConnectionFactory;
import com.revature.fauxbankextended.util.UserSession;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.Set;

import static com.revature.fauxbankextended.BankDriver.*;

public class AccountService {

    private AccountRepository acctRepo;
    private TransactionRepository transRepo;

    public AccountService(AccountRepository repo, TransactionRepository transRepo) {
        this.acctRepo = repo;
        this.transRepo = transRepo;
    }

    public boolean validateDeposit(String amount) {

        Double balance = app().getCurrentSession().getSessionAccount().getBalance();

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            return false;
        }

        Double deposit = Double.valueOf(amount);

        if (deposit < 0 || deposit > 10000) {
            deposit = 0.0;
            System.out.println("Try again!");
            return false;
        }
        Double updatedDeposit = convertAmount(deposit);

        balance += updatedDeposit;
        Double bal = convertAmount(balance);
        app().getCurrentSession().getSessionAccount().setBalance(bal);
        acctRepo.update(app().getCurrentSession().getSessionAccount());
        Transaction newTransaction = new Transaction(app().getCurrentSession().getSessionUser().getId(),
                app().getCurrentSession().getSessionAccount().getId(), updatedDeposit, TransactionType.DEPOSIT);
        transRepo.save(newTransaction);

        return true;
    }

    public boolean validateWithdraw(Double balance, String amount) {

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            return false;
        }

        Double withdraw = Double.valueOf(amount);

        if (withdraw > balance || withdraw < 0) {
            withdraw = 0.0;
            System.out.println("Try again!");
            return false;
        }
        Double updatedWithdraw = convertAmount(withdraw);

        balance -= updatedWithdraw;
        Double bal = convertAmount(balance);
        app().getCurrentSession().getSessionAccount().setBalance(bal);
        acctRepo.update(app().getCurrentSession().getSessionAccount());
        Transaction newTransaction = new Transaction(app().getCurrentSession().getSessionUser().getId(),
                app().getCurrentSession().getSessionAccount().getId(), updatedWithdraw * -1, TransactionType.WITHDRAW);
        transRepo.save(newTransaction);

        return true;
    }

    public Double convertAmount (Double amount) {

        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        return bigDecimal.setScale(2, RoundingMode.DOWN).doubleValue();

    }

    public boolean chooseAccount(User user) {
        Set<Account> accounts= acctRepo.findAccountsById(user.getId());
        Account acct = new Account();

        System.out.println("\n");
        System.out.println("+--- Current Accounts ---+\n");
        for(Account a : accounts) {
            System.out.println(a);
        }
        System.out.println("\n+--- Choose Account ---+");

        try {
            System.out.print("> ");
            String choice = app().getConsole().readLine();

            if (choice == null || choice.equals("") || choice.matches("^[a-zA-Z]*$")) return false;

            Integer acctNum = Integer.parseInt(choice);
            acct = getAccount(user, acctNum);
        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

        app().setCurrentSession(new UserSession(user, acct, ConnectionFactory.getInstance().getConnection()));
        return true;
    }

    public Account getAccount(User user, Integer inputId) {
        Set<Account> accounts = acctRepo.findAccountsById(user.getId());
        Account acct = new Account();
        Optional<Account> _acct = accounts.stream().filter(a -> a.getId().equals(inputId)).findFirst();

        if (_acct.isPresent()) {
            acct = _acct.get();
        }
        else {
            throw new ResourceNotFoundException();
        }
        return acct;
    }

    public boolean transferMoney () {

        Set<Account> accounts = acctRepo.findAccountsById(app().getCurrentSession().getSessionUser().getId());
        Account acct1 = new Account();

        if (accounts.size() < 2) return false;

        System.out.println("\n\n");
        System.out.println("You are currently logged into your " + app().getCurrentSession().getSessionAccount().getAccountType()
                + " account, Account Id: " + app().getCurrentSession().getSessionAccount().getId() + "  Balance: " +
                app().getCurrentSession().getSessionAccount().getBalance());
        System.out.println("\n+--- Accounts ---+\n");

        for(Account a : accounts) {
            System.out.println(a);
        }

        System.out.println("\n+--- Transfer To ---+");
        System.out.print("Enter account number >  ");
        try{
            String option1 = app().getConsole().readLine();
            Integer choice1 = Integer.parseInt(option1);

            if (option1 == null || option1.equals("") || option1.matches("^[a-zA-Z]*$")) {
                System.out.println("Try again!");
                return false;
            }

            if(choice1 == app().getCurrentSession().getSessionAccount().getId()) throw new InvalidRequestException();

            Optional<Account> _acct1 = accounts.stream().filter(a -> a.getId().equals(choice1)).findFirst();

            if (_acct1.isPresent()) {
                acct1 = _acct1.get();
            }
            else {
                throw new ResourceNotFoundException();
            }

            Double a1bal = acct1.getBalance();
            Double a2bal = app().getCurrentSession().getSessionAccount().getBalance();

            System.out.println("\n\n+--- Transfer Amount ---+");
            System.out.print("> ");
            String amount = app().getConsole().readLine();

            if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
                System.out.println("Try again!");
                return false;
            }
            Double transferAmount = Double.parseDouble(amount);

            if (transferAmount >= app().getCurrentSession().getSessionAccount().getBalance() || transferAmount < 0) {
                return false;
            }
            Double updatedTransfer = convertAmount(transferAmount);

            a1bal += updatedTransfer;
            a2bal -= updatedTransfer;

            acct1.setBalance(a1bal);
            app().getCurrentSession().getSessionAccount().setBalance(a2bal);

            acctRepo.update(acct1);
            acctRepo.update(app().getCurrentSession().getSessionAccount());

            Transaction newTransaction = new Transaction(app().getCurrentSession().getSessionUser().getId(),
                    acct1.getId(), updatedTransfer, TransactionType.TRANSFER);
            Transaction newTransaction1 = new Transaction(app().getCurrentSession().getSessionUser().getId(),
                    app().getCurrentSession().getSessionAccount().getId(), updatedTransfer * -1, TransactionType.TRANSFER);
            transRepo.save(newTransaction);
            transRepo.save(newTransaction1);

        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

        return true;
    }
}
