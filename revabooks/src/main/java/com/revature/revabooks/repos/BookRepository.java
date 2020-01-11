package com.revature.revabooks.repos;

import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.*;

import static com.revature.revabooks.AppDriver.currentSession;

public class BookRepository implements CrudRepository<Book> {

    public Set<Book> findBooksByGenre(Genre genre) {

        Connection conn = currentSession.getConnection();
        Set<Book> books = new HashSet<>();

        try {

            String sql = "SELECT * FROM rbs_app.books WHERE genre_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, genre.ordinal());
            books = mapResultSet(pstmt.executeQuery());


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return books;

    }

    public Set<Book> findBooksByAuthor(Author author) {

        Connection conn = currentSession.getConnection();
        Set<Book> books = new HashSet<>();

        try {

            String sql = "SELECT * FROM rbs_app.books WHERE author_fn = ? AND author_ln = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, author.getFirstName());
            pstmt.setString(2, author.getLastName());
            books = mapResultSet(pstmt.executeQuery());


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return books;

    }

    public Set<Book> findBooksByAuthorLastName(String authorLastName) {

        Connection conn = currentSession.getConnection();
        Set<Book> books = new HashSet<>();

        try {

            String sql = "SELECT * FROM rbs_app.books WHERE author_ln = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, authorLastName);
            books = mapResultSet(pstmt.executeQuery());


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return books;

    }

    public Set<Book> findBooksByTitle(String title) {

        Connection conn = currentSession.getConnection();
        Set<Book> books = new HashSet<>();

        try {

            String sql = "SELECT * FROM rbs_app.books WHERE title = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            books = mapResultSet(pstmt.executeQuery());


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return books;

    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public void save(Book newObj) {

        Connection conn = currentSession.getConnection();

        try {

            String sql = "INSERT INTO rbs_app.books VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"book_id"});
            pstmt.setString(1, newObj.getIsbn());
            pstmt.setString(2, newObj.getTitle());
            pstmt.setString(3, newObj.getAuthor().getFirstName());
            pstmt.setString(4, newObj.getAuthor().getLastName());
            pstmt.setInt(5, newObj.getGenre().ordinal());
            pstmt.setDouble(6, newObj.getPrice());
            pstmt.setInt(7, newObj.getStockCount());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set<Book> findAll() {

        Connection conn = currentSession.getConnection();
        Set<Book> books = new HashSet<>();

        try {

            String sql = "{CALL rbs_app.get_all_books(?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            books = mapResultSet((ResultSet) cstmt.getObject(1));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;

    }

    @Override
    public Optional<Book> findById(Integer id) {

        Connection conn = currentSession.getConnection();
        Optional<Book> book = Optional.empty();

        try {

            String sql = "SELECT * FROM rbs_app.books WHERE book_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            book = mapResultSet(pstmt.executeQuery()).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return book;

    }

    @Override
    public Boolean update(Book updatedObj) {

        Connection conn = currentSession.getConnection();
        Boolean updateSuccessful = false;

        try {

            String sql = "UPDATE rbs_app.books SET isbn = ?, title = ?, author_fn = ?, " +
                         "author_ln = ?, genre_id = ?, price = ?, stock_count = ? " +
                         "WHERE book_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedObj.getIsbn());
            pstmt.setString(2, updatedObj.getTitle());
            pstmt.setString(3, updatedObj.getAuthor().getFirstName());
            pstmt.setString(4, updatedObj.getAuthor().getLastName());
            pstmt.setInt(5, updatedObj.getGenre().ordinal());
            pstmt.setDouble(6, updatedObj.getPrice());
            pstmt.setInt(7, updatedObj.getStockCount());
            pstmt.setInt(8, updatedObj.getId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateSuccessful;

    }

    @Override
    public Boolean deleteById(Integer id) {

        Connection conn = currentSession.getConnection();
        Boolean deleteSuccessful = false;

        try {

            String sql = "DELETE FROM rbs_app.books WHERE book_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                deleteSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleteSuccessful;

    }

    private Set<Book> mapResultSet(ResultSet rs) {

        Set<Book> books = new HashSet<>();

        try {

            while (rs.next()) {

                books.add(new Book()
                        .setId(rs.getInt("book_id"))
                        .setIsbn(rs.getString("isbn"))
                        .setTitle(rs.getString("title"))
                        .setAuthor(new Author(rs.getString("author_fn"), rs.getString("author_ln")))
                        .setGenre(Genre.getGenreById(rs.getInt("genre_id")))
                        .setPrice(rs.getDouble("price"))
                        .setStockCount(rs.getInt("stock_count")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;

    }

}
