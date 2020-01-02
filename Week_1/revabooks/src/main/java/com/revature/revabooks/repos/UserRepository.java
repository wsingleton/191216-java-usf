package com.revature.revabooks.repos;

import com.revature.revabooks.models.User;

import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User>
{
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
    public Boolean update(User updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
