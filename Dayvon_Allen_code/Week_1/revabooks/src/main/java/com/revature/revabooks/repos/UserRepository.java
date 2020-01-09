package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserRepository implements CrudRepository<User> {



    public Set<User> findUsersByRole(Role role){
        return null;
    }

    @Override
    public void save(User newObj) {

    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM rbs_app.users";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User temp = new User();
                temp.setId(rs.getInt("user_id"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setFirstName(rs.getString("first_name"));
                temp.setLastName(rs.getString("last_name"));
                temp.setRole(Role.BASIC_MEMBER);
                users.add(temp);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    public Optional<User> findUserByUsername(String username){
        return null;
    }

    public Optional<User> findUserByCredentials(String username, String password){
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
}
