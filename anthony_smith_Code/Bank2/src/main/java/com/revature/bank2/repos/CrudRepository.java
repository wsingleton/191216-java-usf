package com.revature.bank2.repos;

import java.util.Optional;
import java.util.Set;

public class CrudRepository <T> {

    void save(T newObj);
    Set<T> findAll();
    Optional<T> findById(Integer id);
    Boolean update(T updateObj);
    Boolean deleteById(Integer id);


}


