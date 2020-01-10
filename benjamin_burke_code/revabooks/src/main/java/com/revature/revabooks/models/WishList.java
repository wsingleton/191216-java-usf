package com.revature.revabooks.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WishList {
    private User owner;
    private Set<Book> bookWishList;

    public WishList(){
        super();
        bookWishList = new HashSet<>();
    }

    public WishList(User owner, Set<Book> bookWishList) {
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

    public void addBookToWishlist(Book book){
        bookWishList.add(book);
    }

    @Override
    public String toString() {
        return "WishList{" +
                "owner=" + owner +
                ", bookWishList=" + bookWishList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return Objects.equals(owner, wishList.owner) &&
                Objects.equals(bookWishList, wishList.bookWishList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, bookWishList);
    }
}
