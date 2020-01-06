package com.revature.revabooks.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    void save(T newObj);
    Set<T> findAll();
    //optional is a class that was recently introduce in java 8(help avoid null pointer exception)
    Optional<T> findById(Integer id);
    Boolean update(T updatedObj);
    Boolean deleteById(Integer id);
}
