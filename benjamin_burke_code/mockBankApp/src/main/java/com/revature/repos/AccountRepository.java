package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



public class AccountRepository implements CrudRepository<Account> {
    private Integer key;
    private HashMap<Integer, Account>accountDb;

    public Optional<Account> getAccountByUserId(Integer userId) {
        Optional<Account> account = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql =  "SELECT * " +
                    "FROM accounts a " +
                    "JOIN accounts_users au " +
                    "ON a.account_id = au.account_id " +
                    "JOIN users u " +
                    "ON u.user_id = au.user_id " +
                    "WHERE u.user_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            Set<Account> set = mapResultSet(rs);

            if(!set.isEmpty()) account = set.stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;


    }

    public void updateCompositeKey(Account account, User user) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            CallableStatement callableStatement =
                    conn.prepareCall("{call set_users_accounts(?, ?)}");

            callableStatement.setInt(1, user.getUserId());
            callableStatement.setInt(2, account.getAccountId());
            callableStatement.executeUpdate();
        }catch(SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void save(Account newOjb) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO project0Bank.accounts VALUES(0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"account_id"});
            pstmt.setDouble(1, newOjb.getBalance());
            pstmt.setInt(2,newOjb.getAccountType().ordinal()+1);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newOjb.setAccountId(rs.getInt(1));
                }
        }


    }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<Account> findAll() {
//        Connection conn = app().getCurrentSession().getConnection();
//        Set<Account> accounts = new HashSet<>();
//
//        try {
//
//            String sql = "SELECT * FROM accounts";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            accounts = mapResultSet(rs);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return accounts;
        return null;
    }

    @Override
    public Optional<Account> findById(Integer userId) {
//        Connection conn = app().getCurrentSession().getConnection();
//        Optional<Account> account = Optional.empty();
//
//        try {
//
//            String sql = "SELECT * FROM accounts WHERE accountId = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, userId);
//
//            ResultSet rs = pstmt.executeQuery();
//           Set<Account> set = mapResultSet(rs);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return account;
        return Optional.empty();
    }

    @Override
    public Boolean update(Account updatedObj) {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        boolean updated = false;

        try {

            String sql = "UPDATE bank_app.accounts SET balance = ? WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, updatedObj.getBalance());
            pstmt.setInt(2, updatedObj.getAccountId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updated = true;
            }

        } catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> accounts = new HashSet<>();

        while (rs.next()) {
            Account temp = new Account();
            temp.setAccountId(rs.getInt("account_id"));
            temp.setBalance(rs.getDouble("balance"));
            temp.setAccountType(AccountType.getAccountTypeById(rs.getInt("account_type_id")));



            accounts.add(temp);
        }

        return accounts;
    }


}
