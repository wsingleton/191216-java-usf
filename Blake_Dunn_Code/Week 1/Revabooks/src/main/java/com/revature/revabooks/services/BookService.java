package com.revature.revabooks.services;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.repos.BookRepository;

import java.util.Set;

public class BookService {

    private BookRepository bookRepo;

    public Set<Book> getAllBooks() {
        return null;
    }

    public Set<Book> getBooksByGenre(Genre genre) {
        return null;
    }

    public Set<Book> getBooksByAuthor(String authorLastName) {
        return null;
    }

    public Set<Book> getBooksByTitle(String title) {
        return null;
    }

    public Book getBookById(Integer id) {
        return null;
    }

    public Book getBookByIsbn(String isbn) {
        return null;
    }

    public Book addBookToInventory(Book book) {
        return null;
    }

    public boolean updateBook(Book book) {
        return true;
    }

    public boolean removeBookFromInventoryById(Integer id) {
        return true;
    }

    public boolean validateBookFields(Book book) {
        return true;
    }
}
