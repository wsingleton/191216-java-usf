package com.reavture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reavture.pojo.Account;
import com.reavture.util.ConnectionFactory;

public class AccountsDao implements Dao<Account, Integer> {

    @Override
    public List<Account> findAll() {

        List<Account> account = new ArrayList<Account>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM ACCOUNTS ORDER BY USER_ID";

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {

                Account acc = new Account();
                acc.setAccountID(rs.getInt(1));
                acc.setBalance(rs.getInt(2));
                acc.setUser_id(rs.getInt(3));

                account.add(acc);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

        return account;

    }

    @Override
    public Account findById(Integer id) {

        Account ak = new Account();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ak = new Account();
                ak.setAccountID(rs.getInt(1));
                ak.setBalance(rs.getInt(2));
                ak.setUser_id(rs.getInt(3));
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        //System.out.println(ak.getUser_id());
        //System.out.println("DAOCHECK");
        //System.out.println(ak);

        return ak;
    }

    @Override
    public Account save(Account obj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES(?, ?)";
            String[] keyNames = {"ACCOUNT_ID"};

            PreparedStatement ps = conn.prepareStatement(sql, keyNames);

            ps.setInt(1, obj.getUser_id());
            ps.setInt(2, obj.getBalance());

            int numRows = ps.executeUpdate();

            if(numRows == 1) {

                ResultSet rs = ps.getGeneratedKeys();

                while(rs.next()) {

                    obj.setUser_id(rs.getInt(1));

                }

                conn.commit();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;

    }

    @Override
    public Account update(Account obj) {


        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USER_ID = ?";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, obj.getBalance());
            System.out.println("object balance in update = " + obj.getBalance());
            ps.setInt(2, obj.getUser_id());

            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;
    }

    public void delete(AccountsDao obj) {
        // TODO Auto-generated method stub

    }



}