package com.revature.revabooks.repos;

import com.revature.revabooks.models.Genre;

import java.util.Set;

public class BookRepository<Book> implements CrudRepository {

    public Set<Book> findBooksByGenre(Genre genre){
        return null;
    }

    public Set<Book> findBooksByAuthor(String authorLastName) {
        return null;
    }

    public Set<Book> findBooksByTitle(String title) {
        return null;
    }

    public Book findBookByIsbn(String isbn) {
        return null;
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Set findAll() {
        return null;
    }

    @Override
    public Object findById(Integer id) {
        return null;
    }

    @Override
    public boolean Update(Object o) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
