package com.revature.repos;

import com.revature.models.User;
import com.revature.util.ConnectionMaker;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User>{
    @Override
    public void save(User newUser) {

        try  {
            Connection connection = ConnectionMaker.getInstance().liveConnection();
            PreparedStatement pstmt =
                    connection.prepareStatement("INSERT INTO banking_app.users VALUES (?,?,?)",
                            new String[] {"username"});

            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, "0.0");

            pstmt.executeQuery();

            System.out.println("your info has been added");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {

        Connection connection = ConnectionMaker.getInstance().liveConnection();
        Set<User> users = new HashSet<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM banking_app.users");
            while (results.next()) {
                User temp = new User();
                temp.setUsername(results.getString("username"));
                temp.setPassword(results.getString("password"));
                temp.setBalance(results.getDouble("balance"));
                users.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findByUsername(String username) {

        Optional<User> _user = Optional.empty();

        try (Connection connection = ConnectionMaker.getInstance().liveConnection()) {

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM banking_app.users WHERE username = ?");
            pstmt.setString(1, username);
            ResultSet results = pstmt.executeQuery();
            _user = mapResultSet(results).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _user;
    }

    private Set<User> mapResultSet(ResultSet results) throws SQLException {

        Set<User> users = new HashSet<>();
        User temp = new User();
        while (results.next()) {
            temp.setUsername(results.getString("username"));
            temp.setPassword(results.getString("password"));
            temp.setBalance(results.getDouble("balance"));
            users.add(temp);
        }

        return users;

    }

}
