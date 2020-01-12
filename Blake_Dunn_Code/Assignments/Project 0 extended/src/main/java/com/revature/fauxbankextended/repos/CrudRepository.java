package com.revature.fauxbankextended.repos;

import java.util.Optional;

public interface CrudRepository<T> {

    T save(T newObject);
    Optional<T> findById(Integer id);
    Boolean update(T updateObj);


}
