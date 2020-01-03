package com.revature.revabooks.screens;

import com.revature.revabooks.services.BookService;

public class SearchBooksScreen extends Screen {
    public SearchBooksScreen() {
        super("SearchBooksScreen", "/search");
        System.out.println("[LOG] - Instantiating " + this.getName());
    }
    BookService bookService;
    public void render() {

    }
}
