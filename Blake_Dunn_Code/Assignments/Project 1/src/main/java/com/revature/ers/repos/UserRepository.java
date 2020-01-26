package com.revature.ers.repos;

import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    @Override
    public User save(User newUser) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

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
                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()) {
                    newUser.setUserId(rs.getInt(1));
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
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return _user;
    }

    @Override
    public Boolean update(User user) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE ers_users SET password = ? WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setString (1, user.getPassword());
            pstmt.setInt(2, user.getUserId());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted == 0) return false;

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "DELETE FROM ers_users WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted == 0){
                return false;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE username = ? AND password = ?";

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

    public Optional<User> findUserByUsername(String username) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE username = ?";
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

    public Set<User> findUsersByRole(Role role) {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE roleId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, role.getRoleId());

            ResultSet rs = pstmt.executeQuery();
            users = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
        }

        return users;
    }
}
