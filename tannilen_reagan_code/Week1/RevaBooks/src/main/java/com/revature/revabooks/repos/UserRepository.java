package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User> {
    public Set<User> findUsersByRole(Role role) {
        int roleID=0;
        switch (role) {
            case ADMIN:
                roleID=1;
                break;
            case MANAGER:
                roleID=2;
                break;
            case PREMIUM_MEMBER:
                roleID=3;
                break;
            case BASIC_MEMBER:
                roleID=4;
        }
        Set<User> users = new HashSet<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM revabooks_app.users WHERE role_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,roleID);
            ResultSet rs = pstmt.executeQuery(sql);
            users=mapResultSet(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public Optional<User> findUserByUsername(String username) {
        Optional<User> user = Optional.empty();
        try (Connection conn=ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM revabooks_app.users WHERE username=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> users=mapResultSet(rs);
            if (!users.isEmpty()) {
                user=users.stream().findFirst();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public Optional<User> findUserByCredentials(String username, String password) {
        Optional<User> user=Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = " SELECT * FROM revabooks_app.users WHERE username = ? AND pass_hash = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs=pstmt.executeQuery();
            Set<User> users=mapResultSet(rs);
            if (!users.isEmpty()) {
                user=users.stream().findFirst();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public void save(User user) {
        try (Connection conn=ConnectionFactory.getInstance().getConnection()) {
            String sql="insert into revabooks_app.users values (0, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt=conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());
            pstmt.setInt(5, user.getRole().ordinal()+1);
            int rowsInserted=pstmt.executeUpdate();
            if (rowsInserted!=0) {
                ResultSet rs=pstmt.getGeneratedKeys();
                while (rs.next()) {
                    user.setId(rs.getInt(1));
                }
            }
        }
        catch (SQLIntegrityConstraintViolationException sqe) {
            sqe.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM revabooks_app.users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users=mapResultSet(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public Optional<User> findByID(Integer id) {
        Optional<User> user = Optional.empty();
        try (Connection conn=ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM revabooks_app.users WHERE user_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id.toString());
            ResultSet rs = pstmt.executeQuery();
            Set<User> users=mapResultSet(rs);
            if (!users.isEmpty()) {
                user=users.stream().findFirst();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public boolean update(User user) {
        return false;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return false;
    }
    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp=new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("pass_hash"));
            temp.setFirstName(rs.getString("given_name"));
            temp.setLastName(rs.getString("family_name"));
            temp.setRole(Role.getRoleById(rs.getInt("role_id")));
            users.add(temp);
        }
        return users;
    }
}
