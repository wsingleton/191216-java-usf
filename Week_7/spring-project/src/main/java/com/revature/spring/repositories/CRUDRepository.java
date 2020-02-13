package com.revature.spring.repositories;

import java.util.List;

public interface CRUDRepository<T> {

    List<T> findAll();
    T findById(int id);
    T save(T newObj);
    boolean update(T updatedObj);
    boolean deleteById(int id);
}
