package com.revature.revabooks.repositories;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {
    void save(T newObj);
    Set<T> findAll();
    Optional<T> findById(Integer id);
    Boolean update(T t);
    Boolean deleteById(Integer id);
}
