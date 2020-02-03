package com.revature.repos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {
    // substitution, got tired of typing this later on
    private Set<User> mapResults(ResultSet results) throws SQLException {
        Set<User> users = new HashSet<>();

        while (results.next()) {
            User temp = new User();
            temp.setId(results.getInt("ers_user_id"));
            temp.setUsername(results.getString("ers_username"));
            temp.setPassword(results.getString("ers_password"));
            temp.setFirstName(results.getString("user_first_name"));
            temp.setLastName(results.getString("user_last_name"));
            temp.setEmail(results.getString("user_email"));
            temp.setRole(Role.getById(results.getInt("user_role_id")));
            users.add(temp);
        }
        return users;
    }

    @Override
    public void save(User newUser) {

        try{

            Connection connection = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO xnd_inc.ers_user VALUES (0, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"ers_user"});
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setInt(6, newUser.getRole().getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Set<User> users = new HashSet<>();

        try {

            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM xnd_inc.ers_user");
            while (results.next()) {
                User temp = new User();
                temp.setId(results.getInt("ers_user_id"));
                temp.setUsername(results.getString("ers_username"));
                temp.setPassword(results.getString("ers_password"));
                temp.setFirstName(results.getString("user_first_name"));
                temp.setLastName(results.getString("user_last_name"));
                temp.setEmail(results.getString("user_email"));
                temp.setRole(Role.getById(results.getInt("user_role_id")));
                users.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional <User> findById(int id) {
        Optional<User> _user = Optional.empty();
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try {
            String sql = "SELECT * FROM xnd_inc.ers_user WHERE ers_user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();
            _user = mapResults(results).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _user;
    }

    @Override
    public boolean update(User updatedObj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
