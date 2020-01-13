package com.revature.bank.repos;

import com.revature.bank.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    public Optional<User> findByCredentials(String username, String password){
        Optional<User> _user = Optional.empty();


        return _user;
    }



    @Override
    public void save(User newObj) {

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
            temp.setUsrName(rs.getString("username"));
            temp.setPassWord(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            users.add(temp);
        }

        return users;
    }

}
