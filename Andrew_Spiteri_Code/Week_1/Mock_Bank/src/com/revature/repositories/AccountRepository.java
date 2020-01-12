package com.revature.repositories;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.User;
import com.revature.services.AccountService;

import static com.revature.MockBankDriver.router;
import static com.revature.util.ConnectionFactory.*;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class AccountRepository{

    public Boolean save(Account account, Boolean isJoint){
        if(isJoint){
            try {
                String sql = "Insert into ACCOUNT values ( ?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setInt(1, account.getAccountNo());
                ps.setDouble(2,account.getAccAmount());
                ps.setString(3,account.getAccountType().name());
                Integer rowsReturned = ps.executeUpdate();

                Set<Integer> users = new HashSet<>();
                sql = "SELECT joint_id FROM isjoint WHERE user_id = ?";
                ps = getCon().prepareStatement(sql);
                ps.setInt(1, account.getId());
                ResultSet rs = ps.executeQuery();
                int joint_id = 0;
                while (rs.next()) {
                    joint_id = rs.getInt(1);
                }
                sql = "SELECT user_id FROM isjoint WHERE joint_id = ?";
                ps = getCon().prepareStatement(sql);
                ps.setInt(1,joint_id);
                rs = ps.executeQuery();
                while (rs.next()){
                    users.add(rs.getInt(1));
                }

                Integer[] userArray = new Integer[users.size()];
                userArray = users.toArray(userArray);

                sql = "INSERT ALL";
                for (Integer u :
                        users) {
                    sql += " INTO user_account VALUES (?,?) ";
                }
                sql += " SELECT * FROM dual";
                ps = getCon().prepareStatement(sql);
                for (int i = 0, j = 1; j < users.size() * 2; i++) {
                    ps.setInt(j, userArray[i]);
                    j++;
                    ps.setInt(j, account.getAccountNo());
                    j++;
                }
                rowsReturned += ps.executeUpdate();
                if(rowsReturned == 3){
                    return true;
                }
            }catch (SQLException e){
                System.out.println("Error code 300");
                router.navigate("/account");
            }
        }else{
            if(save(account)){
                return true;
            }
        }
        return false;
    }

    public Boolean save(Account account) {
        //TODO INSERT into table joint accounts
        try {
            if(AccountService.savingsAccount.getAccountType().equals(AccountType.SAVINGS) && AccountService.checkingAccount.getAccountType().equals(AccountType.CHECKING)){
                //String sql = "Insert into USER_ACCOUNT values (" + account.getId() +","+ account.getAccountNo() + ")";
                String sql = "Insert into USER_ACCOUNT values (?,?)";
                PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setInt(1,account.getId());
                ps.setInt(2,account.getAccountNo());
                int num = ps.executeUpdate();
                ps.close();
                if(num == 1){
                    return true;
                }else{
                    return false;
                }
            }
            String sql = "Insert into ACCOUNT values ( ?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, account.getAccountNo());
            ps.setDouble(2,account.getAccAmount());
            ps.setString(3,account.getAccountType().name());
            int num = ps.executeUpdate();
            sql = "Insert into USER_ACCOUNT values (?,?)";
            ps = getCon().prepareStatement(sql);
            ps.setInt(1,account.getId());
            ps.setInt(2,account.getAccountNo());
            num += ps.executeUpdate();
            ps.close();
            if(num == 2){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Failed: Driver Error: " + e.getMessage());
        }
        return false;
    }

    public Set<Account> findById(Integer id) {
        Set<Account> accountSet = new HashSet<>();
        try{
            String sql = "SELECT * FROM ACCOUNT JOIN USER_ACCOUNT ON ACCOUNT.ACCOUNTNO = USER_ACCOUNT.ACCOUNT_NO WHERE USER_ACCOUNT.USER_ID = ?";
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1,id);
            //sql = "SELECT * FROM ACCOUNT JOIN USER_ACCOUNT ON ACCOUNT.ACCOUNTNO = USER_ACCOUNT.ACCOUNT_NO WHERE USER_ACCOUNT.USER_ID =" + id;
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()) {

                while (rs.next()) {
                    Integer accountNo = rs.getInt("ACCOUNTNO");
                    Integer idNo = rs.getInt("USER_ID");
                    Double amount = rs.getDouble("AMOUNT");
                    AccountType type = AccountType.valueOf(rs.getString("TYPE"));
                    Account account = new Account(accountNo,idNo,amount,type);
                    accountSet.add(account);
                }
            }
        }catch (SQLException sqlE){
            sqlE.getSQLState();
        }
        return accountSet;
    }


    public boolean update(Account account, Double amount) {
        Double newAmount = account.getAccAmount() + amount;
        try {
            String sql = "UPDATE ACCOUNT set AMOUNT=? WHERE ACCOUNTNO =?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setDouble(1,newAmount);
            ps.setInt(2,account.getAccountNo());
            //sql = "UPDATE ACCOUNT set AMOUNT="+ newAmount + " WHERE ACCOUNTNO =" + account.getAccountNo();
            int rowsInserted = ps.executeUpdate();
            if(rowsInserted == 1){
                return true;
            }
        }catch (SQLException sqlE){
            System.err.println("Error in SQL Exception");
            sqlE.getSQLState();
        }
        return false;
    }


    public boolean deleteById(Integer id) {
        return false;
    }
}
