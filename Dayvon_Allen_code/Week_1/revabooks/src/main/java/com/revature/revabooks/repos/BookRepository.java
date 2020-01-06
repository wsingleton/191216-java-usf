package com.revature.revabooks.repos;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.models.User;

import java.util.*;

public class BookRepository implements CrudRepository<Book> {
    private Integer key;
    HashMap<Integer, Book> bookDb;

    {
        key = 1;
        bookDb = new HashMap<>();

        bookDb.put(key, new Book(key, "123456","Land of Whales", new Author("John", "Smith"), Genre.ADVENTURE, 20)); key++;
        bookDb.put(key, new Book(key, "123458","Sea World", new Author("Harry", "Jackson"), Genre.CONTEMPORARY, 50)); key++;
        bookDb.put(key, new Book(key, "1231058","Alice", new Author("Jake", "Washington"), Genre.BIOGRAPHY, 100)); key++;
        bookDb.put(key, new Book(key, "230495","Dark Dream", new Author("Rebecca", "Howard"), Genre.FANTASY, 200)); key++;
        bookDb.put(key, new Book(key, "4393003","Bakery", new Author("Samantha", "Powell"), Genre.COOKING, 300)); key++;

    }

    public Set<Book> findBookByGenre(Genre genre){

        HashSet<Book> books = new HashSet<>();
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if (entry.getValue().getGenres().equals(genre)) {
                books.add(entry.getValue());
            }
        }
        return books;
    }

    public Optional<Book> findBookByISBN(String isbn){

        for (Map.Entry<Integer, Book> entry: bookDb.entrySet()) {
            if (entry.getValue().getIsbn().equals(isbn)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public Optional<Book> findBookByAuthor(Author author){

        for (Map.Entry<Integer, Book> entry: bookDb.entrySet()) {
            if (entry.getValue().getAuthor().equals(author)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
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

    @Override
    public void save(Book newObj) {
        newObj.setId(key);
        bookDb.put(key++, newObj);
    }

    @Override
    public Set<Book> findAll() {
        HashSet<Book> books = new HashSet<>();
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()){
            books.add(entry.getValue());
        }

        return books;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        for (Map.Entry<Integer, Book> entry: bookDb.entrySet()) {
            if(entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }
        //avoids returning null, wrapper class
        return Optional.empty();
    }

    @Override
    public Boolean update(Book updatedObj) {

        if(bookDb.get(updatedObj.getId()) == null) {
            return false;
        }
        bookDb.put(updatedObj.getId(), updatedObj);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {

        return bookDb.remove(id) != null;
    }
}
