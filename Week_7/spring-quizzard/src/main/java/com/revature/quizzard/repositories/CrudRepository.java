package com.revature.quizzard.repositories;

import java.util.Set;

public interface CrudRepository<T> {

    Set<T> findAll();
    T findById(int id);
    T save(T newObj);
    boolean update(T updatedObj);
    boolean deleteById(int id);

}
