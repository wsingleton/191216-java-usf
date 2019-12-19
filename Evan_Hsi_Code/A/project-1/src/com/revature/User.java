package com.revature;

import java.util.Objects;
import java.util.*;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;
    private ArrayList<Account> accounts;

    public User() {
    }

    public User(String firstName, String lastName, String userName, String password, Role role, ArrayList<Account> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.accounts = accounts;
    }

    public User(int id, String firstName, String lastName, String userName, String password, Role role, ArrayList<Account> accounts) {
        this(firstName, lastName, userName, password, role, accounts);
        this.id = id;
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
        if(firstName.equals("")) {
            System.out.println("Invalid First Name: No Input");
            return;
        }
        if(firstName.length() < 2 || firstName.length() > 15) {
            System.out.println("Invalid First Name: Invalid Length");
            return;
        }
        for(int i = 0; i < firstName.length(); i++) {
            if(!Character.isAlphabetic(firstName.charAt(i))) {
                System.out.println("Invalid First Name: Cannot Contain Non-Alphabetical Characters");
                return;
            }
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.equals("")) {
            System.out.println("Invalid Last Name: No Input");
            return;
        }
        if(lastName.length() < 2 || lastName.length() > 15) {
            System.out.println("Invalid Last Name: Invalid Length");
            return;
        }
        for(int i = 0; i < lastName.length(); i++) {
            if(!Character.isAlphabetic(firstName.charAt(i)) && !(firstName.charAt(i) == '-')) {
                System.out.println("Invalid Last Name: Cannot Contain Non-Alphabetical, Non-Hyphen Characters");
                return;
            }
        }
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.equals("")) {
            System.out.println("Invalid Password: No Input");
            return;
        }
        if(password.length() < 8) {
            System.out.println("Invalid Password: Invalid Length");
            return;
        }
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

}
