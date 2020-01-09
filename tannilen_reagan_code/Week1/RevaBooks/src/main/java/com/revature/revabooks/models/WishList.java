package com.revature.revabooks.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WishList {
    private User owner;
    private Set<Book> wishlist;
    public WishList() {
        super();
        wishlist=new HashSet<Book>();
    }
    public WishList(User owner, Set<Book> wishlist) {
        this.owner = owner;
        this.wishlist = wishlist;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public Set<Book> getWishlist() {
        return wishlist;
    }
    public void setWishlist(Set<Book> wishlist) {
        this.wishlist = wishlist;
    }
    public void addBookToWishlist(Book book) {
        wishlist.add(book);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return Objects.equals(owner, wishList.owner) &&
                Objects.equals(wishlist, wishList.wishlist);
    }
    @Override
    public int hashCode() {
        return Objects.hash(owner, wishlist);
    }
    @Override
    public String toString() {
        return "WishList{" +
                "owner=" + owner +
                ", wishlist=" + wishlist +
                '}';
    }
}
