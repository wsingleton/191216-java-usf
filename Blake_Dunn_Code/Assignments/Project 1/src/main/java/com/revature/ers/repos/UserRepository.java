package com.revature.ers.repos;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    private static final Logger LOG = LogManager.getLogger(UserRepository.class);

    @Override
    public User save(User newUser) {

        LOG.info("Establishing connection with database.");
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Saving new user, {}, to database", newUser.getUsername());
            String sql = "INSERT INTO ers_users VALUES (0, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"userId"});
            pstmt.setString (1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setInt(6, newUser.getRole().getRoleId());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                LOG.info("New user saved successfully");
                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()) {
                    newUser.setUserId(rs.getInt(1));
                }
            }
        } catch(SQLIntegrityConstraintViolationException e) {
            LOG.warn(e.getMessage());
        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        return newUser;
    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        LOG.info("Establishing connection with database.");
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            LOG.info("Retrieving all users from database.");
            String sql = "SELECT * FROM ers_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);
        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("All users retrieved.");
        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {

        Optional<User> _user = Optional.empty();

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Retrieving user by id, {}", id);
            String sql = "SELECT * FROM ers_users WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        LOG.info("User found.");
        return _user;
    }

    @Override
    public Boolean update(User user) {

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Updating, {}, password", user.getUsername());
            String sql = "UPDATE ers_users SET password = ? WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setString (1, user.getPassword());
            pstmt.setInt(2, user.getUserId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated == 0) return false;

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("Password updated!");
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Deleting user from database.");
            String sql = "DELETE FROM ers_users WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted == 0){
                return false;
            }

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        LOG.info("User has been deleted.");
        return true;
    }

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> _user = Optional.empty();

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Checking user credentials");
            String sql = "SELECT * FROM ers_users WHERE username = ? AND password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
           _user =  mapResultSet(rs).stream().findFirst();

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        LOG.info("User was found!");
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

    public Optional<User> findUserByUsername(String username) {

        Optional<User> _user = Optional.empty();

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        LOG.info("User found by, {}", username);
        return _user;
    }

    public Set<User> findUsersByRole(Role role) {

        Set<User> users = new HashSet<>();

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Searching for users by, {}", role);
            String sql = "SELECT * FROM ers_users WHERE roleId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, role.getRoleId());

            ResultSet rs = pstmt.executeQuery();
            users = mapResultSet(rs);

        } catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        LOG.info("Users have been successfully retrieved.");
        return users;

    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();

        while (rs.next()) {
            User temp = new User();
            temp.setUserId(rs.getInt("userId"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("firstName"));
            temp.setLastName(rs.getString("lastName"));
            temp.setEmail(rs.getString("email"));
            temp.setRole(Role.getById(rs.getInt("roleId")));
            users.add(temp);
        }

        return users;
    }
}
