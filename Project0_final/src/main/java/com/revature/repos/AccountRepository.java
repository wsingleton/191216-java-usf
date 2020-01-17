package com.revature.repos;

import com.revature.models.User;
import com.revature.util.ConnectionMaker;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountRepository implements CrudRepository<User> {

    @Override
    public void save(User currentUser) {
        try  {
            Connection connection = ConnectionMaker.getInstance().liveConnection();
            PreparedStatement pstmt =
                    connection.prepareStatement("UPDATE banking_app.users SET balance = ?" +
                                    "WHERE username = ?");

            pstmt.setString(2, currentUser.getUsername());
            pstmt.setDouble(1, currentUser.getBalance());

            pstmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {

        HashSet<User> accounts = new HashSet<>();

        try {

            Connection connection = ConnectionMaker.getInstance().liveConnection();
            CallableStatement cstmt = connection.prepareCall("{CALL banking_app.allAccounts}");
            ResultSet results = cstmt.executeQuery();

            while(results.next()) {
                User temp = new User();
                temp.setUsername(results.getString("username"));
                accounts.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public Optional findByUsername(String username) {
        return Optional.empty();
    }
}
