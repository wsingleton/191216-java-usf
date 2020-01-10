package com.revature.revabooks.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



public class Wishlist {
    private User owner;
    private Set<Book> bookWishList;

    public Wishlist(){
        super();
        bookWishList = new HashSet<>();
    }

    public Wishlist(User owner, Set<Book> bookWishList) {
        this.owner = owner;
        this.bookWishList = bookWishList;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Book> getBookWishList() {
        return bookWishList;
    }

    public void setBookWishList(Set<Book> bookWishList) {
        this.bookWishList = bookWishList;
    }

    public void addBookToWishList(Book book){
        bookWishList.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return Objects.equals(owner, wishlist.owner) &&
                Objects.equals(bookWishList, wishlist.bookWishList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, bookWishList);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "owner=" + owner +
                ", bookWishList=" + bookWishList +
                '}';
    }
}
