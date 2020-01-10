package com.revature.revabooks.repos;

import com.revature.revabooks.models.*;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class WishlistRepository implements CrudRepository<Wishlist> {

    public Wishlist getWishlistByUserId(int userId){
        Wishlist userWishlist = new Wishlist();
        Set<Book> bookSet = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM user_wishlists w " +
                         "JOIN users u " +
                         "ON w.user_id = u.user_id " +
                         "JOIN books b " +
                         "ON w.book_id = b.book_id " +
                         "WHERE w.user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            User owner = new User();
            boolean ownerCreated = false;
            while (rs.next()){
                if(!ownerCreated){
                    owner.setId(rs.getInt("user_id"));
                    owner.setUserName(rs.getString("username"));
                    owner.setPassword(rs.getString("password"));
                    owner.setFirstName(rs.getString("first_name"));
                    owner.setLastName(rs.getString("last_name"));
                    owner.setRole(Role.getRoleById(rs.getInt("role_id")));
                    ownerCreated = true;
                }

                Book temp = new Book();
                temp.setId(rs.getInt("book_id"));
                temp.setIsbn(rs.getString("isbn"));
                temp.setTitle(rs.getString("title"));
                temp.setAuthor(new Author(rs.getString("author_fn"), rs.getString("author_ln")));
                temp.setGenre(Genre.getGenreById(rs.getInt("genre_id")));
                temp.setStockCount(rs.getInt("stock_count"));
                temp.setPrice(rs.getDouble("price"));
                bookSet.add(temp);
            }

            userWishlist.setOwner(owner);
            userWishlist.setBookWishlist(bookSet);

        } catch (SQLException e){
            e.printStackTrace();
        }

        return userWishlist;
    }

    @Override
    public void save(Wishlist newObj) {

    }

    @Override
    public Set<Wishlist> findAll() {
        return null;
    }

    @Override
    public Optional<Wishlist> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Wishlist updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
