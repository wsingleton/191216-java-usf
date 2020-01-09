package com.revature.revabooks.repos;

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
    public Set<Book> findBooksByGenre(Genre genre) {
        Set<Book> books = new HashSet<>();
        return books;
    }
    public Set<Book> findBooksByAuthor(String authorLastName) {
        Set<Book> books = new HashSet<>();
        return books;
    }
    public Set<Book> findBooksByTitle(String title) {
        Set<Book> books = new HashSet<>();
        return books;
    }
    public Optional<Book> findBookByISBN(String isbn) {
        return Optional.empty();
    }
    @Override
    public void save(Book book) {
    }
    @Override
    public Set<Book> findAll() {
        Set<Book> books = new HashSet<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql="{CALL revabooks_app.get_all_books(?)}";
            CallableStatement cstmt=conn.prepareCall(sql);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Book temp=new Book();
                temp.setId(rs.getInt("book_id"));
                temp.setIsbn(rs.getString("isbn"));
                temp.setTitle(rs.getString("title"));
                temp.setAuthor(new Author(rs.getString("author_given"), rs.getString("author_family")));
                temp.setGenre(Genre.getGenreById(rs.getInt("genre_id")));
                temp.setPrice(rs.getDouble("price"));
                temp.setStockCount(rs.getInt("stock"));
                books.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    @Override
    public Optional<Book> findByID(Integer id) {
        return Optional.empty();
    }
    @Override
    public boolean update(Book book) {
        return false;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return false;
    }
}
