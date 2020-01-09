package com.revature.revabooks;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Set;

public class TestDriver {

    public static void main(String[] args) {

        BookRepository testRepo = new BookRepository();
        Set<Book> didItWork = testRepo.findAll();
        didItWork.forEach(book -> System.out.println(book));

    }

}
