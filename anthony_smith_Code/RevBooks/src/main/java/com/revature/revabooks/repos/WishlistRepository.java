package com.revature.revabooks.repos;

import com.revature.revabooks.models.Wishlist;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class WishlistRepository {

    public Wishlist getWishlistByUserId(int userId){

        Wishlist userWishList = new Wishlist();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM user wishlist w " +
                    "JOIN users users " +
                    "USING (user_id) " +
                    "JOIN  books " +
                    "USING (book_id) "

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
