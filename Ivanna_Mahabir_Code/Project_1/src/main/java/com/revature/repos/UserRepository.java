package com.revature.repos;

import com.revature.models.User;
import com.revature.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository {
    @Override
    public void save(User newObj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

        }
        catch(SQLException e){

        }
    }

    @Override
    public Set findAll() {
        return null;
    }

    @Override
    public Optional findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Object updateObj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
