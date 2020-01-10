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

//        Connection conn = ConnectionFactory.getInstance().getConnection();
//
//        if (conn == null) System.out.println("Connection failed");
//        else System.out.println("Connection successful");

//        BookRepository testRepo = new BookRepository();
//        Set<Book> didItWork = testRepo.findAll();
//        didItWork.forEach(book-> System.out.println(book));

        WishListRepository testRepo= new WishListRepository();
        WishList didItWork = testRepo.getWishListByUserId(1);
        System.out.println(didItWork);
        System.out.println(didItWork.getOwner());
        didItWork.getBookWishList().forEach(book -> System.out.println(book));


    }


}
