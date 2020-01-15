package com.revature.bank2.repos;

import com.revature.bank2.models.User;
import com.revature.bank2.util.ConnectionFactory;

import java.sql.*;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;


public class UserRepository implements CrudRepository<User>  {

// ---------------- find new user from DB

public Optional<User> findUserByCredentials (String username, String password){


    Optional<User> user = Optional.empty();

    try (Connection conn = ConnectionFactory.getInstance().getConnection()){

        String sql_login = "Select * FROM bank.users WHERE username = ? AND password = ? ";
        PreparedStatement psmt = conn.prepareStatement(sql_login);
        psmt.setString(1, username);
        psmt.setString(2, password);

        ResultSet rs1 = psmt.executeQuery();
        user = mapResultSet(rs1).stream().findFirst();

    }   catch (SQLException e) {
           e.printStackTrace();
    }
        return user;
    }



//    public Optional<User> findUserByCredentials(String username, String password) {
//
//        Optional<User> user = Optional.empty();
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//
//            String sql = "SELECT * FROM rbs_app.users WHERE username = ? AND password = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
//            pstmt.setString(2, password);
//
//            ResultSet rs = pstmt.executeQuery();
//            user = mapResultSet(rs).stream().findFirst();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return user;
//
//    }


public void save(User newObj){
    try(Connection conn = ConnectionFactory.getInstance().getConnection()){

        String sql ="INSERT INTO bank.accounts Values (0,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"user_id"});

        pstmt.setString(1, newObj.getUserName());
        pstmt.setString(2, newObj.getEmail());
        pstmt.setString(3, newObj.getLastname());
        pstmt.setString(4, newObj.getFirstname());
        pstmt.setString(5, newObj.getPassword());
        pstmt.setInt(6, newObj.getUser_id());

                int rowsInserted = pstmt.executeUpdate();

              if (rowsInserted != 0) {

             ResultSet rs = pstmt.getGeneratedKeys();

             while (rs.next()) {
              newObj.setUser_id(rs.getInt(1));
            }

        }

    }catch(SQLException e) {
        e.printStackTrace();
    }
}
    private Set<User> mapResultSet(ResultSet rs) throws SQLException {

        Set<User> users = new HashSet<>();

        while (rs.next()) {
        User temp = new User();
     //   temp.setUser_id()(rs.getInt("user_id"));
        temp.setUserName(rs.getString("username"));
        temp.setPassword(rs.getString("password"));
        temp.setFirstname(rs.getString("firstname"));
        temp.setLastname(rs.getString("lastname"));
        users.add(temp);
        }

        return users;


    }
}


