package com.revature.revabooks.repositories;

import com.revature.revabooks.models.*;

import java.util.*;

public class BookRepository implements CrudRepository <Book> {
    private Integer key;
    private HashMap<Integer, Book> bookDb;

    {
        key = 0;
        bookDb = new HashMap<>();
        bookDb.put(key, new Book(key, 50, "9888888889","One Flew Over the Cuckoo's Nest", new Author("Roald", "Dahl"),  Genre.ADVENTURE));
        key++;
        bookDb.put(key, new Book(key, 50, "9888888879","All Quiet on the Western Front", new Author("Emile", "Zola"),  Genre.HISTORICAL_FICTION));
        key++;
        bookDb.put(key, new Book(key, 50, "9888888869","The Return of the King", new Author("JRR", "Tolkien"),  Genre.FANTASY));
        key++;
        bookDb.put(key, new Book(key, 50, "9888888859","Wraith Squadron", new Author("Erik", "Anders"),  Genre.PERSONAL_DEVELOPMENT));
        key++;
        bookDb.put(key, new Book(key, 50, "9888888849","Bible", new Author("", "Anonymous"),  Genre.SPIRITUAL));
        key++;
    }

    public Set<Book> findBooksByGenre(Genre genre){
        HashSet<Book> books = new HashSet<>();
        bookDb.forEach((key, value) -> {
            if(value.getGenres().equals(genre)){
                books.add(value);
            }
        });

        return books;
    }

    public Set<Book> findBooksByAuthor(String authorLastName){
        HashSet<Book> books = new HashSet<>();
        bookDb.forEach((key, value) -> {
            if(value.getAuthor().getLastName().equals(authorLastName)){
                books.add(value);
            }
        });

        return books;
    }

    public Set<Book> findBooksByTitle(String title){
        HashSet<Book> books = new HashSet<>();
        bookDb.forEach((key, value) -> {
            if(value.getTitle().equals(title)){
                books.add(value);
            }
        });

        return books;
    }

    @Override
    public void save(Book book) {
        book.setId(key);
        bookDb.put(key, book);
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
        for(Map.Entry<Integer, Book> entry: bookDb.entrySet()){
            if(entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Boolean update(Book book) {
        if(bookDb.get(book.getId()) == null){
            return false;
        }
        bookDb.put(book.getId(), book);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return  (bookDb.remove(id) != null);
    }
}
