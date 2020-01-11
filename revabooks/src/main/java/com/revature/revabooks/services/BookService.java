package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthorizationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourceNotFoundException;
import com.revature.revabooks.models.*;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.WishlistRepository;

import java.util.Set;

import static com.revature.revabooks.AppDriver.currentSession;

public class BookService {

    private BookRepository bookRepo;
    private WishlistRepository wishlistRepo;

    public BookService(BookRepository bookRepo, WishlistRepository wishlistRepo) {
        this.bookRepo = bookRepo;
        this.wishlistRepo = wishlistRepo;
    }

    public Set<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(int id) {

        if (!isCurrentUserAdminOrManager()) {
            throw new AuthorizationException();
        }

        if (id < 1) {
            throw new InvalidRequestException();
        }

        return bookRepo.findById(id).orElseThrow(ResourceNotFoundException::new);

    }

    public Book getBookByIsbn(String isbn) {

        if(isbn.trim().equals("") || isbn.length() < 10 || isbn.length() > 14) {
            throw new InvalidRequestException();
        }

        return bookRepo.findBookByIsbn(isbn).orElseThrow(ResourceNotFoundException::new);
    }

    public Set<Book> getBooksByTitle(String title) {

        if(title.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return bookRepo.findBooksByTitle(title);
    }

    public Set<Book> getBooksByAuthor(Author author) {
        if(author == null || author.getFirstName().equals("") || author.getLastName().equals("")) return null;
        return bookRepo.findBooksByAuthor(author);
    }

    public Set<Book> getBooksByGenre(String genreStr) {

        Genre genre;

        try {
            genre = Genre.valueOf(genreStr.toUpperCase());
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidRequestException();
        }

        return bookRepo.findBooksByGenre(genre);
    }

    public void addBook(Book newBook) {

        if (!isCurrentUserAdminOrManager()) {
            throw new AuthorizationException();
        }

        if (!isBookValid(newBook)) {
            throw new InvalidRequestException();
        }

        bookRepo.save(newBook);

    }

    public boolean updateBook(Book updatedBook) {

        if (!isCurrentUserAdminOrManager()) {
            throw new AuthorizationException();
        }

        if (!isBookValid(updatedBook)) {
            throw new InvalidRequestException();
        }

        return bookRepo.update(updatedBook);
    }

    public boolean deleteBook(int id) {

        if (!isCurrentUserAdminOrManager()) {
            throw new AuthorizationException();
        }

        return bookRepo.deleteById(id);
    }

    public boolean addBookToWishList(Book book) {

        System.out.println("Method undergoing refactor...");
        return false;

    }

    private boolean isBookValid(Book updatedBook) {
        return !updatedBook.getIsbn().equals("") && !updatedBook.getTitle().equals("") && !updatedBook.getAuthor().equals("")
                && !updatedBook.getGenre().equals("") && updatedBook.getStockCount() > 0;
    }

    private boolean isCurrentUserAdminOrManager() {
        Role currentUserRole = currentSession.getSessionUser().getRole();
        return (currentUserRole.equals(Role.ADMIN) || currentUserRole.equals(Role.MANAGER));
    }

}
