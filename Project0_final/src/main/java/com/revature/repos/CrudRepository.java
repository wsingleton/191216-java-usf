package com.revature.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    void save (T newObj);
    Set<T> findAll();
    Optional<T> findByUsername(String username);
}
