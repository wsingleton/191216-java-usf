package com.revature.fauxbankextended.repos;

import com.revature.fauxbankextended.exceptions.ResourceNotFoundException;
import com.revature.fauxbankextended.models.Account;
import com.revature.fauxbankextended.models.AccountType;
import com.revature.fauxbankextended.models.User;
import com.revature.fauxbankextended.util.ConnectionFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.fauxbankextended.BankDriver.app;


public class AccountRepository implements CrudRepository<Account> {

    private Integer key;
    private HashMap<Integer, Account> acctDb;

    public Set<Account> findAccountsById(Integer id) {

        Set<Account> accounts = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT a.acct_id, a.balance, a.type_id " +
                    "FROM accounts a " +
                    "JOIN users_accounts b " +
                    "ON a.acct_id = b.acct_id " +
                    "JOIN users u " +
                    "ON u.user_id = b.user_id " +
                    "WHERE u.user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            accounts = mapResultSet(rs);

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public Account getAccount(User user, Integer inputId) {
        Set<Account> accounts = findAccountsById(user.getId());
        Account acct = new Account();
        Optional<Account> _acct = accounts.stream().filter(a -> a.getId().equals(inputId)).findFirst();

        if (_acct.isPresent()) {
            acct = _acct.get();
        }
        else {
            throw new ResourceNotFoundException();
        }
        return acct;
    }

    @Override
    public Account save(Account newAccount) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO accounts (acct_id, type_id, balance) VALUES (0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"acct_id"});
            pstmt.setDouble (1, newAccount.getBalance());
            pstmt.setInt(2, newAccount.getAccountType().ordinal() +1);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()) {
                    newAccount.setId(rs.getInt(1));
                }
            }

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return newAccount;
    }

    @Override
    public Optional<Account> findById(Integer id) {

        Optional<Account> _acct = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT a.acct_id, a.balance, a.type_id " +
                    "FROM accounts a " +
                    "JOIN users_accounts b " +
                    "ON a.acct_id = b.acct_id " +
                    "JOIN users u " +
                    "ON u.user_id = b.user_id " +
                    "WHERE u.user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Set<Account> set = mapResultSet(rs);
            if (!set.isEmpty()) _acct = set.stream().findFirst();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return _acct;
    }

    @Override
    public Boolean update(Account updateAcct) {
        Connection conn = app().getCurrentSession().getConnection();
        try {

            String sql = "{call update_acct(?, ?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setDouble (1, updateAcct.getBalance());
            cstmt.setInt(2, updateAcct.getId());

            int rowsInserted = cstmt.executeUpdate();

            if (rowsInserted == 0) return false;

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> accounts = new HashSet<>();
        while (rs.next()) {
            Account temp = new Account();
            temp.setId(rs.getInt("acct_id"));
            temp.setAccountType(AccountType.getAccountTypeById(rs.getInt("type_id")));
            temp.setBalance(rs.getDouble("balance"));

            accounts.add(temp);
        }
        return accounts;
    }

}
