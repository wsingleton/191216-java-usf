package com.liberationbank.repos;

import com.liberationbank.models.*;
import com.liberationbank.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserAccountRepository implements CrudRepository  {

   public UserAccount getUserAccountByUserId(Integer userId){

       UserAccount currentUserAccount = new UserAccount();
       Set<Account> accountSet = new HashSet<>();
       try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
           String sql = "SELECT * " +
                   "FROM users_accounts ua " +
                   "JOIN users u " +
                   "ON ua.user_id = u.user_id " +
                   "JOIN accounts a " +
                   "ON ua.account_id = a.account_id " +
                   "WHERE ua.user_id = ?";
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, userId);
           ResultSet rs = pstmt.executeQuery();
           User owner = new User();
           boolean ownerCreated = false;
           while (rs.next()) {
               if (!ownerCreated) {
                   owner.setId(rs.getInt("user_id"));
                   owner.setUserName(rs.getString("username"));
                   owner.setPassword(rs.getString("password"));
                   owner.setFirstName(rs.getString("first_name"));
                   owner.setLastName(rs.getString("last_name"));
                   owner.setRole(Role.getRoleById(rs.getInt("role_id")));
                   ownerCreated = true;
               }
               Account temp = new Account();
               temp.setId(rs.getInt("account_id"));
               temp.setBalance(rs.getDouble("balance"));
               temp.setAccountType(AccountType.getAccountTypeById(rs.getInt("account_type_id")));
               accountSet.add(temp);
           }
           currentUserAccount.setOwner(owner);
           currentUserAccount.setUserAccount(accountSet);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return currentUserAccount;
   }


    @Override
    public void save(Object newobj) {

    }

    @Override
    public Set findAll() {
        return null;
    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Object updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
