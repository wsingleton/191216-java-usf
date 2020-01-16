package com.revature.repos;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.AppDriver.app;

public class AccountRepository implements CrudRepository<Account> {

    public Optional<Account> findByUsername(String username) {
        Optional<Account> account = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM accounts WHERE username = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            account = mapResultSet(rs).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;


    }

    @Override
    public void save(Account newOjb) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO accounts VALUES(0, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"account_id"});
            pstmt.setDouble(1, newOjb.getBalance());
            pstmt.setString(2, app().getCurrentSession().getSessionUser().getUsername());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newOjb.setAccountId(rs.getInt(1));
                }
        }

    }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<Account> findAll() {
        Connection conn = app().getCurrentSession().getConnection();
        Set<Account> accounts = new HashSet<>();

        try {

            String sql = "SELECT * FROM accounts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            accounts = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        Connection conn = app().getCurrentSession().getConnection();
        Optional<Account> account = Optional.empty();

        try {

            String sql = "SELECT * FROM accounts WHERE accountId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            account = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public Boolean update(Account updatedObj) {
        Connection conn = app().getCurrentSession().getConnection();
        boolean updated = false;

        try {

            String sql = "UPDATE accounts SET balance = ?" +
                    "WHERE accountId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updatedObj.getAccountId());
            pstmt.setDouble(2, updatedObj.getBalance());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updated = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> accounts = new HashSet<>();

        while (rs.next()) {
            Account temp = new Account();
            temp.setAccountId(rs.getInt("accountId"));
            temp.setBalance(rs.getDouble("balance"));
           

            accounts.add(temp);
        }

        return accounts;
    }


}
