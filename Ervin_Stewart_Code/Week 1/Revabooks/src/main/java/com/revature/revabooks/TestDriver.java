package com.revature.revabooks;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.User;
import com.revature.revabooks.models.WishList;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.repos.WishListRepository;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Set;

public class TestDriver {
    public static void main(String[] args) {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        if(conn == null) System.out.println("connection failed motherfucker!");
        else System.out.println("Connection Success!");

        System.out.println("+------------------+");
        UserRepository testRepo = new UserRepository();
        Set<User> didItWork = testRepo.findAll();
        didItWork.forEach(user -> System.out.println(user));

        System.out.println("+------------------+");
        BookRepository testBRepo = new BookRepository();
        Set<Book> hopeItWorked = testBRepo.findAll();
        hopeItWorked.forEach(book -> System.out.println(book));

        System.out.println("+------------------+");
        WishListRepository testWLRepo = new WishListRepository();
        WishList manItBetterWork = testWLRepo.getWishlistByUserId(1);
        System.out.println(manItBetterWork);
        System.out.println(manItBetterWork.getOwner());
        manItBetterWork.getBookWishList().forEach(book -> System.out.println(book));
    }
}
