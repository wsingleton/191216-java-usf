package com.revature.ers.repositories;

import com.revature.ers.models.User;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    void save(T newObj, User user);
    Set<T> findAll(User user);
    Optional<T> findById(int id, User user);
    boolean update(T updatedObj, User user);
    boolean deleteById(int id, User user);
}
