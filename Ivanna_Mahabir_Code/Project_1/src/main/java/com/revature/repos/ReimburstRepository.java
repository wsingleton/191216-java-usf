package com.revature.repos;

import java.util.Optional;
import java.util.Set;

public class ReimburstRepository implements CrudRepository {
    @Override
    public void save(Object newObj) {

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
