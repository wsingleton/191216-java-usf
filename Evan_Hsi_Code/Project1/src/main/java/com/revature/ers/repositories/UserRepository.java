package com.revature.ers.repositories;

import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.utils.ConnectionFactory;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {
    @Override
    public void save(User newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            System.out.println("save");

            String sql = "INSERT INTO ERS_APP.ERS_USERS VALUES (0, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"ERS_USERS_ID"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstname());
            pstmt.setString(4, newObj.getLastname());
            pstmt.setString(5, newObj.getEmail());
            pstmt.setInt(6, newObj.getRole().getId());
            System.out.println("help");

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("executed");

            if (rowsInserted != 0 ) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<User> findUserByUsername(String username) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_app.ERS_USERS WHERE ERS_USERNAME = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            _user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;

    }

    public Optional<User> findUserByCredentials(String username, String password) {
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ERS_APP.ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            _user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }
    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection() ) {

            String sql = "SELECT * FROM ERS_APP.ERS_USERS";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection(); ) {

            String sql = "SELECT * FROM ERS_APP.ERS_USERS WHERE ERS_USERS_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            _user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }

    public void confirmAccount(int id) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE ERS_APP.ERS_USERS SET USER_ROLE_ID = 1 WHERE ERS_USERS_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(User updatedObj) {
        boolean updateSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "UPDATE ERS_APP.ERS_USERS SET ERS_USERNAME = ?, ERS_PASSWORD = ?, " +
                    "USER_FIRST_NAME = ?, USER_LAST_NAME = ?, USER_EMAIL = ? WHERE ERS_USERS_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedObj.getUsername());
            pstmt.setString(2, updatedObj.getPassword());
            pstmt.setString(3, updatedObj.getFirstname());
            pstmt.setString(4, updatedObj.getLastname());
            pstmt.setString(5, updatedObj.getEmail());
            pstmt.setInt(6, updatedObj.getId());
            updateSuccessful = pstmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return updateSuccessful;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    public Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("ERS_USERS_ID"));
            temp.setUsername(rs.getString("ERS_USERNAME"));
            temp.setPassword(rs.getString("ERS_PASSWORD"));
            temp.setFirstname(rs.getString("USER_FIRST_NAME"));
            temp.setLastname(rs.getString("USER_LAST_NAME"));
            temp.setEmail(rs.getString("USER_EMAIL"));
            temp.setRole(Role.getById(rs.getInt("USER_ROLE_ID")));
            users.add(temp);
        }
        return users;
    }
}
