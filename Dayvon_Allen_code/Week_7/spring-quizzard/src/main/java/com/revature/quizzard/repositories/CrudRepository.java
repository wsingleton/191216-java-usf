package com.revature.quizzard.repositories;

import java.util.List;
import java.util.Set;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    T save(T newObj);
    boolean update(T updatedObject);
    boolean deleteById(int id);

}
