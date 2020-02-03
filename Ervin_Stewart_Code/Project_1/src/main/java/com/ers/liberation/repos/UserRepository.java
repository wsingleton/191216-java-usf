package com.ers.liberation.repos;

import com.ers.liberation.models.Role;
import com.ers.liberation.models.User;
import com.ers.liberation.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User>{

    public Boolean updateAdmin(User updatedObj) {

        boolean updateSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "UPDATE ers_users SET user_role_id = ? " +
                    "WHERE ers_users_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updatedObj.getRole().getId());
            pstmt.setInt(2, updatedObj.getId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateSuccessful;

    }

    public Set<User> findUsersByRole(Role role) {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE user_role_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, role.getId());

            ResultSet rs = pstmt.executeQuery();
            users = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

    public Optional<User> findUserByUsername(String username) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
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
        System.out.println(username);
        System.out.println(password);
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public void save(User newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO ers_users VALUES (0, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"ers_user_id"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstName());
            pstmt.setString(4, newObj.getLastName());
            pstmt.setString(5,newObj.getEmail());
            pstmt.setInt(6, newObj.getRole().getId());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM ers_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

    @Override
    public Optional<User> findById(Integer id) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
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

        boolean updateSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "UPDATE ers_users SET ers_username = ?, ers_password = ?, user_first_name = ?, ers_last_name = ? " +
                    "WHERE ers_users_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedObj.getUsername());
            pstmt.setString(2, updatedObj.getPassword());
            pstmt.setString(3, updatedObj.getFirstName());
            pstmt.setString(4, updatedObj.getLastName());
            pstmt.setInt(5, updatedObj.getId());

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
    public Boolean deleteById(Integer id) {

        boolean deleteSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "DELETE FROM ers_users WHERE ers_users_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                deleteSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleteSuccessful;

    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {

        Set<User> users = new HashSet<>();

        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("ers_user_id"));
            temp.setUsername(rs.getString("ers_username"));
            temp.setPassword(rs.getString("ers_password"));
            temp.setFirstName(rs.getString("user_first_name"));
            temp.setLastName(rs.getString("user_last_name"));
            temp.setEmail(rs.getString("user_email"));
            temp.setRole(Role.getById(rs.getInt("user_role_id")));
            users.add(temp);
        }

        return users;

    }

}
