package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.Author;
import com.revature.revabooks.models.Book;
import com.revature.revabooks.services.BookService;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.revature.revabooks.AppDriver.*;

public class SearchBooksScreen extends Screen {

    private BookService bookService;

    public SearchBooksScreen(BookService bookService) {
        super("SearchBooksScreen", "/search");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.bookService = bookService;
    }

    @Override
    public void render() {

        String userSelection;
        Set<Book> matchingBooks = new HashSet<>();
        Book matchingBook;
        boolean loopMenu = true;

        while (loopMenu) {
            System.out.println("\n\n+---------------------------------+\n");
            System.out.println("1) Search books by title");
            System.out.println("2) Search books by author");
            System.out.println("3) Search books by genre");
            System.out.println("4) Search books by ISBN");
            System.out.println("5) Search all books");
            System.out.println("6) Back to Dashboard");

            try {

                // Get user's menu selection
                System.out.print("Selection: ");
                userSelection = console.readLine();

                switch (userSelection) {
                    case "1":

                        System.out.print("Enter a title to search for: ");
                        String bookTitle = console.readLine();

                        matchingBooks = bookService.getBooksByTitle(bookTitle);
                        if (matchingBooks != null) showBooks(matchingBooks);
                        break;

                    case "2":

                        System.out.print("Enter first name of the author you are searching for: ");
                        String authorFirstName = console.readLine();
                        System.out.print("Enter last name of the author you are searching for: ");
                        String authorLastName = console.readLine();

                        Author author = new Author(authorFirstName, authorLastName);
                        matchingBooks = bookService.getBooksByAuthor(author);
                        if (matchingBooks != null) showBooks(matchingBooks);
                        break;

                    case "3":

                        System.out.print("Enter a genre to search for: ");
                        String bookGenre = console.readLine();

                        matchingBooks = bookService.getBooksByGenre(bookGenre);
                        if (matchingBooks != null) showBooks(matchingBooks);
                        break;

                    case "4":

                        System.out.print("Enter an ISBN to search for: ");
                        String bookIsbn = console.readLine();

                        matchingBook = bookService.getBookByIsbn(bookIsbn);
                        if (matchingBook != null) matchingBooks.add(matchingBook);
                        showBooks(matchingBooks);
                        break;

                    case "5":
                        showBooks(bookService.getAllBooks());
                        break;
                    case "6":
                        loopMenu = false;
                        break;
                    default:
                        System.out.println("Invalid Selection!");
                }

            } catch (InvalidRequestException e) {
                System.err.println("Your request could not be processed. Returning to dashboard...");
                loopMenu = false;
            } catch (Exception e) {
                System.err.println("[ERROR] - " + e.getMessage());
                System.out.println("[LOG] - Shutting down application");
                loopMenu = false;
                appRunning = false;
            }
        }
    }

    private void showBooks(Set<Book> books) {

        if(books.size() == 0) {
            System.out.println("No results found.");
            return;
        }

        System.out.println("\nResults: \n+--------------------+");

        books.forEach(book -> {
            System.out.printf("\n\nTitle: %s", book.getTitle());
            System.out.printf("\nAuthor: %s", book.getAuthor());
            System.out.printf("\nGenre: %s", book.getGenre());
            System.out.printf("\nISBN: %s", book.getIsbn());
            System.out.printf("\n# in stock: %d \n", book.getStockCount());

            // Undergoing refactor
//            if(!currentUser.getWishlist().contains(book)) {
//                try {
//                    String userSelection;
//                    System.out.print("\nAdd to Wishlist? [Y/N]: ");
//                    userSelection = console.readLine();
//
//                    if (userSelection.equalsIgnoreCase("Y")) {
//                        System.out.println("Attempting to add book to wishlist...");
//                        bookService.addBookToWishList(book);
//                    }
//
//                } catch (IOException e) {
//                    System.err.println(e);
//                }
//            }

            System.out.println("Fetching next book...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }

}
