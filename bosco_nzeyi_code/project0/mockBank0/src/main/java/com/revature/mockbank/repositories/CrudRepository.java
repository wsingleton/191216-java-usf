package com.revature.mockbank.repositories;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    void save(T data);
    Set<T> findAll();
   Optional<T> findById(Integer id);
   Optional<T> findByUsername (String username);
//   Boolean findByUsername(String username);
   Boolean update (Integer id);
   Boolean delete (Integer id);


}
