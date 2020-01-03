package com.revature.repositories;

import java.util.Set;

public interface CrudRepository<T> {
    Boolean save(T t);
    boolean deleteById(Integer id);
}
