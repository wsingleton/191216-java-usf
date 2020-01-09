package com.revature.fauxbank.repos;

import java.util.Optional;

public interface CrudRepository<T> {

    void save(T newObject);
    Optional<T> findById(Integer id);
    Boolean update(T updateObj);

}
