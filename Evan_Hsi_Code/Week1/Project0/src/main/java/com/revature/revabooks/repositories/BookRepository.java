package com.revature.revabooks.repositories;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.util.ConnectionFactory;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    }

    @Override
    public Set<Book> findAll() {
        HashSet<Book> books = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "{CALL rbs_app.get_all_books(?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            while (rs.next()) {
                Book temp = new Book();
                temp.setId(rs.getInt("book_id"));
                temp.setISBN(rs.getString("isbn"));
                temp.setTitle(rs.getString("title"));
                temp.setAuthor(new Author(rs.getString("author_fn"), rs.getString("author_ln")));
                temp.setGenre(Genre.getGenreById(rs.getInt("genre_id")));
                temp.setStock(rs.getInt("stock_count"));
                temp.setPrice(rs.getDouble("price"));
                books.add(temp);
            }

        } catch (SQLException e) {e.printStackTrace(); }
        return books;
    }

    @Override
    public Optional<Book> findById(int id) {
        return null;
    }

    @Override
    public boolean update(Book b) {

        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }


    public Set<Book> findBooksByGenre(Genre genre) {
        return null;
    }

    public Set<Book> findBooksByAuthor(Author author) {
        return null;
    }

    public Set<Book> findBooksByAuthor(String authorLastName) {
        return null;
    }

    public Set<Book> findBooksByTitle(String title) {
        return null;
    }

    public Optional<Book> findBookByISBN(String isbn) {
        return null;
    }
}
