package com.revature.quizzard.repositories;

import java.util.List;

public interface CRUDRepository<T> {
    List<T> findAll();
    T findById(int id);
    T save(T obj);
    boolean update(T obj);
    boolean deleteById(int id);
}