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

public class WishlistRepository implements CrudRepository<WishList> {
    public WishList getUserWishlistByUserID(int userID) {
        WishList userWishList=new WishList();
        Set<Book> books=new HashSet<Book>();
        try (Connection conn= ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM user_wishlists w JOIN users u on w.user_id=u.user_id JOIN books b on w.book_id=b.book_id WHERE w.user_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            ResultSet rs=pstmt.executeQuery();
            User owner=new User();
            boolean ownerCreated=false;
            while (rs.next()) {
                if (!ownerCreated) {
                    owner.setId(rs.getInt("user_id"));
                    owner.setUsername(rs.getString("username"));
                    owner.setPassword(rs.getString("pass_hash"));
                    owner.setFirstName(rs.getString("given_name"));
                    owner.setLastName(rs.getString("family_name"));
                    owner.setRole(Role.getRoleById(rs.getInt("role_id")));
                    ownerCreated=true;
                }
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
            userWishList.setOwner(owner);
            userWishList.setWishlist(books);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userWishList;
    }
    @Override
    public void save(WishList wishList) {

    }
    @Override
    public Set<WishList> findAll() {
        return null;
    }
    @Override
    public Optional<WishList> findByID(Integer id) {
        return Optional.empty();
    }
    @Override
    public boolean update(WishList wishList) {
        return false;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return false;
    }
}
