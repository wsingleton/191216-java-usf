package com.revature.revabooks.screens;

import com.revature.revabooks.services.BookService;

public class SearchBooksScreen extends Screen {

    private String name = "SearchBooksScreen";
    private String route = "/search";
    BookService bookService;

    public SearchBooksScreen() {
        super("SearchBooksScreen", "/search");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

    }
}
