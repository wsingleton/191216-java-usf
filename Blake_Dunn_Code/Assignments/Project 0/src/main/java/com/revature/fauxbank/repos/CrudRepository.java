package com.revature.fauxbank.repos;

import com.revature.fauxbank.models.Account;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    T save(T newObject);
    Optional<T> findById(Integer id);
    Boolean update(T updateObj);
    Boolean deleteById(Integer id);

}
