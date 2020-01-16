package com.revature.repos;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Account;
import com.revature.models.AccountUser;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.AppDriver.app;

public class AccountUserRepository implements CrudRepository<AccountUser> {
    public Account getAccountByUser(User user) {
        AccountRepository accountRepository = new AccountRepository();
        User currentUser = app().getCurrentSession().getSessionUser();
        int accountId;
        Account currentAccount = null;

        Set<AccountUser> accountUsers = findAll();

        for (AccountUser s : accountUsers) {
            if (s.getUserId() == currentUser.getUserId()){
                accountId = s.getAccountId();
                currentAccount = accountRepository.findById(accountId).get();
            }
        }
        if (currentAccount != null) {
            return currentAccount;
        }
        else throw new ResourceNotFoundException();


    }

    @Override
    public void save(AccountUser newOjb) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO bank_app.users_account VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newOjb.getUserId());
            pstmt.setInt(2, newOjb.getAccountId());

            int rowsInserted = pstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<AccountUser> findAll() {
        Connection conn = app().getCurrentSession().getConnection();
        Set<AccountUser> accountUsers = new HashSet<>();

        try {

            String sql = "SELECT * FROM bank_app.accounts_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            accountUsers = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountUsers;
    }

    @Override
    public Optional<AccountUser> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(AccountUser updatedObj) {
        return null;
    }

    private Set<AccountUser> mapResultSet(ResultSet rs) throws SQLException {
        Set<AccountUser> userAccounts = new HashSet<>();

        while (rs.next()) {
            AccountUser temp = new AccountUser(rs.getInt("user_id"), rs.getInt("account_id"));

            userAccounts.add(temp);
        }

        return userAccounts;
    }
}

