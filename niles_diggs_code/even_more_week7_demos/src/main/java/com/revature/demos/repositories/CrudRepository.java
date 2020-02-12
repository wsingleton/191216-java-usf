package com.revature.demos.repositories;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    T save(T newObj);
    boolean update(T updatedObJ);
    boolean delete(T updatedObJ);
}
