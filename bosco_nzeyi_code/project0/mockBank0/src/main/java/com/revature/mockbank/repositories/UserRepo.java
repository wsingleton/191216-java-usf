package com.revature.mockbank.repositories;

import com.revature.mockbank.exceptions.AuthenticationException;
import com.revature.mockbank.models.Role;
import com.revature.mockbank.models.User;
import com.revature.mockbank.util.ConnectionFactory;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;
import java.util.*;
import static com.revature.mockbank.AppDriver.*;

public class UserRepo implements CrudRepository<User> {

    // the new generated key
    public int newId;
    // set the current user to the new data after signup
    public static User registeredUser;

    //map to save user registration inputs
   public HashMap<Integer, User> userDb = new HashMap<>();
    // keys
   public Integer key = 1;

    // overriding interface methods
    @Override
    public void save(User data) {
//        userDb.put(key, data);
//        key++;
        // save the new user to the database
        try (Connection con = new ConnectionFactory().getInstance().getConnection()){
            String sql = "INSERT INTO users (user_id, first_name, last_name, username, password)" +
                    "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"user_id"});

            pstmt.setInt(1, 0);
            pstmt.setString(2,data.getFirstName());
            pstmt.setString(3, data.getLastName());
            pstmt.setString(4, data.getUsername());
            pstmt.setString(5, data.getPassword());

            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted !=0){
                ResultSet rs = pstmt.getGeneratedKeys();
                registeredUser = data;
                while (rs.next()) {
                    newId = rs.getInt(1);
                    registeredUser.setId(rs.getInt(1));
                }
                System.out.println("Your new generated id is: " + newId);
            }

        }catch (SQLException e){
            System.err.println("Connection to the database could not be established ---- \n try again later");
            e.printStackTrace();
        }

    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
            try(Connection conn = ConnectionFactory.getInstance().getConnection()){

                String sql = "SELECT * FROM users";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                users = mapResultSet(rs);
            }catch (SQLException e){
                System.err.println("COULD NOT ESTABLISH CONNECTION");
            }
        return users;
    }

    // find user by username and password
    public Optional<User> findUserByCredentials(String username, String password){
        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }

    @Override
    public Optional <User> findById(Integer id) {
        for(Map.Entry<Integer, User> userData : userDb.entrySet()){
            if(userData.getValue().getId().equals(id)){
                return Optional.of(userData.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional findByUsername(String username) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if (!set.isEmpty()) _user = set.stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }

    @Override
    public Boolean update(Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
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
            temp.setRole(Role.CUSTOMER);
            users.add(temp);
        }

        return users;

    }
}
