package com.revature.revabooks.models;

import java.util.HashSet;
import java.util.Objects;

public class Book {
    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private Genre genre;
    private double price;
    private  int stockCount;

    public Book() {
        super();
    }

    public Book(String isbn, String title, Author author, Genre genre, double price, int stockCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.stockCount = stockCount;
    }

    public Book(Integer id, String isbn, String title, Author author, Genre genre, double price, int stockCount) {
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
    public void setId(Integer id) {
        this.id = id;
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
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStockCount() {
        return stockCount;
    }
    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                stockCount == book.stockCount &&
                Objects.equals(id, book.id) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                genre == book.genre;
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
