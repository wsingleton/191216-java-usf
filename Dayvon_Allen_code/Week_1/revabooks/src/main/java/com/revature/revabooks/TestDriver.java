package com.revature.revabooks;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.User;
import com.revature.revabooks.models.WishList;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.repos.WishlistRepository;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Optional;
import java.util.Set;

public class TestDriver {

    public static void main(String[] args) {

        Connection conn = ConnectionFactory.getInstance().getConnection();

        if(conn == null) System.out.println("Connection Failed");
        else System.out.println("Connection Successful!");

//        UserRepository testRepo = new UserRepository();
//        Set<User> did = testRepo.findAll();
//        did.forEach(user -> System.out.println(user));

//        BookRepository bookRepo = new BookRepository();
//        Set<Book> doThing = bookRepo.findAll();
//        doThing.forEach(book -> System.out.println(book));
        WishlistRepository testRepo = new WishlistRepository();
        WishList didWork = testRepo.getWishlistByUserId(1);
        System.out.println(didWork);
        System.out.println(didWork.getOwner());
        didWork.getBookWishList().forEach(book -> System.out.println(book));

    }
}
