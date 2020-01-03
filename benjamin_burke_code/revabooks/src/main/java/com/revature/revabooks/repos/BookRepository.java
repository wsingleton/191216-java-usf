package com.revature.revabooks.repos;

import com.revature.revabooks.models.*;

import java.util.*;

public class BookRepository implements CrudRepository<Book> {


    private Integer key;
    private HashMap<Integer, Book> bookDb;

    {
        key = 1;
        bookDb = new HashMap<>();
        bookDb.put(key, new Book(key, "978-1118957400", "OCA Study Guide", new Author("Scott", "Selikoff"), Genre.PERSONAL_DEVELOPMENT, 20)); key++;
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
    public void save(Book newObj) {
        newObj.setId(key);
        bookDb.put(key++, newObj);

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
