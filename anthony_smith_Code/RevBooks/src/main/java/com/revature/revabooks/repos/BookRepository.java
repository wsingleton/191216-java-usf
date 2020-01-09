package com.revature.revabooks.repos;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import javax.xml.transform.Result;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BookRepository implements CrudRepository<Book> {

    private Integer key;
    private HashMap<Integer, Book> bookDb;


    public Set<Book> findBooksByGenre(Genre genre) {



    }

    public Set<Book> findBooksByAuthor(Author author) {


    }

    public Set<Book> findBooksByAuthorLastName(String authorLastName) {

        HashSet<Book> books = new HashSet<>();

        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
            if (entry.getValue().getAuthor().getLastName().equals(authorLastName)) {
                books.add(entry.getValue());
            }
        }

        return books;
    }x

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

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql  = "{CALL rbs_get_all_books(?}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet)cstmt.getObject(1);

            while (rs.next()) {
                Book temp = new Book();
                temp.setId(rs.getInt("book_id"));
                temp.setIsbn(rs.getString("ibsn"));
                temp.setTitle(rs.getString("title"));
                temp.setAuthor(new Author(rs.getString("author_fn")));
                temp.setGenre(Genre.getGenreById(rs.getInt("genre_id")));
                temp.setStockCount(rs.getInt("stock_count"));
                temp.setPrice(rs.getDouble("price"));


            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Optional<Book> findById(Integer id) {


    }

    @Override
    public Boolean update(Book updatedObj) {


        return true;

    }

    @Override
    public Boolean deleteById(Integer id) {
        return (bookDb.remove(id) != null);
    }

}