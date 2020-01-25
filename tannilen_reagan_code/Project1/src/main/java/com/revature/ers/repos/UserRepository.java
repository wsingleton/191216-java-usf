package com.revature.ers.repos;

import com.revature.ers.models.User;
import com.revature.ers.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {
    public Optional<User> findUserByCredentials(String username, String password) {
        Optional<User> user = Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            System.out.println(conn);
            String sql = "SELECT * FROM proj_1_admin.ers_users WHERE ers_username=? AND ers_password=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, Integer.toString(password.hashCode()));
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public void save(User newUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO quizzard.app_user VALUES (0, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassHash());
            pstmt.setString(3, newUser.getFirst());
            pstmt.setString(4, newUser.getLast());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setInt(6, newUser.getRole());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    newUser.setUserID(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> user = Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "SELECT * FROM proj_1_admin.ers_users WHERE ers_users_id = ?";
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
    public boolean update(User user) {
        boolean updateSuccessful = false;
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "UPDATE proj_1_adamin.ers_users SET ers_username=?, ers_password=?, user_first_name=?, user_last_name=?, user_email=?, user_role_id=? " +
                    "WHERE ers_users_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassHash());
            pstmt.setString(3, user.getFirst());
            pstmt.setString(4, user.getLast());
            pstmt.setString(5, user.getEmail());
            pstmt.setInt(6, user.getRole());
            pstmt.setInt(7, user.getUserID());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateSuccessful;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
    private Set<User> mapResultSet(ResultSet rs) throws SQLException {

        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User tempUser = new User();
            tempUser.setUserID(rs.getInt("ers_users_id"));
            tempUser.setUsername(rs.getString("ers_username"));
            tempUser.setPassHash(rs.getString("ers_password"));
            tempUser.setFirst(rs.getString("user_first_name"));
            tempUser.setLast(rs.getString("user_last_name"));
            tempUser.setEmail(rs.getString("user_email"));
            tempUser.setRole(rs.getInt("user_role_id"));
            users.add(tempUser);
        }
        return users;
    }
}
