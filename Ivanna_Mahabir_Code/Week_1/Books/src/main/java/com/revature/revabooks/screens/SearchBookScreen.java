package com.revature.revabooks.screens;

import com.revature.revabooks.services.BookService;

public class SearchBookScreen extends Screen {

    public SearchBookScreen(){
        super("SearchBookScreen", "/search");
        System.out.println("[LOG] - instantiating " + super.getName());
    }

    @Override
    public void render() {

    }
}
