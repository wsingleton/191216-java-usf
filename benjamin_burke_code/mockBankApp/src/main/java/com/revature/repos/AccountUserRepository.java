package com.revature.repos;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.*;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



public class AccountUserRepository implements CrudRepository {
//    public Account getAccountByUser(User user) {
//        AccountRepository accountRepository = new AccountRepository();
//        User currentUser = app().getCurrentSession().getSessionUser();
//        int accountId;
//        Account currentAccount = null;
//
//        Set<AccountUser> accountUsers = findAll();
//
//        for (AccountUser s : accountUsers) {
//            if (s.getUserId() == currentUser.getUserId()){
//                accountId = s.getAccountId();
//                currentAccount = accountRepository.findById(accountId).get();
//            }
//        }
//        if (currentAccount != null) {
//            return currentAccount;
//        }
//        else throw new ResourceNotFoundException();
//
//
//    }

    public AccountUser getUserAccountByUsrId(Integer userId){

        AccountUser currentAccountUser = new AccountUser();
        Set<Account> accountSet=new HashSet<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT *" +
                    "FROM account_users au" +
                    "JOIN users u" +
                    "ON au.user_id = u.user_id " +
                    "JOIN accounts a " +
                    "ON au.account_id = a.account_id " +
                    "WHERE au.user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            ResultSet rs = pstmt.executeQuery();
            User customer = new User();
            boolean customerCreated = false;
            while (rs.next()) {
                if(!customerCreated){
                    customer.setUserId(rs.getInt("user_id"));
                    customer.setUsername(rs.getString("username"));
                    customer.setPassword(rs.getString("password"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                    customer.setRole(Role.getRoleById(rs.getInt("role_id")));
                    customerCreated = true;
                }
                Account temp = new Account();
                temp.setAccountId(rs.getInt("account_id"));
                temp.setBalance(rs.getDouble("balance"));
                temp.setAccountType(AccountType.getAccountTypeById(rs.getInt("account_type_id")));
                accountSet.add(temp);
            }
            currentAccountUser.setCustomer(customer);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return currentAccountUser;
    }

//    @Override
//    public void save(AccountUser newOjb) {
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//
//            String sql = "INSERT INTO bank_app.users_account VALUES (?, ?)";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, newOjb.getUserId());
//            pstmt.setInt(2, newOjb.getAccountId());
//
//            int rowsInserted = pstmt.executeUpdate();
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void save(Object newOjb) {

    }

    @Override
    public Set<AccountUser> findAll() {
//        Connection conn = app().getCurrentSession().getConnection();
//        Set<AccountUser> accountUsers = new HashSet<>();
//
//        try {
//
//            String sql = "SELECT * FROM bank_app.accounts_users";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            accountUsers = mapResultSet(rs);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return accountUsers;
        return null;
    }

    @Override
    public Optional<AccountUser> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Object updatedObj) {
        return null;
    }


    public Boolean update(AccountUser updatedObj) {
        return null;
    }

//    private Set<AccountUser> mapResultSet(ResultSet rs) throws SQLException {
//        Set<AccountUser> userAccounts = new HashSet<>();
//
//        while (rs.next()) {
//            AccountUser temp = new AccountUser(rs.getInt("user_id"), rs.getInt("account_id"));
//
//            userAccounts.add(temp);
//        }
//
//        return userAccounts;
//    }
}

