package com.fauxnancials.repos;

import com.fauxnancials.models.User;
import com.fauxnancials.models.UserType;
import com.fauxnancials.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User> {
    public Optional<User> findUserByUsername(String username) {
        Optional<User> user = Optional.empty();
        try (Connection conn= ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM fauxnancials_admin.users WHERE username=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> users= mapResultSet(rs);
            if (!users.isEmpty()) {
                user=users.stream().findFirst();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public Optional<User> findUserByCredentials(String username, int passhash) {
        Optional<User> user=Optional.empty();
        try(Connection conn=ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM fauxnancials_admin.users WHERE username=? AND passhash=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setInt(2,passhash);
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
            String sql="insert into fauxnancials_admin.users values (0, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt=conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, user.getUsername());
            pstmt.setInt(2, user.getPassHash());
            pstmt.setString(3, user.getGivenName());
            pstmt.setString(4, user.getFamilyName());
            pstmt.setInt(5, user.getUserType().ordinal()+1);
            int rowsInserted=pstmt.executeUpdate();
            if (rowsInserted!=0) {
                ResultSet rs=pstmt.getGeneratedKeys();
                while (rs.next()) {
                    user.setUserID(rs.getInt(1));
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
    public Optional<User> findByID(Integer id) {
        return Optional.empty();
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
            temp.setUserID(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassHash(rs.getInt("passhash"));
            temp.setGivenName(rs.getString("given_name"));
            temp.setFamilyName(rs.getString("family_name"));
            temp.setUserType(UserType.getRoleById(rs.getInt("role_id")));
            users.add(temp);
        }
        return users;
    }
}
