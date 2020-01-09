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

//        UserRepository testRepo = new UserRepository();
//        Set<User> didItWork = testRepo.findAll();
//        didItWork.forEach(user -> System.out.println(user));

//        BookRepository testRepo1 = new BookRepository();
//        Set<Book> didItWork1 = testRepo1.findAll();
//        didItWork1.forEach(book -> System.out.println(book));

        WishListRepository testRepo = new WishListRepository();
        WishList didItWork = testRepo.getWishListByUserId(1);
        System.out.println(didItWork);
        System.out.println(didItWork.getOwner());
        didItWork.getBookWishList().forEach(book -> System.out.println(book));


    }
}
