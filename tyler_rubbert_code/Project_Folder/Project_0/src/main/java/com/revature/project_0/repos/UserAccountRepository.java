package com.revature.project_0.repos;

import com.revature.project_0.exceptions.ResourceNotFoundException;
import com.revature.project_0.models.Account;
import com.revature.project_0.models.User;
import com.revature.project_0.models.UserAccount;
import com.revature.project_0.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.project_0.AppDriver.app;

public class UserAccountRepository implements CrudRepository<UserAccount> {


    public Account getAccountByUser(User user) {
        AccountRepository accountRepository = new AccountRepository();
        User currentUser = app().getCurrentSession().getSessionUser();
        int accountId;
        Account currentAccount = null;

        Set<UserAccount> userAccounts = findAll();

        for (UserAccount s : userAccounts) {
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
    public void save(UserAccount newOjb) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO user_accounts VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newOjb.getUserId());
            pstmt.setInt(2, newOjb.getAccountId());

            int rowsInserted = pstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<UserAccount> findAll() {
        Connection conn = app().getCurrentSession().getConnection();
        Set<UserAccount> userAccounts = new HashSet<>();

        try {

            String sql = "SELECT * FROM user_accounts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            userAccounts = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userAccounts;
    }

    @Override
    public Optional<UserAccount> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(UserAccount updatedObj) {
        return null;
    }

    private Set<UserAccount> mapResultSet(ResultSet rs) throws SQLException {
        Set<UserAccount> userAccounts = new HashSet<>();

        while (rs.next()) {
            UserAccount temp = new UserAccount(rs.getInt("user_id"), rs.getInt("account_id"));

            userAccounts.add(temp);
        }

        return userAccounts;
    }
}
