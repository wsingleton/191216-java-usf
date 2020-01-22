package com.revature.ers.repos;

import com.revature.ers.models.Role;
import com.revature.ers.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.ers.AppDriver.app;

public class UserRepository implements CrudRepository<User> {
    @Override
    public void save(User newObj) {

    }

    @Override
    public Set<User> findAll() {

        Connection conn = app().getCurrentSession().getConnection();
        Set<User> users = new HashSet<>();

        try {
            String sql = "SELECT * FROM ers_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);
        }catch (SQLException e) {
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

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();

        while (rs.next()) {
            User temp = new User();
            temp.setUserId(rs.getInt("ers_user_id"));
            temp.setUsername(rs.getString("ers_username"));
            temp.setPassword(rs.getString("ers_password"));
            temp.setFirstName(rs.getString("user_first_name"));
            temp.setLastName(rs.getString("user_last_name"));
            temp.setEmail(rs.getString("user_email"));
            temp.setRole(Role.getRoleById(rs.getInt("user_rold_id")));
        }

        return users;
    }
}
