package com.revature.revabooks.screens;

import com.revature.revabooks.services.BookService;

public class SearchBooksScreen extends Screen {

    private BookService bserv;

    public SearchBooksScreen(BookService bserv) {
        super("SearchBooksScreen", "/bsearch");
        this.bserv = bserv;
        System.out.println("[LOG] - Instantiating " + super.getName() + " With Book Service.");
    }

    public SearchBooksScreen() {
        super("SearchBooksScreen", "/bsearch");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public void render() {
        System.out.println("SearchBooksScreen");
    }
}
