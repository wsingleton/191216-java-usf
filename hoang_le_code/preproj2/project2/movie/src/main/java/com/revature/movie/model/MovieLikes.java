package com.revature.movie.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "MOVIES_LIKES")
@SequenceGenerator(name = "movies_gen", sequenceName = "movies_seq", allocationSize = 1)
public class MovieLikes {
    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movies_gen")
    private int id;
    @Column(name = "MOVIE_TITLE", nullable = false)
    private String title;
    @Column(name = "LIKES")
    private int likes;

    public MovieLikes() {
        super();
    }

    public MovieLikes(int id, String title, int likes) {
        this.id = id;
        this.title = title;
        this.likes = likes;
    }

    public MovieLikes(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieLikes movieLikes = (MovieLikes) o;
        return id == movieLikes.id &&
                likes == movieLikes.likes &&
                Objects.equals(title, movieLikes.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, likes);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + likes +
                '}';
    }
}
