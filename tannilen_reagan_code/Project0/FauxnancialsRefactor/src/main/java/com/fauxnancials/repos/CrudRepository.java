package com.fauxnancials.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {
    void save(T t);
    Optional<T> findByID(Integer id);
    boolean update(T t);
    boolean deleteByID(Integer id);
}
