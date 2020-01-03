package com.revature.revabooks.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {
    void save(T t);
    Set<T> findAll();
    Optional<T> findByID(Integer id);
    boolean update(T t);
    boolean deleteByID(Integer id);
}