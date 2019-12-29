package com.revature;

import java.util.Objects;
import java.util.*;

public class User {

    private int id = -1;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;
    private ArrayList<Account> accounts;

    public User() {
        this.accounts = new ArrayList<Account>();
    }

    public User(String firstName, String lastName, String userName, String password, Role role) {
        this.id = userName.hashCode();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.accounts = new ArrayList<Account>();
    }

    public User(int id, String firstName, String lastName, String userName, String password, Role role) {
        this(firstName, lastName, userName, password, role);
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

    public boolean setFirstName(String firstName) {
        if(firstName.equals("")) {
            System.out.println("Invalid First Name: No Input");
            return false;
        }
        if(firstName.length() < 2 || firstName.length() > 15) {
            System.out.println("Invalid First Name: Invalid Length");
            return false;
        }
        for(int i = 0; i < firstName.length(); i++) {
            if(!Character.isAlphabetic(firstName.charAt(i))) {
                System.out.println("Invalid First Name: Cannot Contain Non-Alphabetical Characters");
                return false;
            }
        }

        this.firstName = firstName;
        return true;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if(lastName.equals("")) {
            System.out.println("Invalid Last Name: No Input");
            return false;
        }
        if(!(lastName.length() > 2 && lastName.length() < 20)) {
            System.out.println("Invalid Last Name: Invalid Length");
            return false;
        }
        for(int i = 0; i < lastName.length(); i++) {
            if(!Character.isAlphabetic(lastName.charAt(i)) && !(lastName.charAt(i) == '-')) {
                System.out.println("Invalid Last Name: Cannot Contain Non-Alphabetical, Non-Hyphen Characters");
                return false;
            }
        }
        this.lastName = lastName;
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public boolean setUserName(String userName) {
        if(userName.equals("")) {
            System.out.println("Invalid username: No Input");
            return false;
        }
        if(!(userName.length() > 3 && userName.length() < 20)) {
            System.out.println("Invalid username: Invalid Length");
            return false;
        }
        this.userName = userName;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if(password.equals("")) {
            System.out.println("Invalid Password: No Input");
            return false;
        }
        if(password.length() < 8) {
            System.out.println("Invalid Password: Invalid Length");
            return false;
        }
        this.password = password;
        return true;
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

    public Account getAccount(int index) {
        return accounts.get(index);
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public int getAccountsLength() {
        return accounts.size();
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
        int hash = Objects.hash(userName);
        //if(hash < 0) hash = hash*-1;
        return hash;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public String serialString() {
        return id + " " + firstName + " " + lastName + " " + userName + " " + password + " " + role;
    }
}
