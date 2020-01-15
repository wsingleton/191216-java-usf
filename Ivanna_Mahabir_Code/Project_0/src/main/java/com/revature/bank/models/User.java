package com.revature.bank.models;

import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String usrName;
    private String passWord;

    public User() {
        super();
    }

    public User(String firstName, String lastName, String usrName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.usrName = usrName;
        this.passWord = passWord;
    }

    public User(Integer userId, String firstName, String lastName, String usrName, String passWord) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.usrName = usrName;
        this.passWord = passWord;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    //test for a Capital Letter
    public static boolean uCase(char ch) {
        ch = Character.toUpperCase(ch);
        return ch >= 'A' && ch <= 'Z';
    }

    //test for a number
    public static boolean nCase(String passwor) {
        return Pattern.compile("[0-9]").matcher(passwor).find();
    }

    //Validation for username and password
    public static boolean validate(String arg) {
        if (arg.length() >= 8 && arg.length() <= 15) {
            for (int i = 0; i < arg.length(); i++) {
                char ch = arg.charAt(i);
                if (uCase(ch)) {
                    if (nCase(arg)) {
                        return true;
                    }
                    //break;
                }
            }
        }
        //System.out.println("Invalid Input");
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(usrName, user.usrName) &&
                Objects.equals(passWord, user.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, usrName, passWord);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", usrName='" + usrName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}