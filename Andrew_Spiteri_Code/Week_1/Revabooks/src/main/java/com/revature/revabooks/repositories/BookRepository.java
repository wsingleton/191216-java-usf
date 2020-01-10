package com.revature.revabooks.repositories;

import com.revature.revabooks.models.*;
import com.revature.revabooks.util.ConnectionFactory;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BookRepository implements CrudRepository <Book> {

    public Set<Book> findBooksByGenre(Genre genre){
        HashSet<Book> books = new HashSet<>();

        return books;
    }

    public Set<Book> findBooksByAuthor(String authorLastName){
        HashSet<Book> books = new HashSet<>();


        return books;
    }

    public Set<Book> findBooksByTitle(String title){
        HashSet<Book> books = new HashSet<>();


        return books;
    }

    @Override
    public void save(Book book) {

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
                temp.setGenre(Genre.getGenreById(rs.getInt("genre_id")));
                temp.setStockCount(rs.getInt("stock_count"));
                temp.setPrice(rs.getInt("price"));
                books.add(temp);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Optional<Book> findById(Integer id) {

        return Optional.empty();
    }

    @Override
    public Boolean update(Book book) {

        return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return  false;
    }
}
