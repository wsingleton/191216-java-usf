package com.revature.project_0.repos;


import com.revature.project_0.models.Account;
import com.revature.project_0.models.AccountType;
import com.revature.project_0.models.User;
import com.revature.project_0.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.project_0.AppDriver.app;

public class AccountRepository implements CrudRepository<Account>{

    public Optional<Account> findByUsername(String username) {
        Optional<Account> account = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM accounts WHERE creator_username = ?";
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

            String sql = "INSERT INTO accounts VALUES (0, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"account_id"});
            pstmt.setDouble(1, newOjb.getBalance());
            pstmt.setInt(2, newOjb.getAccountType().ordinal() + 1);
            pstmt.setString(3, app().getCurrentSession().getSessionUser().getUsername());


            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newOjb.setAccountId(rs.getInt(1));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Account> findAll() {
        Connection conn = app().getCurrentSession().getConnection();
        Set<Account> accounts = new HashSet<>();

        try {

            String sql = "{call get_all_accounts()}";
            CallableStatement cstmt = conn.prepareCall(sql);
            ResultSet rs = cstmt.executeQuery(sql);
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

            String sql = "SELECT * FROM accounts WHERE account_id = ?";
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
        boolean updateSuccessful = false;

        try {

            String sql = "UPDATE accounts SET balance = ?" +
                    "WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, updatedObj.getBalance());
            pstmt.setInt(2, updatedObj.getAccountId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateSuccessful;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> accounts = new HashSet<>();

        while (rs.next()) {
            Account temp = new Account();
            temp.setAccountId(rs.getInt("account_id"));
            temp.setBalance(rs.getDouble("balance"));
            temp.setAccountType(AccountType.getAccountTypeById(rs.getInt("account_type")));

            accounts.add(temp);
        }

        return accounts;
    }
}
