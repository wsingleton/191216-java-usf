package com.revature.project_0.repos;

import com.revature.project_0.models.User;
import com.revature.project_0.util.ConnectionFactory;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    Set<User> users = new HashSet<>();

//    try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//
//        String sql = SELECT
//    }

    @Override
    public void save(User newOjb) {

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
    public Boolean update(User updatedObj) {
        return null;
    }
}
