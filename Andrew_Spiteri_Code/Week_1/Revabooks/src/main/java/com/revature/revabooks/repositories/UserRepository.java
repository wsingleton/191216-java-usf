package com.revature.revabooks.repositories;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User> {

    Set<User> users = new HashSet<>();

    public Set<User> findUserByRole(Role role){


        return null;
    }

    public Optional<User> findUserByUsername(String username){
        Optional<User> _user = Optional.empty();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM rbs_app.users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!users.isEmpty()){
                _user = set.stream().findFirst();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return _user;
    }

    public Optional<User> findUserByCredentials(String username, String pw){
        Optional<User> _user = Optional.empty();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM rbs_app.users WHERE username = ? and password = ?";

            PreparedStatement pstmt =  conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, pw);

            ResultSet rs = pstmt.executeQuery();

            Set<User> set = mapResultSet(rs);

            if(!set.isEmpty()){
                _user = set.stream().findFirst();
            }
        }catch (SQLException e){
            e.getSQLState();
        }
        return _user;
    }


    @Override
    public void save(User user) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO rbs_app.users VALUES (0, ?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,new String [] {"user_id"});

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());
            pstmt.setInt(5, user.getRole().ordinal()+1);

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    user.setId(rs.getInt(1));
                }
            }
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM rbs_app.users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);
        }catch (SQLException e){
            e.getSQLState();
        }
        return users;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException{
        Set<User> users = new HashSet<>();
        while(rs.next()){
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setRole(Role.getRoleByID(rs.getInt("role_id")));
            users.add(temp);
        }
        return users;
    }

    //Optional is a way of avoiding returning nulls, no NullPointerException
    @Override
    public Optional<User> findById(Integer id) {

        return null;
    }

    @Override
    public Boolean update(User user) {

        return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return  false;
    }
}
