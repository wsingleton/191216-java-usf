package com.revature.revabank.repos;

import com.revature.revabank.models.Role;
import com.revature.revabank.models.User;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User>{

    public Optional<User> findUserByUsername(String username) {

      return null;


    }

    public Optional<User>findUserByCredentials(String username, String password){
            return null;

    }

    @Override
    public void save(User newObj) {

    }

    @Override
    public Set<User> findAll(){
        Set<User> users = new HashSet<>();

        return users;
    }

    @Override
    public Optional<User> findById(Integer id){
        return null;
    }

    @Override
    public Boolean update(User updatedObj){
        return false;
    }

    @Override
    public Boolean deleteById(Integer id){
        return null;
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
            temp.setRole(Role.getRoleById(rs.getInt("role_id")));
            users.add(temp);
        }
        return users;
    }
}
