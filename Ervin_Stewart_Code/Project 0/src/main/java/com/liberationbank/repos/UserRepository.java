package com.liberationbank.repos;

import com.liberationbank.models.Role;
import com.liberationbank.models.User;
import com.liberationbank.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User>{
    private Integer key;
    private HashMap<Integer, User> UserDb;



    public Optional<User> findByUserName(String username){
        Optional<User> _user = Optional.empty();
        try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
            String sql = "SELECT * FROM lb_app.users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();

        }catch(SQLException e){e.printStackTrace();}

        return _user;
    }

    public Optional<User> findUserByCredentials(String username, String password){
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM lb_app.users WHERE username =? AND password =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return _user;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUserName(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setRole(Role.getRoleById(rs.getInt("role_id")));
            users.add(temp);
        }
        return users;
    }

    @Override
        public void save(User newObj) {
            try(Connection conn = ConnectionFactory.getInstance().getConnection()){
                String sql = "INSERT INTO lb_app.users VALUES (0, ?, ?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"user_id"});
                pstmt.setString(3, newObj.getUserName());
                pstmt.setString(4,newObj.getPassword());
                pstmt.setString(1,newObj.getFirstName());
                pstmt.setString(2,newObj.getLastName());
                pstmt.setInt(5,newObj.getRole().ordinal()+1);
                int rowsInserted = pstmt.executeUpdate();
                if(rowsInserted!=0){
                    ResultSet rs = pstmt.getGeneratedKeys();

                    while(rs.next()){
                        newObj.setId(rs.getInt(1));
                    }

                }
            }catch(SQLIntegrityConstraintViolationException e){
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        try(Connection conn =  ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM lb_app.users";

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            users =mapResultSet(rs);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(User updatedObj) {
       return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
      return null;
    }
}
