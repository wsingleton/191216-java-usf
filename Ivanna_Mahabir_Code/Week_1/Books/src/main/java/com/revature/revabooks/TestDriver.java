package com.revature.revabooks;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.User;
import com.revature.revabooks.models.Wishlist;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.repos.WishlistRepository;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Set;

public class TestDriver {
    public static void main(String[] args){
/*
        needed to establish the connection to the database
        Connection conn = ConnectionFactory.getInstance().getConnection();

        if(conn == null) System.out.println("Connection failed.");
        else System.out.println("Connection successful!");*/

/*        UserRepository testRepo = new UserRepository();
        Set<User> didItWork = testRepo.findAll();
        didItWork.forEach(user -> System.out.println(user));*/

/*        BookRepository testRepo = new BookRepository();
        Set<Book> didItWork = testRepo.findAll();
        didItWork.forEach(book -> System.out.println(book));*/

        WishlistRepository testRepo = new WishlistRepository();
        Wishlist didItWork = testRepo.getWishlistByUserId(1);
        System.out.println(didItWork);
        System.out.println(didItWork.getOwner());
        didItWork.getBookWishlist().forEach(book -> System.out.println(book));
    }
}
