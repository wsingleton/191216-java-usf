package com.revature.project_0.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    void save(T newOjb);
    Set<T> findAll();
    Optional<T> findById(Integer id);
    Boolean update(T updatedObj);


}