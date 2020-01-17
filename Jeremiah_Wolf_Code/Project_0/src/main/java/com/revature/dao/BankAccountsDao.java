package com.revature.dao;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountsDao implements Database<User.Accounts_Bank, Integer> {

    @Override
    public List<User.Accounts_Bank> findAll() {

        List<User.Accounts_Bank> accounts_bank = new ArrayList<User.Accounts_Bank>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String query = "SELECT * FROM ACCOUNTS_BANK ORDER BY OWNER_ACCOUNT";

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                User.Accounts_Bank acc = new User.Accounts_Bank();
                acc.setId(rs.getInt(1));
                acc.setAccountOwner(rs.getInt(2));
                acc.setBalance(rs.getDouble(3));
                accounts_bank.add(acc);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

        return accounts_bank;

    }

    @Override
    public User.Accounts_Bank findById(Integer id) {

        User.Accounts_Bank bk = null;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ACCOUNT_BANK WHERE OWNER_ACCOUNT = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                bk = new User.Accounts_Bank();
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
    public User.Accounts_Bank save(User.Accounts_Bank obj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO ACCOUNT_BANK (OWNER_ACCOUNT, ACCOUNT_BALANCE) VALUES(?, ?)";
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
    public User.Accounts_Bank update(User.Accounts_Bank obj) {


        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "UPDATE ACCOUNT_BANK SET ACCOUNT_BALANCE = ? WHERE OWNER_ACCOUNT = ?";


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
    public void delete(User.Accounts_Bank obj) {
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