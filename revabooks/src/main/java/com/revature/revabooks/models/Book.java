package com.revature.revabooks.models;

import java.util.Objects;
import java.util.Set;

public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private Genre genre;
    private Double price;
    private Integer stockCount;

    public Book() {
        super();
    }

    public Book(String isbn, String title, Author author, Genre genre, Double price, Integer stockCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.stockCount = stockCount;
    }

    public Book(Integer id, String isbn, String title, Author author, Genre genre, Double price, Integer stockCount) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.stockCount = stockCount;
    }

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Book setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public Book setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                genre == book.genre &&
                Objects.equals(price, book.price) &&
                Objects.equals(stockCount, book.stockCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, genre, price, stockCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", price=" + price +
                ", stockCount=" + stockCount +
                '}';
    }

}
