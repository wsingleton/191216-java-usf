package com.revature.revabooks.repos;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BookRepository implements CrudRepository<Book> {


    public Set<Book> findBookByGenre(Genre genre){
        return null;


    }

    public Optional<Book> findBookByISBN(String isbn){
        return null;


    }

    public Optional<Book> findBookByAuthor(Author author){

      return null;
    }

    public Set<Book> findBooksByAuthor(Author author) {
        return null;

    }

    public Set<Book> findBooksByAuthorLastName(String authorLastName) {
        return null;

    }

    public Set<Book> findBooksByTitle(String title) {
        return null;

    }

    @Override
    public void save(Book newObj) {
    }

    @Override
    public Set<Book> findAll() {
       HashSet<Book> books = new HashSet<>();

       try(Connection conn = ConnectionFactory.getInstance().getConnection()){
           String sql = "{CALL rbs_app.get_all_books(?)}";
           CallableStatement cstmt = conn.prepareCall(sql);
           cstmt.registerOutParameter(1, OracleTypes.CURSOR);
           cstmt.execute();
           ResultSet rs = (ResultSet) cstmt.getObject(1);

           while (rs.next()){
               Book temp = new Book();
               temp.setId(rs.getInt("book_id"));
               temp.setIsbn(rs.getString("isbn"));
               temp.setTitle(rs.getString("title"));
               temp.setAuthor(new Author(rs.getString("author_fn"), rs.getString("author_ln")));
               temp.setStockCount(rs.getInt("stock_count"));
               temp.setPrice(rs.getDouble("price"));
               temp.setGenres(Genre.getGenreById(rs.getInt("genre_id")));
               books.add(temp);
           }
       }
       catch(SQLException e){

       }

       return books;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Book updatedObj) {

      return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
    return false;
    }
}
