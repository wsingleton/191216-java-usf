package com.revature.revabooks.repositories;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;

import java.util.*;

public class BookRepository implements CrudRepository<Book> {

    private Integer key;

    private Hashtable<Integer, Book> bookDb = new Hashtable<>();

    {key = 1;
        bookDb = new Hashtable<>();
        bookDb.put(key, new Book(key, "978-1118957400", "OCA Study Guide", new Author("Scott", "Selikoff"), Genre.TECHNICAL, 20)); key++;
        bookDb.put(key, new Book(key, "978-1501182105", "Dark Tower I: The Gunslinger", new Author("Stephen", "King"), Genre.FANTASY, 8)); key++;
        bookDb.put(key, new Book(key, "978-1565897342", "Autobiography of a Yogi", new Author("Paramhansa", "Yogananda"), Genre.SPIRITUAL, 12)); key++;
        bookDb.put(key, new Book(key, "978-1455586691", "Deep Work", new Author("Cal", "Newport"), Genre.PERSONAL_DEVELOPMENT, 35)); key++;
        bookDb.put(key, new Book(key, "978-1501161810", "Dark Tower II: The Drawing of the Three", new Author("Stephen", "King"), Genre.FANTASY, 25)); key++;
        bookDb.put(key, new Book(key, "978-1617293986", "Spring Microservices In Action", new Author("John", "Carnell"), Genre.TECHNICAL, 50)); key++;
        bookDb.put(key, new Book(key, "978-0375712364", "Brave New World", new Author("Aldous", "Huxley"), Genre.DYSTOPIAN, 13)); key++;
        bookDb.put(key, new Book(key, "978-0134692883", "Learn Python 3 the Hard Way", new Author("Zed", "Shaw"), Genre.TECHNICAL, 45)); key++;
        bookDb.put(key, new Book(key, "978-1593276034", "Python Crash Course", new Author("Eric", "Matthes"), Genre.TECHNICAL, 12)); key++;
        bookDb.put(key, new Book(key, "978-1559391979", "Stages of Meditation", new Author("Dalai", "Lama"), Genre.SPIRITUAL, 20)); key++;
        bookDb.put(key, new Book(key, "978-1586380212", "The Upanishads", new Author("Eknath", "Easwaran"), Genre.SPIRITUAL, 7)); key++;
        bookDb.put(key, new Book(key, "978-1593278052", "Learn Java the Easy Way", new Author("Bryson", "Payne"), Genre.TECHNICAL, 10)); key++;
        bookDb.put(key, new Book(key, "978-1501161827", "Dark Tower III: The Wastelands", new Author("Stephen", "King"), Genre.SPIRITUAL, 18)); key++;
    }

    @Override
    public void save(Book b) {
        b.setId(key);
        bookDb.put(key, b);
        key++;
    }

    @Override
    public Set<Book> findAll() {

        Set<Book> allSet = new HashSet<>();
        bookDb.forEach((k,v) -> allSet.add(v));
        return allSet;
    }

    @Override
    public Optional<Book> findById(int id) {
        if(!bookDb.containsKey(id)) return Optional.empty();
        return Optional.of(bookDb.get(id));
    }

    @Override
    public boolean update(Book b) {

        if(!bookDb.containsKey(b.getId())) return false;
        bookDb.put(b.getId(), b);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        if(!bookDb.containsKey(id)) return false;
        bookDb.remove(id);
        return true;
    }


    public Set<Book> findBooksByGenre(Genre genre) {
        Set<Book> allSet = new HashSet<>();
        bookDb.forEach((k,v) -> { if(v.getGenre().equals(genre)) allSet.add(v); });
        return allSet;
    }

    public Set<Book> findBooksByAuthor(Author author) {
        Set<Book> allSet = new HashSet<>();
        bookDb.forEach((k,v) -> { if(v.getAuthor().equals(author)) allSet.add(v);});
        return allSet;
    }

    public Set<Book> findBooksByAuthor(String authorLastName) {
        Set<Book> allSet = new HashSet<>();
        bookDb.forEach((k,v) -> { if(v.getAuthor().getLastName().equals(authorLastName)) allSet.add(v); });
        return allSet;
    }

    public Set<Book> findBooksByTitle(String title) {
        Set<Book> allSet = new HashSet<>();
        bookDb.forEach((k,v) -> { if(v.getTitle().equals(title)) allSet.add(v); });
        return allSet;
    }

    public Optional<Book> findBookByISBN(String isbn) {
        for(Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if(entry.getValue().getISBN().equals(isbn)) {
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }
}
