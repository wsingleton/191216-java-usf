package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Accounts_Bank;
import com.revature.util.ConnectionFactory;

public class BankAccountsDao implements Dao<Accounts_Bank, Integer> {

    @Override
    public List<Accounts_Bank> findAll() {

        List<Accounts_Bank> bank_acc = new ArrayList<Accounts_Bank>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String query = "SELECT * FROM ACCOUNTS_BANK ORDER BY OWNER_ACCOUNT";

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                Accounts_Bank acc = new Accounts_Bank();
                acc.setId(rs.getInt("ACCOUNT_ID"));
                //acc.setAccountType(rs.getInt(2));
                acc.setAccountOwner(rs.getInt(3));
                acc.setBalance(rs.getDouble(4));
                bank_acc.add(acc);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

        return bank_acc;

    }

    @Override
    public Accounts_Bank findById(Integer id) {

        Accounts_Bank bk = null;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ACCOUNTS_BANK WHERE OWNER_ACCOUNT = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                bk = new Accounts_Bank();
                bk.setId(rs.getInt(1));
               // bk.setAccountType(rs.getInt(2));
                bk.setAccountOwner(rs.getInt(3));
                bk.setBalance(rs.getDouble(4));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return bk;
    }

    @Override
    public Accounts_Bank save(Accounts_Bank obj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "INSERT INTO ACCOUNTS_BANK ( OWNER_ACCOUNT, BALANCE_ACCOUNT) VALUES(?, ?)";
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
    public Accounts_Bank update(Accounts_Bank obj) {


        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "UPDATE ACCOUNTS_BANK SET BALANCE_ACCOUNT= ? WHERE  OWNER_ACCOUNT = ?";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1,  obj.getBalance());
           // ps.setInt(2, obj.getAccountType());
            ps.setInt(3, obj.getAccountOwner());
            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;
    }

    @Override
    public void delete(Accounts_Bank obj) {
        // TODO Auto-generated method stub

    }



}