package com.revature.repos;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;

    public Optional<User> findUserByUsername(String username) {

        Optional <User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * from users WHERE username = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);


            if(!set.isEmpty()) {
                _user = set.stream().findFirst();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return _user;
    }

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> _user =Optional.empty();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = " select * from users where username = ? and password = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);

            if(!set.isEmpty()) {
                _user = set.stream().findFirst();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return _user;
    }

    @Override
    public void save(User newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = " INSERT INTO users VALUES(0,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"user_id"});


            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstName());
            pstmt.setString(4, newObj.getLastName());

            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    newObj.setId(rs.getInt(1));
                }
            }
                    }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }
        catch (SQLException b){
            b.printStackTrace();
        }
    }

    public Set<User> findAll() {

        Set<User> users = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection();){

            String sql = " SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Optional<User> findById(Integer id){
        return Optional.empty();
    }

    @Override
    public Boolean update(User updatedObj){
        return true;
    }

    @Override
    public Boolean deleteById(Integer id){
        return (userDb.remove(id) !=null);
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException{
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            users.add(temp);
        }
        return users;
    }
}
