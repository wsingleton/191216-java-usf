package com.revature.revabooks.models;

import sun.security.krb5.internal.crypto.Aes128;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Wishlist {
    private User owner;
    private Set<Book> bookWishlist;

    public Wishlist(){
        super();
        bookWishlist = new HashSet<>();
    }

    public Wishlist(User owner, Set<Book> bookWishlist) {
        this.owner = owner;
        this.bookWishlist = bookWishlist;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Book> getBookWishlist() {
        return bookWishlist;
    }

    public void setBookWishlist(Set<Book> bookWishlist) {
        this.bookWishlist = bookWishlist;
    }
    public void addBookToWishlist(Book book){
        bookWishlist.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return Objects.equals(owner, wishlist.owner) &&
                Objects.equals(bookWishlist, wishlist.bookWishlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, bookWishlist);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "owner=" + owner +
                ", bookWishlist=" + bookWishlist +
                '}';
    }
}
