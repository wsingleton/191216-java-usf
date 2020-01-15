package com.revature.bank2.repos;

import java.util.Optional;
import java.util.Set;


public interface CrudRepository<T> {

    void save(T newObj);


}
