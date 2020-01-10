package com.revature.revabooks;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.User;
import com.revature.revabooks.models.Wishlist;
import com.revature.revabooks.repositories.BookRepository;
import com.revature.revabooks.repositories.UserRepository;
import com.revature.revabooks.repositories.WishlistRepository;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Set;

public class TestDriver {
    public static void main(String[] args) {
        Connection conn = ConnectionFactory.getInstance().getConnection();

        if(conn == null)System.out.println("Connection failed");
        else{ System.out.println("Connection successful.");}

        WishlistRepository testRepo = new WishlistRepository();
        Wishlist didItWork = testRepo.getWishlistByUserId(1);
        didItWork.getBookWishList().forEach(book -> System.out.println(book));
    }
}
