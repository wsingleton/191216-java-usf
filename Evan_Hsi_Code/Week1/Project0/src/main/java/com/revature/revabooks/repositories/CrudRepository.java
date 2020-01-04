package com.revature.revabooks.repositories;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository <T> {
    void save(T t);
    Set<T> findAll();
    Optional<T> findById(int id);
    boolean update(T t);
    boolean deleteById(int id);
}
