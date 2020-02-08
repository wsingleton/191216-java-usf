package com.revature.movie.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USERS")
@SequenceGenerator(name ="user_gen", sequenceName = "user_seq", allocationSize = 1)
public class User {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_gen")
    private int id;


    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false, unique = true)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private int failTime;

    @Column(nullable=false, unique = true)
    private String email;

    @Column(nullable=false)
    private String role;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="User_favorite",
            joinColumns=@JoinColumn(name="favoriteId"),
            inverseJoinColumns=@JoinColumn(name="id")
    )
    private List<FavoriteList> list;

    public User() {super();
    }

    public User(String firstName, String lastName, String username, String password, int failTime, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.failTime = failTime;
        this.email = email;
        this.role = role;
    }

    public User(int id, String firstName, String lastName, String username, String password, int failTime, String email, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.failTime = failTime;
        this.email = email;
        this.role = role;
    }

    public User(String firstName, String lastName, String username, String password, int failTime, String email, String role, List<FavoriteList> list) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.failTime = failTime;
        this.email = email;
        this.role = role;
        this.list = list;
    }

    public User(int id, String firstName, String lastName, String username, String password, int failTime, String email, String role, List<FavoriteList> list) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.failTime = failTime;
        this.email = email;
        this.role = role;
        this.list = list;
    }


    public List<FavoriteList> getList() {
        return list;
    }

    public void setList(List<FavoriteList> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFailTime() {
        return failTime;
    }

    public void setFailTime(int failTime) {
        this.failTime = failTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public void addLists(FavoriteList... users1) {
        if (list == null) list = new ArrayList<>();
        for (FavoriteList u : users1) {
            list.add(u);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", failTime=" + failTime +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", list=" + list +
                '}';
    }
}
