package com.revature.revabooks.repos;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.*;

public class BookRepository implements CrudRepository<Book> {

    private Integer key;
    private HashMap<Integer, Book> bookDb;



    public Set<Book> findBooksByGenre(Genre genre) {




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

    public Optional<Book> findBookByIsbn(String isbn) {



        return Optional.empty();
    }

    @Override
    public void save(Book newObj) {

    }

    @Override
    public Set<Book> findAll() {

        HashSet<Book> books = new HashSet<>();


            try(Connection conn = ConnectionFactory.getInstance().getConnection()){

                String sql = "{CALL rbs_app.get_all_book(?)}";
                CallableStatement cstmt = conn.prepareCall(sql);
                cstmt.registerOutParameter(1, OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)  cstmt.getObject(1);

                while (rs.next()){
                    Book temp = new Book();
                    temp.setId(rs.getInt("book_id"));
                    temp.setIsbn(rs.getString("isbn"));
                    temp.setTitle(rs.getString("title"));
                    temp.setAuthor(new Author(rs.getString("author_fn"), rs.getString("author_ln")));
                    temp.setGenre(Genre.getGenreById(rs.getInt("genre_id")));
                    temp.setStockCount(rs.getInt("stock_count"));
                    temp.setPrice(rs.getDouble("price"));
                    books.add(temp);





                }



            }catch (SQLException e){
                e.printStackTrace();
            }

            return books;

    }

    @Override
    public Optional<Book> findById(Integer id) {

        return null;

    }

    @Override
    public Boolean update(Book updatedObj) {

        if (bookDb.get(updatedObj.getId()) == null) return false;
        bookDb.put(updatedObj.getId(), updatedObj);
        return true;

    }

    @Override
    public Boolean deleteById(Integer id) {
        return (bookDb.remove(id) != null);
    }

}