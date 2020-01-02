package com.revature.revabooks.repos;

import java.util.Set;

public interface CrudRepository<T> {

    public T save(T t);

    public Set<T> findAll();

    public T findById(Integer id);

    public boolean Update(T t);

    public boolean deleteById(Integer id);

}
