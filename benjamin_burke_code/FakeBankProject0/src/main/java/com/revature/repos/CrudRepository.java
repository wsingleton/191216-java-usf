package com.revature.repos;


import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {
    void save(T newObj) throws SQLException;
    Set<T> findAll();
    Optional<T> findById(Integer id);
    Boolean update(T updatedObj) throws SQLException;
    Boolean deleteById(Integer id);
}
