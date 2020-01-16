package com.bankboi.DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankboi.plainjava.BankAccounts;
import com.bankboi.util.InternetConnection;

public class BankData {

    @Override
    public List<BankData> findAll() {

        List<BankAccounts> accounts_bank = new ArrayList<BankAccounts>();

        try(Connection conn = InternetConnection.getInstance().getConnection()){

            String query = "SELECT * FROM ACCOUNTS_BANK ORDER BY OWNER_ACCOUNT";

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                BankAccounts acc = new BankAccounts();
                acc.setId(rs.getInt(1));
                acc.setAccountOwner(rs.getInt(2));
                acc.setBalance(rs.getDouble(3));
                accounts_bank.add(acc);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

        return findAll();

    }

    @Override
    public BankAccounts findById(Integer id) {

        BankAccounts bk = null;

        try(Connection conn = InternetConnection.getInstance().getConnection()) {

            String sql = "SELECT * FROM ACCOUNTS_BANK WHERE OWNER_ACCOUNT = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                bk = new BankAccounts();
                bk.setId(rs.getInt(2));
                bk.setAccountOwner(rs.getInt(1));
                bk.setBalance(rs.getDouble(3));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return bk;
    }

    @Override
    public BankAccounts save(BankAccounts obj) {

        try(Connection conn = InternetConnection.getInstance().getConnection()) {
            //If a connection is in auto-commit mode then all its SQL statements are run and committed as individual transactions.
            conn.setAutoCommit(false);

            String sql = "INSERT INTO ACCOUNTS_BANK (OWNER_ACCOUNT, ACCOUNT_BALANCE) VALUES(?, ?)";
            String[] keyNames = {"ACCOUNT_ID"};

            PreparedStatement ps = conn.prepareStatement(sql, keyNames);

            ps.setInt(1, obj.getAccountOwner());
            ps.setDouble(2, obj.getBalance());

            int numRows = ps.executeUpdate();

            if(numRows == 1) {

                ResultSet rs = ps.getGeneratedKeys();

                while(rs.next()) {

                    obj.setId(rs.getInt(1));

                }

                conn.commit();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;

    }

    @Override
    public BankAccounts update(BankAccounts obj) {


        try(Connection conn = InternetConnection.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "UPDATE ACCOUNTS_BANK SET ACCOUNT_BALANCE = ? WHERE OWNER_ACCOUNT = ?";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1,  obj.getBalance());
            ps.setInt(2, obj.getAccountOwner());
            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;
    }

    @Override
    public void delete(BankAccounts obj) {
        // TODO Auto-generated method stub

    }

/*
@Override
    public Set<User> findAll() {
    try(Connection conn = ConnectionFactory.getInstance().getConnection())
             conn.setAutoCommit(false);
            String sql = "SELECT * FROM ACCOUNTS_BANK ORDER BY OWNER_ACCOUNT";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Accounts_Bank acc = new Accounts_Bank();
                acc.setId(rs.getInt(1));
                acc.setAccountOwner(rs.getInt(2));
                acc.setBalance(rs.getDouble(3));
                accounts_bank.add(acc);
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
 */

}
