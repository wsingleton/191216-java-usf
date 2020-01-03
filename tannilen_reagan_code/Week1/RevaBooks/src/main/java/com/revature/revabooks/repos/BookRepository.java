package com.revature.revabooks.repos;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;

import java.util.*;

public class BookRepository implements CrudRepository<Book> {
    private Integer key;
    private HashMap<Integer, Book> bookDB;
    {
        key=1;
        bookDB=new HashMap<>();
        bookDB.put(key, new Book(key, "123-12-12345-12-1", "Sample", new Author("John", "Doe"), Genre.GUIDE, 0));key++;
        bookDB.put(key, new Book(key, "222-22-22222-22-2", "The Demon Haunted World", new Author("Carl", "Sagan"), Genre.NONFICTION, 3));key++;
        bookDB.put(key, new Book(key, "987-65-43210-12-3", "The Moon is a Harsh Mistress", new Author("Robert", "Heinlein"), Genre.SCIENCE_FICTION, 13));key++;
        bookDB.put(key, new Book(key, "000-00-00000-00-0", "Magic's Pawn", new Author("Mercedes", "Lackey"), Genre.FANTASY, 9));key++;
        bookDB.put(key, new Book(key, "555-55-55555-55-5", "Sonnets and Poems", new Author("William", "Shakespeare"), Genre.POETRY, 2));key++;
    }
    public Set<Book> findBooksByGenre(Genre genre) {
        HashSet<Book> bookList=new HashSet<>();
        bookDB.forEach((k, v) -> {
            if (v.getGenre().equals(genre)) {bookList.add(v);}
        });
        return bookList;
    }
    public Set<Book> findBooksByAuthor(String authorLastName) {
        HashSet<Book> bookList=new HashSet<>();
        bookDB.forEach((k, v) -> {
            if (v.getAuthor().getLastName().equals(authorLastName)) {bookList.add(v);}
        });
        return bookList;
    }
    public Set<Book> findBooksByTitle(String title) {
        HashSet<Book> bookList=new HashSet<>();
        bookDB.forEach((k, v) -> {
            if (v.getTitle().contains(title)) {bookList.add(v);}
        });
        return bookList;
    }
    public Optional<Book> findBookByISBN(String isbn) {
        for(Map.Entry<Integer, Book> entry : bookDB.entrySet()) {
            if (entry.getValue().getIsbn().equals(isbn)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
    @Override
    public void save(Book book) {
        book.setId(key);
        bookDB.put(key, book);
        key++;
    }
    @Override
    public Set<Book> findAll() {
        HashSet<Book> books=new HashSet<>();
        for(Map.Entry<Integer,Book> entry : bookDB.entrySet()) {
            books.add(entry.getValue());
        }
        return books;
    }
    @Override
    public Optional<Book> findByID(Integer id) {
        for(Map.Entry<Integer, Book> entry : bookDB.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
    @Override
    public boolean update(Book book) {
        if (bookDB.get(book.getId())==null) {
            return false;
        }
        bookDB.put(book.getId(), book);
        return true;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return (bookDB.remove(id))!=null;
    }
}
