package com.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository <T> {

    void save(T newObj);
    Set<T>  findAll();
    Optional<T> findById(int id);
    boolean update(T updateObj);
    boolean deleteById(int id);
}
