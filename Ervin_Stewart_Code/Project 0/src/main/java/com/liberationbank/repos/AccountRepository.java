package com.liberationbank.repos;

import com.liberationbank.models.*;
import com.liberationbank.models.Account;
import com.liberationbank.util.ConnectionFactory;


import java.sql.*;
import java.util.*;

import static com.liberationbank.AppDriver.currentAccount;

public class AccountRepository implements CrudRepository<Account> {
    private Integer key;
    private HashMap<Integer, Account> accountDb;


    public Optional<Account> getAccountByUserId(Integer userId){


        Optional<Account> _account = Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * " +
                    "FROM accounts a " +
                    "JOIN users_accounts ua " +
                    "ON a.account_id = ua.account_id " +
                    "JOIN users u " +
                    "ON u.user_id = ua.user_id " +
                    "WHERE u.user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            Set<Account> set = mapResultSet(rs);

            if(!set.isEmpty())_account= set.stream().findFirst();
        } catch (SQLException e)  {
            e.printStackTrace();
        }
        return _account;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> accounts = new HashSet<>();
        while (rs.next()) {
            Account temp = new Account();
            temp.setId(rs.getInt("account_id"));
            temp.setBalance(rs.getDouble("balance"));
            temp.setAccountType(AccountType.getAccountTypeById(rs.getInt("account_type_id")));
            accounts.add(temp);
        }
        return accounts;
    }

    public void updateCompositeKey(Account account, User user) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            CallableStatement callableStatement =
                    conn.prepareCall("{call set_users_accounts(?, ?)}");

            callableStatement.setInt(1, user.getId());
            callableStatement.setInt(2, account.getId());
            callableStatement.executeUpdate();
        }catch(SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void save(Account newObj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO lb_app.accounts VALUES (0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"account_id"});
            pstmt.setDouble(1, newObj.getBalance());
            pstmt.setInt(2,newObj.getAccountType().ordinal()+1);
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted!=0){
                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()){
                    newObj.setId(rs.getInt(1));
                }

            }
        }catch(SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public Set<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Account updatedObj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "UPDATE lb_app.accounts SET balance = ? WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, updatedObj.getBalance());
            pstmt.setInt(2,updatedObj.getId());
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted == 0){
                return false;
            }
        }catch(SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}


