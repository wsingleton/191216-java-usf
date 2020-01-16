package com.revature.repos;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import static com.revature.AppDriver.app;

public class UserRepository implements CrudRepository<User> {
    public Optional<User> findUserByUsername(String username) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public void save(User newOjb) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO bank_app.users VALUES (0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"});
            pstmt.setString(1, newOjb.getUsername());
            pstmt.setString(2, newOjb.getPassword());


            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newOjb.setUserId(rs.getInt(1));
                }
            }

        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();
        try ( Connection conn = app().getCurrentSession().getConnection();){

            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        } catch (SQLException e) {
            System.err.println("Can't establish connection");
        }

        return users;

    }

    @Override
    public Optional<User> findById(Integer id) {

        Connection conn = app().getCurrentSession().getConnection();
        Optional<User> user = Optional.empty();

        try {

            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public Boolean update(User updatedObj) {

        Connection conn = app().getCurrentSession().getConnection();
        boolean updated = false;

        try {

            String sql = "UPDATE users SET username = ?, password = ?" +
                    "WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedObj.getUsername());
            pstmt.setString(2, updatedObj.getPassword());
            pstmt.setInt(3, updatedObj.getUserId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updated = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;

    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();

        while (rs.next()) {
            User temp = new User();
//            temp.setUserId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            users.add(temp);
        }

        return users;
    }
}
