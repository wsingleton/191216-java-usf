package com.revature.repositories;

import com.revature.models.Account;
import com.revature.models.AccountType;
import static com.revature.util.ConnectionFactory.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class AccountRepository implements CrudRepository<Account> {

    @Override
    public Boolean save(Account account) {
        try {
            Connection con = createConnection();
            Statement statement = con.createStatement();
            String sql = "Insert into ACCOUNT values (" + account.getAccountNo() + ","
                    + account.getId() +","+account.getAccAmount()+",'"+account.getAccountType().getId()+"')";
            int num = statement.executeUpdate(sql);
            statement.close();
            if(num == 1){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Failed: Driver Error: " + e.getMessage());
        }
        return false;
    }

    public Set<Account> findById(Integer id) {
        Connection con = createConnection();
        try{
            Statement st = con.createStatement();
            String sql = "SELECT * FROM ACCOUNT WHERE ID =" + id;
            ResultSet rs = st.executeQuery(sql);
            if(rs.isBeforeFirst()) {
                Set<Account> accountSet = new HashSet<>();
                while (rs.next()) {
                    Integer accountNo = rs.getInt("ACCOUNTNO");
                    Integer idNo = rs.getInt("ID");
                    Double amount = rs.getDouble("AMOUNT");
                    //TODO CORRECT changes made to AccountType enum
                    AccountType type = AccountType.valueOf(rs.getString("TYPE"));
                    Account account = new Account(accountNo,idNo,amount,type);
                    accountSet.add(account);
                }
                return accountSet;
            }
        }catch (SQLException sqlE){
            sqlE.getSQLState();
        }
        return new HashSet<>();
    }


    public boolean update(Account account, Double amount) {
        Connection con = createConnection();
        Double newAmount = account.getAccAmount() + amount;
        try {
            Statement st = con.createStatement();
            String sql = "UPDATE ACCOUNT set AMOUNT="+ newAmount + " WHERE ACCOUNTNO =" + account.getAccountNo();
            int num = st.executeUpdate(sql);
            if(num == 1){
                return true;
            }
        }catch (SQLException sqlE){
            System.err.println("Error in SQL Exception");
            sqlE.getSQLState();
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
