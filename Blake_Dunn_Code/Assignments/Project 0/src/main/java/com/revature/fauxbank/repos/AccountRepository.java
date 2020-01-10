package com.revature.fauxbank.repos;

import com.revature.fauxbank.models.Account;
import com.revature.fauxbank.models.User;
import com.revature.fauxbank.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class AccountRepository implements CrudRepository<Account> {

    private Integer key;
    private HashMap<Integer, Account> acctDb;

    public Optional findByAccountNumber(Integer accountNumber) {

        return null;
    }

    @Override
    public Account save(Account newAccount) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO accounts VALUES (0, ?, ?)";
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

            String sql = "SELECT a.acct_id, a.balance " +
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
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE accounts SET balance = ? WHERE acct_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble (1, updateAcct.getBalance());
            pstmt.setInt(2, updateAcct.getId());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted == 0) return false;

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> accounts = new HashSet<>();
        while (rs.next()) {
            Account temp = new Account();
            temp.setId(rs.getInt("acct_id"));
            temp.setBalance(rs.getDouble("balance"));

            accounts.add(temp);
        }
        return accounts;
    }

}
