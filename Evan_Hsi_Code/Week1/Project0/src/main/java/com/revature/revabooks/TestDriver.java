package com.revature.revabooks;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.User;
import com.revature.revabooks.models.Wishlist;
import com.revature.revabooks.repositories.BookRepository;
import com.revature.revabooks.repositories.UserRepository;
import com.revature.revabooks.repositories.WishlistRepository;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class TestDriver {

    public static void main(String[] args) {
/*
        WishlistRepository testRepo = new WishlistRepository();
        Wishlist didItWork = testRepo.getWishlistByUserID(1);
        System.out.println(didItWork);
        System.out.println(didItWork.getOwner());
        didItWork.getBookWishlist().forEach(book -> System.out.println(book));

 */

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            UserRepository testRepo = new UserRepository();
            Set<User> userSet = testRepo.findAll();
            userSet.forEach(User -> System.out.println(User));

            String sql = "DELETE FROM USERS WHERE USER_ID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 25);
            pstmt.executeUpdate();

            System.out.println("Deleted successfully");

            userSet = testRepo.findAll();
            userSet.forEach(User -> System.out.println(User));


        } catch (SQLIntegrityConstraintViolationException e) { e.printStackTrace(); }
        catch (SQLException e) { e.printStackTrace(); }

    }
}
