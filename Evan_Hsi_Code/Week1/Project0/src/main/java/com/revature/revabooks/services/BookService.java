package com.revature.revabooks.services;

import com.revature.revabooks.models.Book;
import com.revature.revabooks.models.Genre;
import com.revature.revabooks.repositories.BookRepository;

import java.util.Set;

public class BookService {

    private BookRepository bookRepo;
/*

    public Set<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Set<Book> getBooksByGenre(Genre genre) {
        return bookRepo.findBooksByGenre(genre);
    }

    public Set<Book> getBooksByAuthor(String authorLastName) {
        return bookRepo.findBooksByAuthor(authorLastName);
    }

    public Set<Book> getBooksByTitle(String title) {
        return bookRepo.findBooksByTitle(title);
    }

    public Book getBookById(int id) {
        return (Book) bookRepo.findById(id);
    }

    public Book getBookByISBN(String isbn) {
        return bookRepo.findBookByISBN(isbn);
    }

    public void addBookToInventory(Book book) {
        bookRepo.save(book);
    }

    public Book updateBook(Book book) {
        if(bookRepo.update(book)) return book;
        else return null;
    }

    public boolean removeBookFromInventoryByID(int id) {
        return bookRepo.deleteById(id);
    }

    public boolean validateBookFields(Book book) {
        return true;
    }

 */
}
