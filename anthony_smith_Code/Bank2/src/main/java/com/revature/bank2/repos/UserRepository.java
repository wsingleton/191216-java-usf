package com.revature.bank2.repos;

import com.revature.bank2.models.User;
import com.revature.bank2.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User>{

    public Optional<User> findUserByCredentials(String username, String password){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

        }
    }

}
