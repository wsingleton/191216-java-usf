package com.revature.revabooks.repositories;

import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository{
    @Override
    public void save(Object newObj) {

    }

    @Override
    public Set findAll() {
        return null;
    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Object updatedObj) {
        return null;
    }
}
