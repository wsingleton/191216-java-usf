package com.revature.revabooks.repos;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;

import java.util.*;

public class BookRepository implements CrudRepository<Book> {

    private Integer key;
    private HashMap<Integer, Book> bookDb;

    {
        key = 1;
        bookDb = new HashMap<>();
        bookDb.put(key, new Book(key, "2019-2012", "Optical Electronics", new Author("S","Murshid"), Genre.ADVENTURE, 5)); key++;
        bookDb.put(key, new Book(key,"2010-2012", "CXC Past Papers", new Author("Asha","Maharaj"), Genre.FANTASY, 9)); key++;
        bookDb.put(key, new Book(key, "1995-1998", "It", new Author("Steven","King"), Genre.HORROR, 1)); key++;
        bookDb.put(key, new Book(key,"2019-2012", "Antennas", new Author("Dr","Lail"), Genre.SCIENCE_FICTION, 5)); key++;

    }

    public Set<Book> findBooksByGenre(Genre genre) {
        HashSet<Book> books = new HashSet<>();
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if (entry.getValue().getGenre().equals(genre)) {
                books.add(entry.getValue());
            }
        }
        return books;
    }
    public Set<Book> findBooksByAuthor(Author author) {
        HashSet<Book> books = new HashSet<>();
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if (entry.getValue().getAuthor().equals(author)) {
                books.add(entry.getValue());
            }
        }
        return books;
    }
    public Set<Book> findBooksByAuthorLastName(String authorLastName) {
        HashSet<Book> books = new HashSet<>();
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if (entry.getValue().getAuthor().getLastName().equals(authorLastName)) {
                books.add(entry.getValue());
            }
        }
        return books;
    }
    public Set<Book> findBooksByTitle(String title) {
        HashSet<Book> books = new HashSet<>();
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if (entry.getValue().getTitle().equals(title)) {
                books.add(entry.getValue());
            }
        }
        return books;
    }
    public Optional<Book> findBookByIsbn(String isbn) {
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if (entry.getValue().getIsbn().equals(isbn)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }


    @Override
    public void save(Book newObj) {
        newObj.setId(key);
        bookDb.put(key, newObj);
        key++;
    }

    @Override
    public Set<Book> findAll() {
        HashSet<Book> books = new HashSet<>();

        for(Map.Entry<Integer, Book> entry : bookDb.entrySet()){
            books.add(entry.getValue());
        }

        return books;
    }

    @Override
    public Optional<Book> findById(Integer id) {

        for(Map.Entry<Integer, Book> entry : bookDb.entrySet()){
            if(entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Boolean update(Book updatedObj) {
        if(bookDb.get(updatedObj.getId()) == null) return false;
        bookDb.put(updatedObj.getId(), updatedObj);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return (bookDb.remove(id) != null);
    }
}
