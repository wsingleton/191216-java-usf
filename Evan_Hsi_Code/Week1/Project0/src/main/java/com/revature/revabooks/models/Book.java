package com.revature.revabooks.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {

    private int id;
    private String ISBN;
    private String title;
    private Author author;
    private int stock;
    private Genre genre;
    private double price;

    public Book() {
    }

    public Book(String ISBN, String title, Author author, Genre genre) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String ISBN, String title, Author author, int stock, Genre genre, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.genre = genre;
        this.price = price;
    }

    public Book(int id, String ISBN, String title, Author author, Genre genre, int stock) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                stock == book.stock &&
                Double.compare(book.price, price) == 0 &&
                Objects.equals(ISBN, book.ISBN) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ISBN, title, author, stock, genre, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", stock=" + stock +
                ", genre=" + genre +
                ", price=" + price +
                '}';
    }
}
