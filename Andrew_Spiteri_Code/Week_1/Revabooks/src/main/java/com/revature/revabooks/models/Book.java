package com.revature.revabooks.models;

import java.util.*;

public class Book {
    private Integer id, stockCount;
    private String isbn, title;
    private Author author;
    Genre genre;

    public Book(Integer id, Integer stockCount, String isbn, String title, Author author, Genre genre) {
        this.id = id;
        this.stockCount = stockCount;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    public Book(Integer id, String isbn, String title, Author author, Genre genre) {
        this.id = id;
        //this.stockCount = stockCount;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenres() {
        return genre;
    }

    public void setGenres(Set<Genre> genres) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(stockCount, book.stockCount) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockCount, isbn, title, author, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", stockCount=" + stockCount +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}
