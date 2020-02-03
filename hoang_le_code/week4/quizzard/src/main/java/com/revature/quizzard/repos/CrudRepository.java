package com.revature.quizzard.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    void save(T newObj);
    Set<T> findAll();
    Optional<T> findById(int id);
    void update(T updatedObj);
    void deleteById(int id);

}
