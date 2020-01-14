package com.revature.bank2.models;

import java.util.Objects;

public class User {


        String user_id;
        String username;
        String password;
        String email;
        String lastname;
        String firstname;

        public User() {

            super();
        }

        public User(User copy) {
            this.user_id = copy.user_id;
            this.username = copy.username;
            this.password = copy.password;
            this.lastname = copy.lastname;


        }

    public User(String user_id, String firstName, String lastName, String username, String password) {

            this.user_id = user_id;
            this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }


        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUserName() {
            return username;
        }

        public void setUserName(String userName) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(user_id, user.user_id) &&
                    Objects.equals(username, user.username) &&
                    Objects.equals(password, user.password) &&
                    Objects.equals(email, user.email) &&
                    Objects.equals(lastname, user.lastname) &&
                    Objects.equals(firstname, user.firstname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user_id, username, password, email, lastname, firstname);
        }

        @Override
        public String toString() {
            return "User{" +
                    "user_id='" + user_id + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", firstname='" + firstname + '\'' +
                    '}';
        }
    }

}
