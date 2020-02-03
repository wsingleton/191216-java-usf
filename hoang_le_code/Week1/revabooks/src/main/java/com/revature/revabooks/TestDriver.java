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

    public static void main(String[] args) {




        WishlistRepository testRepo = new WishlistRepository();
        Wishlist didItWork = testRepo.getWishlistByUserId(1);
        System.out.println(didItWork);
        System.out.println(didItWork.getOwner());
        didItWork.getBookWishlist().forEach(book -> System.out.println(book));

    }

}