package com.revature.repos;

import com.revature.AppDriver;
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


    @Override
    public  void save(AccountUser newObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO accounts_users VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newObj.getUserId());
            pstmt.setInt(2, newObj.getAccountId());

            int rowsInserted = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getAccountUser(User user){
        AccountRepository accountRepository = new AccountRepository();
        User currentUser = app().getCurrentSession().getSessionUser() ;
        int accountId;
        Account currentAccount = null;

        Set<AccountUser> AccountUsers = findAll();

        for (AccountUser u : AccountUsers) {
            if (u.getUserId() == currentUser.getUserId()){
                accountId = u.getAccountId();
                currentAccount = accountRepository.findById(accountId).get();
            }
        }
        if (currentAccount != null) {
            return currentAccount;
        }
        else throw new ResourceNotFoundException();
    }

    @Override
    public Set<AccountUser> findAll() {
        Connection conn = ConnectionFactory.getInstance().getConnection();
            Set<AccountUser> accountUsers = new HashSet<>();

            try {
                String sql = "SELECT * FROM accounts_users";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                accountUsers = mapResult(rs);
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
    public Boolean update(AccountUser updatedObj) throws SQLException {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    private Set<AccountUser> mapResult(ResultSet rs) throws SQLException {
        Set<AccountUser> accountUsers = new HashSet<>();

        while(rs.next()){
            AccountUser temp = new AccountUser(rs.getInt("userId"), rs.getInt("accountId"));

            accountUsers.add(temp);
        }
        return accountUsers;
    }
}
