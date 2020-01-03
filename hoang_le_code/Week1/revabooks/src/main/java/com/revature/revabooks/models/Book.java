package com.revature.revabooks.models;

import java.util.Objects;
import java.util.Set;

public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private Genre genre;
    private Integer stockCount;

    public Book(String isbn, String title, Author author, Genre genres) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genres;
    }

    public Book(Integer id, String isbn, String title, Author author, Genre genres, Integer stockCount) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genres;
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

    public void setGenre(Genre genres) {
        this.genre = genres;
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
                genre == book.genre &&
                Objects.equals(stockCount, book.stockCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, genre, stockCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", stockCount=" + stockCount +
                '}';
    }
}