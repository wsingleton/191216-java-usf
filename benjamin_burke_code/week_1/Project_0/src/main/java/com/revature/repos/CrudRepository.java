package com.revature.repos;

import java.util.Optional;
import java.util.Set;

public class CrudRepository<T> {

    void save(T newObj);
    Set<T> findAll();
    Optional<T> findById(Integer id);
    Boolean update(T updagedObj);
    Boolean deleteById(Integer id);
}
