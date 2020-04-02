package com.revature.bank.repos;

import com.revature.bank.models.User;
import com.revature.bank.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    public Optional<User> findUserByUsername(String username){
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM CBANK.busers WHERE user_name = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return _user;
    }

    public Optional<User> findByCredentials(String username, String password){
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM CBANK.busers WHERE user_name = ? AND user_pass = ?";

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
        return _user;
    }


    @Override
    public void save(User newObj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO CBANK.busers VALUES ((SELECT MAX(user_id)+1 FROM CBANK.busers), ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newObj.getFirstName());
            pstmt.setString(2, newObj.getLastName());
            pstmt.setString(3, newObj.getUsrName());
            pstmt.setString(4, newObj.getPassWord());


            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    newObj.setUserId(rs.getInt(1));
                }
            }

        }
        catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(User updateObj) {
        return null;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while(rs.next()){
            User temp = new User();
            temp.setUserId(rs.getInt("user_id"));
            temp.setFirstName(rs.getString("user_fn"));
            temp.setLastName(rs.getString("user_ln"));
            temp.setUsrName(rs.getString("user_name"));
            temp.setPassWord(rs.getString("user_pass"));
            users.add(temp);
        }

        return users;
    }

}