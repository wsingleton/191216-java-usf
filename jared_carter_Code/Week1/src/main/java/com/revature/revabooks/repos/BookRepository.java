
package com.revature.revabooks.repos;

import com.revature.revabooks.models.Book;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class BookRepository implements CrudRepository<Book> {
    private Integer key;
    private HashMap<Integer, Book> bookDb;

    {
        key = 1;
        bookDb = new HashMap<>();
        bookDb.put(key, )

    }
    @Override
    public void save(Book newObj) {

    }

    @Override
    public Set<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Book updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

}