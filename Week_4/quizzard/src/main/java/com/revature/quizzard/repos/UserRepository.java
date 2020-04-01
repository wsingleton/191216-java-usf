package com.revature.quizzard.repos;

import com.revature.quizzard.exceptions.QuizzardException;
import com.revature.quizzard.models.Role;
import com.revature.quizzard.models.User;
import com.revature.quizzard.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    private static final UserRepository userRepo = new UserRepository();

    private UserRepository() {
        super();
    }

    public static UserRepository getInstance() {
        return userRepo;
    }

    public Set<User> findUsersByRole(Role role) {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM quizzard.app_user WHERE role_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, role.getId());

            ResultSet rs = pstmt.executeQuery();
            users = mapResultSet(rs);

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

        return users;

    }

    public Optional<User> findUserByUsername(String username) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM quizzard.app_user WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

        return user;

    }

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM quizzard.app_user WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

        return user;

    }

    public void confirmAccount(int confirmedUserId) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "UPDATE quizzard.app_user SET confirmed = ? WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setInt(2, confirmedUserId);
            System.out.println(pstmt.executeUpdate());

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

    }

    @Override
    public void save(User newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO quizzard.app_user VALUES (0, ?, ?, ?, ?, ?, ?, 0)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstName());
            pstmt.setString(4, newObj.getLastName());
            pstmt.setInt(5, newObj.getRole().getId());
            pstmt.setString(6, newObj.getEmail());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                }

            }

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }
    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM quizzard.app_user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

        return users;

    }

    @Override
    public Optional<User> findById(int id) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM quizzard.app_user WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

        return user;

    }

    @Override
    public void update(User updatedObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "UPDATE quizzard.app_user SET username = ?, password = ?, email = ?, first_name = ?, last_name = ? " +
                    "WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedObj.getUsername());
            pstmt.setString(2, updatedObj.getPassword());
            pstmt.setString(3, updatedObj.getEmail());
            pstmt.setString(4, updatedObj.getFirstName());
            pstmt.setString(5, updatedObj.getLastName());
            pstmt.setInt(6, updatedObj.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

    }

    @Override
    public void deleteById(int id) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "DELETE FROM quizzard.app_user WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new QuizzardException(e);
        }

    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {

        Set<User> users = new HashSet<>();

        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setEmail(rs.getString("email"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setRole(Role.getById(rs.getInt("role_id")));
            temp.setAccountConfirmed(rs.getInt("confirmed"));
            users.add(temp);
        }

        return users;

    }

}
