package com.revature.revabooks.repos;

import com.revature.revabooks.models.*;

import java.util.*;

import static com.revature.revabooks.models.Genre.*;

public class BookRepository implements CrudRepository<Book> {
    private Integer key;
    private HashMap<Integer, Book> bookDb;

    {key =1;
    //must add appropriate data
        bookDb = new HashMap<>();
        bookDb.put(key, new Book(key, "978-8804707370", "The HitchHikers Guide To The Galaxy", new Author("Douglas", "Adams"), SCIENCE_FICTION, 20)); key++;
        bookDb.put(key, new Book(key, "978-8804707371", "The HitchHikers Guide To The Bathroom", new Author("Douglas", "Stewart"), AUTO_BIOGRAPHY, 5)); key++;
        bookDb.put(key, new Book(key, "978-8804707372", "The HitchHikers Guide To The Exit", new Author("Douglas", "Dunn"), FICTION, 12)); key++;
        bookDb.put(key, new Book(key, "978-9851807822", "IT", new Author("Steven", "King"), HORROR, 5)); key++;
        bookDb.put(key, new Book(key, "978-8700631625", "Harry Potter and The Sorcerer's Stone", new Author("J.K.","ROWLING"), FANTASY, 10)); key++;
        bookDb.put(key, new Book(key, "978-0605928183", "Harry Potter and The Chamber of Secrets", new Author("J.K.","ROWLING"), FANTASY, 1)); key++;
        bookDb.put(key, new Book(key, "978-0605928183", "Harry Potter and Prisoner of Azkaban", new Author("J.K.","ROWLING"), FANTASY, 11)); key++;
        bookDb.put(key, new Book(key, "978-8580444490", "Fight Club", new Author("Chuck","Palahniuk"), FICTION, 3)); key++;
        bookDb.put(key, new Book(key, "978-0605558183", "My Momma Said", new Author("Bobby","Boucher"), BIOGRAPHY, 4)); key++;
        bookDb.put(key, new Book(key, "978-0074592818", "The Lightning Thief(Percy Jackson and The Olympians)", new Author("Rick","Riordan"), FANTASY, 2)); key++;
        bookDb.put(key, new Book(key, "978-8700631655", "Harry PottHead and The Swinger's Music Festival", new Author("Snoop","Dogg"), DYSTOPIAN, 3)); key++;

    }

       public Set<Book> findBooksByGenre(Genre genre){
        HashSet<Book> books = new HashSet<>();
        //example of a lambda expression
        bookDb.forEach((key, value) -> {
            if(value.getGenres().equals(genre)){
                books.add(value);
            }
        });
        return books;
    }

    public Optional<Book> findByAuthor(Author author){
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()){
            if (entry.getValue().getAuthor().equals(author)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public Optional<Book> findByAuthorLastName(String authorlastname){
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()){
            if (entry.getValue().getAuthor().getLastName().equals(authorlastname)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public Optional<Book> findByIsbn(String isbn){
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()){
            if (entry.getValue().getIsbn().equals(isbn))
            {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
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
        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()){
            if (entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Boolean update(Book updatedObj) {
        if(bookDb.get(updatedObj.getId()) == null){return false;}
        bookDb.put(updatedObj.getId(), updatedObj);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return ( bookDb.remove(id) != null);
    }
}
