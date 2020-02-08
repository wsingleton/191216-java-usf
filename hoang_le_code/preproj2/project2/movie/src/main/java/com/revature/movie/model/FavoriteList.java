package com.revature.movie.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FAVORITE_LIST")
@SequenceGenerator(name = "favorite_gen", sequenceName = "favorite_seq", allocationSize = 1)
public class FavoriteList {

    @Id
    @Column(name = "FAVORITE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="favorite_gen")
    private int favoriteId;


    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="favorite_user",
            joinColumns=@JoinColumn(name="favoriteId"),
            inverseJoinColumns=@JoinColumn(name="id")
    )
    private List<User> users;


    @Column(name = "MOVIE_NAME", nullable = false)
    private String movieName;

    @Column( name = "API_ID", nullable = false)
    private int apiId;


    public FavoriteList() {
        super();
    }

    public FavoriteList(String movieName, int apiId) {
        this.movieName = movieName;
        this.apiId = apiId;
    }

    public FavoriteList(int favoriteId, List<User> users, String movieName, int apiId) {
        this.favoriteId = favoriteId;
        this.users = users;
        this.movieName = movieName;
        this.apiId = apiId;
    }

    public FavoriteList(String movieName) {
        this.movieName = movieName;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public void addUsers(User... users1) {
        if (users == null) users = new ArrayList<>();
        for (User u : users1) {
            users.add(u);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteList that = (FavoriteList) o;
        return favoriteId == that.favoriteId &&
                apiId == that.apiId &&
                Objects.equals(users, that.users) &&
                Objects.equals(movieName, that.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteId, users, movieName, apiId);
    }

    @Override
    public String toString() {
        return "FavoriteList{" +
                "favoriteId=" + favoriteId +
                ", users=" + users +
                ", movieName='" + movieName + '\'' +
                ", apiId=" + apiId +
                '}';
    }
}
