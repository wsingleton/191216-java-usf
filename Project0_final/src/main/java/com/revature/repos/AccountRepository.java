package com.revature.repos;

import com.revature.models.User;
import com.revature.util.ConnectionMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Set findAll() {
        return null;
    }

    @Override
    public Optional findByUsername(String username) {
        return Optional.empty();
    }
}
