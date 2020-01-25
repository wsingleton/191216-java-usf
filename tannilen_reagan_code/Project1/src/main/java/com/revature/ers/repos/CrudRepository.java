package com.revature.ers.repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {
        void save(T newObj);
        Optional<T> findById(int id);
        boolean update(T updatedObj);
        boolean deleteById(int id);
}