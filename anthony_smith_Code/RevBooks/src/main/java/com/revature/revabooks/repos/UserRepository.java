package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;


    public Set<User> findUsersByRole(Role role) {

    return null;

    }

    public void findUserByUsername(String username) {
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM rbs_app.users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs =pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> _user = null;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT* FROM rbs_app.users WHERE username = ? and password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);


            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
    }


    }

    @Override
    public void save(User newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO rbs_app.users VALUES(0, ?,?,?,?, 4 )";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"user_id"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstName());
            pstmt.setString(4, newObj.getLastName());

            int rowsInstreted = pstmt.executeUpdate();

            if (rowsInstreted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                }

            }
        } catch(SQLIntegrityConstraintViolationException e){
            e.printStackTrace();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

   @Override
    public Set<User> findAll() {

    return null;

    }

    @Override
    public Optional<User> findById(Integer id) {

        return null;

    }

    @Override
    public Boolean update(User updatedObj) {

        return false;

    }

    @Override
    public Boolean deleteById(Integer id) {
        return false;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setRole(Role.getRoleById(rs.getInt("role_id"))); // will come back to this
            users.add(temp);
        }
        return users;
    }
}

