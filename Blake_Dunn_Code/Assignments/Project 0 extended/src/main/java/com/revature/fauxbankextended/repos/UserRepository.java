package com.revature.fauxbankextended.repos;

import com.revature.fauxbankextended.exceptions.AuthenticationException;
import com.revature.fauxbankextended.models.Account;
import com.revature.fauxbankextended.models.User;
import com.revature.fauxbankextended.util.ConnectionFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.fauxbankextended.BankDriver.*;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return _user;
    }

    public User getUser(String username, String password) {
        User user = new User();
        Optional<User> _user = findUserByCredentials(username, password);
        if (_user.isPresent()){
            user = _user.get();
        }
        else {
            throw new AuthenticationException();
        }
        return user;
    }

    public Optional<User> findUserByUserName(String username) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }

    @Override
    public User save(User newUser) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO users VALUES (0, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString (1, newUser.getUserName());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()) {
                    newUser.setId(rs.getInt(1));
                }
            }

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return newUser;

    }

    @Override
    public Optional<User> findById(Integer id) {

        return null;
    }

    @Override
    public Boolean update(User updateUser) {

        return false;

    }

    public Boolean updateCompositeKey(User user, Account account) {
        Connection conn = app().getCurrentSession().getConnection();

        try {

            String sql = "INSERT INTO users_accounts VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setInt(2, account.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUserName(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            users.add(temp);
        }
        return users;
    }
}
