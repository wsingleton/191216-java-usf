package com.revature.revabooks.repositories;

import com.revature.revabooks.models.*;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class WishlistRepository implements CrudRepository {

    public Wishlist getWishlistByUserId(int id){
        Wishlist userWishList = new Wishlist();
        Set<Book> bookSet = new HashSet<>();

        try(Connection  conn = ConnectionFactory.getInstance().getConnection()){
            String sql="SELECT * FROM user_wishlists w JOIN users u ON w.user_id = u.user_id "+"" +
                    "JOIN books b ON b.book_id = w.book_id WHERE w.user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            User owner = new User();
            Book book = new Book();
            boolean ownerCreated = false;
            while (rs.next()){
                if(!ownerCreated){
                    owner.setId(rs.getInt("user_id"));
                    owner.setUsername(rs.getString("username"));
                    owner.setPassword(rs.getString("password"));
                    owner.setFirstName(rs.getString("first_name"));
                    owner.setLastName(rs.getString("last_name"));
                    owner.setRole(Role.getRoleByID(rs.getInt("genre_id")));
                    ownerCreated = true;
                }
                book.setId(rs.getInt("book_id"));
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(new Author(rs.getString("author_fn"), rs.getString("author_ln")));
                book.setGenre(Genre.getGenreById(rs.getInt("genre_id")));
                book.setStockCount(rs.getInt("stock_count"));
                book.setPrice(rs.getInt("price"));
                bookSet.add(book);
            }
            return userWishList = new Wishlist(owner, bookSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userWishList;
    }

    @Override
    public void save(Object newObj) {

    }

    @Override
    public Set findAll() {
        return null;
    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Object o) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
