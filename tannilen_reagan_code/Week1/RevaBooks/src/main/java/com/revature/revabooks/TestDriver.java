package com.revature.revabooks;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.User;
import com.revature.revabooks.models.WishList;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.repos.WishlistRepository;
import com.revature.revabooks.util.ConnectionFactory;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.Connection;
import java.util.Set;

public class TestDriver {
    public static void main(String[] args) {
        WishlistRepository testRepo = new WishlistRepository();
        WishList didItWork = testRepo.getUserWishlistByUserID(1);
        System.out.println(didItWork.getOwner());
        didItWork.getWishlist().forEach(book-> System.out.println(book));
    }
}