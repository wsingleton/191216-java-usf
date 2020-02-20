package com.revature.repositories;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    T save(T newOjb);
    T update(T updatedObj);
    boolean deleteById(int id);

}
