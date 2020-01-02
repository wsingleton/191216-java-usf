package com.revature.revabooks.screens;

import com.revature.revabooks.services.BookService;

public class SearchBooksScreen extends Screen {

    private String name = "SearchBooksScreen";
    private String route = "/search";
    private BookService bookService;

    public SearchBooksScreen(String name, String route, BookService bookService) {
        this.name = name;
        this.route = route;
        this.bookService = bookService;
    }

    public SearchBooksScreen(String name, String route, String name1, String route1, BookService bookService) {
        super(name, route);
        this.name = name1;
        this.route = route1;
        this.bookService = bookService;
    }

    public void render(){

    }
}
