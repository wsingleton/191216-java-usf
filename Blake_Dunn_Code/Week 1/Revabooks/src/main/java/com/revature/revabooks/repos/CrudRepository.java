package com.revature.revabooks.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    void save(T newObject);
    Set<T> findAll();
    Optional<T> findById(Integer id);
    Boolean update(T updateObj);
    Boolean deleteById(Integer id);

}
