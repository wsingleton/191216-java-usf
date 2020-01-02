package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import java.util.Set;

public class UserRepository implements CrudRepository {


    public Set<User> findUsersByRole(Role role){
        return null;
    }

    public User findUserByUsername(String username){
        return null;
    }

    public User findUserByCredentials(String username, String pw){
        return null;
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public Object findById(Integer id) {
        return null;
    }

    @Override
    public boolean Update(Object o) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
