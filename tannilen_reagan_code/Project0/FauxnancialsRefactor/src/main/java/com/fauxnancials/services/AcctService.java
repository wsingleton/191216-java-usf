package com.fauxnancials.services;

import com.fauxnancials.AppDriver;
import com.fauxnancials.exceptions.ResourceNotFoundException;
import com.fauxnancials.models.Acct;
import com.fauxnancials.models.AcctType;
import com.fauxnancials.repos.AccountRepository;
import com.fauxnancials.util.ConnectionFactory;
;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AcctService {
    private AccountRepository acctRepo;

    public AcctService(AccountRepository repo) {
        this.acctRepo = repo;
    }

    private Set<Acct> userAccts = new HashSet<>();

    public void populateAccounts() {
        userAccts = acctRepo.findByOwner(AppDriver.currentUser.getUserID());
    }

    public void showBals() {
        if (userAccts != null && !userAccts.isEmpty()) {
            for (Acct a : userAccts) {
                System.out.println(a.acctShow());
                System.out.println("");
            }
        } else {
            System.out.println("No accounts found for " + AppDriver.currentUser.getGivenName() + " " + AppDriver.currentUser.getFamilyName() + ".");
        }
    }

    public void createNewAcct(int acctType) {
        Acct temp = new Acct();
        temp.setAcctID(0);
        temp.setAcctType(AcctType.getAcctTypeById(acctType));
        temp.setBalance(0.0);
        temp.setUserID(AppDriver.currentUser.getUserID());
        System.out.println(temp.toString());
        acctRepo.save(temp);
        populateAccounts();
    }

    public Set<Acct> getUserAccts() {
        return userAccts;
    }

    public Acct pullAcct(int id) {
        Acct acct = acctRepo.findByID(id).orElseThrow(ResourceNotFoundException::new);
        return acct;
    }

    public Acct withdrawal(Acct acct, double wdAmt) {
        double currentBal = acct.getBalance();
        if (wdAmt > currentBal) {
            System.out.println("Insufficient funds to complete withdrawal.  Withdrawal cancelled.");
        } else {
            acct.setBalance(currentBal - wdAmt);
            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
                String sql = "UPDATE fauxnancials_admin.accounts SET acct_bal = ? WHERE acct_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, acct.getBalance());
                pstmt.setInt(2, acct.getAcctID());
                int balanceupdated = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return acct;
    }

    public Acct deposit(Acct acct, double dpAmt) {
        double currentBal = acct.getBalance();
        acct.setBalance(currentBal + dpAmt);
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "UPDATE fauxnancials_admin.accounts SET acct_bal = ? WHERE acct_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, acct.getBalance());
            pstmt.setInt(2, acct.getAcctID());
            int balanceupdated = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acct;
    }
}