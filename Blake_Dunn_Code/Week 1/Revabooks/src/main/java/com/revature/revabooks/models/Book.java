package com.revature.revabooks.models;

import java.util.Objects;
import java.util.Set;

public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private Genre genres;
    private Double price;
    private Integer stockCount;

    public Book(Integer id, String isbn, String title, Author author, Genre genres, Double price, Integer stockCount) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.price = price;
        this.stockCount = stockCount;
    }

    public Book() {
        super();
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

    public Genre getGenres() {
        return genres;
    }

    public void setGenres(Genre genres) {
        this.genres = genres;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
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
                genres == book.genres &&
                Objects.equals(price, book.price) &&
                Objects.equals(stockCount, book.stockCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, genres, price, stockCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", genres=" + genres +
                ", price=" + price +
                ", stockCount=" + stockCount +
                '}';
    }
}
