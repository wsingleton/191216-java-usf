package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements BankActionRepository<User> {
    @Override
    public void save(User newObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            Account acct = new Account();
            acct.setBalance(250.0);

            String sql = "INSERT INTO bank_app.users VALUES (?,?,?)";
            String sql1 = "INSERT INTO bank_app.accounts VALUES (?,?)";

            //to get generated id, has to be a string array(because you can potentially have multiple generated ids, column that will have generated id
            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, Integer.toString(newObj.getUsername().hashCode()));
            pstmt1.setDouble(2, acct.getBalance());
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, Integer.toString(newObj.getUsername().hashCode()));

            //returns the number of rows that were affected
            pstmt1.executeUpdate();
            pstmt.executeUpdate();
        } catch( SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean update(User updatedObj) {
        return null;
    }

    public Optional<User> findUserByUsername(String username){
        Optional<User> _user = Optional.empty();


        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM bank_app.users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();

        }catch(SQLException e){

        }

        return _user;
    }


    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM bank_app.users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()){
                _user = set.stream().findFirst();
            }
        }catch (SQLException e){
        }
        return _user;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setAccountId(Integer.parseInt(Integer.toString(rs.getString("username").hashCode())));
            users.add(temp);
        }

        return users;
    }

}
